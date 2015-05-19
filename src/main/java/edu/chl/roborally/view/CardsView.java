package edu.chl.roborally.view;

import edu.chl.roborally.model.cards.RegisterCardIcon;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by fredrikkindstrom on 19/05/15.
 */
public class CardsView extends JPanel {

    private JPanel registerView;
    private JPanel pickCardsView;
    private RegisterCardIcon[] registerCardIcons = new RegisterCardIcon[5];

    private static final int CARD_WIDTH = 96;
    private static final int CARD_GAP = 10;

    public CardsView() {
        setLayout(null);
        setSize(760,170);
        createRegisterView();
        createPickCardsView();
    }

    private void createRegisterView() {
        registerView = new JPanel(null);
        registerView.setSize(560, 170);
        int gap = 6;
        for (int i = 0; i < 5; i++) {
            RegisterCardIcon temp = new RegisterCardIcon();
            registerCardIcons[i] = temp;
            registerView.add(temp).setLocation(gap, 10);
            gap += CARD_WIDTH + CARD_GAP;
        }
        add(registerView).setLocation(0, 0);
    }

    private void createPickCardsView() {
        pickCardsView = new JPanel(new GridLayout(9,1));
        pickCardsView.setSize(180, 170);
        add(pickCardsView).setLocation(561, 0);
        for (int index = 0; index < 9; index++) {
            JButton btn = new JButton(Integer.toString(index + 1));
            pickCardsView.add(btn);
            btn.setTransferHandler(new ValueExportTransferHandler(Integer.toString(index + 1)));

            btn.addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    JButton button = (JButton) e.getSource();
                    TransferHandler handle = button.getTransferHandler();
                    handle.exportAsDrag(button, e, TransferHandler.COPY);
                }
            });
        }
    }

    public static class ValueExportTransferHandler extends TransferHandler {

        public static final DataFlavor SUPPORTED_DATE_FLAVOR = DataFlavor.stringFlavor;
        private String value;

        public ValueExportTransferHandler(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public int getSourceActions(JComponent c) {
            return DnDConstants.ACTION_COPY_OR_MOVE;
        }

        @Override
        protected Transferable createTransferable(JComponent c) {
            Transferable t = new StringSelection(getValue());
            return t;
        }

        @Override
        protected void exportDone(JComponent source, Transferable data, int action) {
            super.exportDone(source, data, action);
            // Decide what to do after the drop has been accepted
        }

    }

    public static class ValueImportTransferHandler extends TransferHandler {

        public static final DataFlavor SUPPORTED_DATE_FLAVOR = DataFlavor.stringFlavor;

        public ValueImportTransferHandler() {
        }

        @Override
        public boolean canImport(TransferHandler.TransferSupport support) {
            return support.isDataFlavorSupported(SUPPORTED_DATE_FLAVOR);
        }

        @Override
        public boolean importData(TransferHandler.TransferSupport support) {
            boolean accept = false;
            if (canImport(support)) {
                try {
                    Transferable t = support.getTransferable();
                    Object value = t.getTransferData(SUPPORTED_DATE_FLAVOR);
                    if (value instanceof String) {
                        Component component = support.getComponent();
                        if (component instanceof JLabel) {
                            ((JLabel) component).setText(value.toString());
                            accept = true;
                        }
                    }
                } catch (Exception exp) {
                    exp.printStackTrace();
                }
            }
            return accept;
        }
    }

    public static void main (String[] args) {
        JFrame main = new JFrame();
        main.setSize(760, 190);
        JPanel panel = new CardsView();
        main.add(panel);
        main.setVisible(true);
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
