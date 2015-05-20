package edu.chl.roborally.view;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.cards.RegisterCard;
import edu.chl.roborally.model.cards.RegisterCardIcon;
import edu.chl.roborally.utilities.EventTram;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Created by axel on 2015-05-06.
 */
public class ControlView extends JPanel implements ActionListener{

    private Player player;

    private JPanel registerView;
    private JPanel turnIndicatorView;
    private JPanel pickCardsView;
    private JPanel statusView;
    private RegisterCard[] newCardsToPick = new RegisterCard[9];
    private RegisterCardIcon[] registerCardIcons = new RegisterCardIcon[5];

    private JButton powerDown;
    private JLabel lifeTokens;
    private JLabel dmgTokens;
    private JLabel position;
    protected JButton done;
    protected JButton nextTurn;

    private static final int CARD_GAP = 7;

    public ControlView(Player player) {
        this.player = player;
        setLayout(null);
        setSize(984, 170);
        setBackground(Color.DARK_GRAY);
        createRegisterView();
        createTurnIndicatorView();
        createPickCardsView();
        createStatusView();
    }


    /*
    Class Methods
     */

    private void createRegisterView() {
        registerView = new JPanel(null);
        registerView.setSize(521, 146);
        registerView.setOpaque(false);
        int gap = 6;
        for (int i = 0; i < 5; i++) {
            RegisterCardIcon temp = new RegisterCardIcon();
            registerCardIcons[i] = temp;
            temp.setTransferHandler(new StringTransferHandler(null));
            temp.addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    RegisterCardIcon button = (RegisterCardIcon) e.getSource();
                    TransferHandler handle = button.getTransferHandler();
                    handle.exportAsDrag(button, e, TransferHandler.COPY);
                }
            });
            registerView.add(temp).setLocation(gap, 6);
            gap += temp.getWidth() + CARD_GAP;
        }
        add(registerView).setLocation(0, 0);
    }
    private void createTurnIndicatorView() {
        turnIndicatorView = new JPanel(null);
        turnIndicatorView.setSize(521, 24);
        turnIndicatorView.setOpaque(false);
        add(turnIndicatorView).setLocation(0, 147);
    }
    private void createPickCardsView() {
        pickCardsView = new JPanel(new GridLayout(9,1));
        pickCardsView.setSize(136, 170);
        pickCardsView.setOpaque(false);
        refreshNewCardButtons();
        add(pickCardsView).setLocation(522, 0);
    }
    private void createStatusView() {
        statusView = new JPanel(new GridLayout(6,1));
        statusView.setSize(320, 170);
        statusView.setOpaque(false);
        add(statusView).setLocation(668, 0);

        powerDown = new JButton("PowerDown");
        lifeTokens = new JLabel("LifeTokens: " + player.getLifeTokens(), SwingConstants.CENTER);
        lifeTokens.setForeground(Color.WHITE);
        dmgTokens = new JLabel("DamageTokens: " + player.getDamageTokens(), SwingConstants.CENTER);
        dmgTokens.setForeground(Color.WHITE);
        position = new JLabel("PlayerPosition: " + player.getPosition(), SwingConstants.CENTER);
        position.setForeground(Color.WHITE);
        done = new JButton("Done");
        done.addActionListener(this);
        nextTurn = new JButton("Next Turn");
        nextTurn.addActionListener(this);

        statusView.add(powerDown);
        statusView.add(lifeTokens);
        statusView.add(dmgTokens);
        statusView.add(position);
        statusView.add(done);
        statusView.add(nextTurn);
    }
    private void refreshNewCardButtons() {
        pickCardsView.removeAll();
        for (int index = 0; index < 9; index++) {
            if (newCardsToPick[index] != null) {
                JButton btn = new JButton(newCardsToPick[index].toString());
                pickCardsView.add(btn);
                btn.setTransferHandler(new StringTransferHandler(newCardsToPick[index].toString()));

                btn.addMouseMotionListener(new MouseAdapter() {
                    @Override
                    public void mouseDragged(MouseEvent e) {
                        JButton button = (JButton) e.getSource();
                        TransferHandler handle = button.getTransferHandler();
                        handle.exportAsDrag(button, e, TransferHandler.COPY);
                    }
                });
            } else {
                JButton btn = new JButton("Empty");
                pickCardsView.add(btn);
            }
        }
    }

    /*
    Command Methods
     */

    public ArrayList<RegisterCard> getProgrammedCards() {
        ArrayList<RegisterCard> temp = new ArrayList<>();
        for (RegisterCardIcon icon : registerCardIcons) {
            temp.add(icon.getCard());
        }
        return temp;
    }
    public void newCardsToPick(Player player) {
        newCardsToPick = convertToArray(player.getDealtCards());
        refreshNewCardButtons();
        revalidate();
        repaint();
    }
    public boolean programmedCardsIsValid() {
        for (RegisterCardIcon card : registerCardIcons) {
            if (card.getCard() == null) {
                return false;
            }
        }
        return true;
    }

    /*
    Help Methods and Classes
     */

    private RegisterCard[] convertToArray(ArrayList<RegisterCard> input) {
        RegisterCard[] temp = new RegisterCard[9];
        for (int i = 0; i < 9; i++) {
            try {
                temp[i] = input.get(i);
            } catch (IndexOutOfBoundsException e) {
                temp[i] = null;
            }
        }
        return temp;
    }
    private RegisterCard getMatchingCard(String value) {
        for (RegisterCard card : newCardsToPick) {
            if (card.toString().equals(value)) {
                return card;
            }
        }
        return null;
    }
    private class StringTransferHandler extends TransferHandler {

        public final DataFlavor SUPPORTED_DATE_FLAVOR = DataFlavor.stringFlavor;
        private String value;

        public StringTransferHandler(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        /*
        Export stuff
         */

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
            try {
                ((RegisterCardIcon) source).removeCard();
            } catch (ClassCastException e) {}
        }

        /*
        Import stuff
         */

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
                        if (component instanceof RegisterCardIcon) {
                            ((RegisterCardIcon) component).setCard(getMatchingCard((String) value));
                            ((RegisterCardIcon) component).setTransferHandler
                                    (new StringTransferHandler(((RegisterCardIcon) component).getCard().toString()));
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == done) {
            if (programmedCardsIsValid()) {
                EventTram.getInstance().publish(EventTram.Event.PLAYER_CHOOSEN_CARDS, getProgrammedCards(), null);
                nextTurn.setEnabled(true);
            } else {
                EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, "Please choose 5 cards", null);
            }
        }
        if (e.getSource() == nextTurn){
            EventTram.getInstance().publish(EventTram.Event.NEW_TURN, null, null);
        }
    }
}
