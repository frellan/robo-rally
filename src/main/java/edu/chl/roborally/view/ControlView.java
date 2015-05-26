package edu.chl.roborally.view;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.cards.RegisterCard;
import edu.chl.roborally.utilities.EventTram;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
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
    private ImageIcon emptyNewCardIcon;

    private JPanel registerView;
    private JPanel turnIndicatorView;
    private JPanel pickCardsView;
    private JPanel statusView;
    private ArrayList<RegisterCard> newCardsToPick = new ArrayList<>();
    private ArrayList<PickNewCardButton> newCardsToPickButtons = new ArrayList<>();
    private RegisterCardIcon[] registerCardIcons = new RegisterCardIcon[5];

    private JLabel turnLabel1;
    private JLabel turnLabel2;
    private JLabel turnLabel3;
    private JLabel turnLabel4;
    private JLabel turnLabel5;

    private JButton powerDownButton;
    private JLabel lifeTokensLabel;
    private JLabel dmgTokensLabel;
    private JLabel positionLabel;
    protected JButton doneButton;
    protected JButton nextTurnButton;

    private static final int CARD_GAP = 7;

    public ControlView(Player player) {
        try {
            emptyNewCardIcon = new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResource("cards/empty_pick.png")));
        } catch (java.io.IOException | NullPointerException e){
            System.out.println("cards/empty_pick.png could not be read");
        }
        this.player = player;
        setLayout(null);
        setSize(984, 171);
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
            final RegisterCardIcon icon = new RegisterCardIcon();
            registerCardIcons[i] = icon;
            icon.setTransferHandler(new RegisterCardTransferHandler(null));
            icon.addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    if (icon.isChangeable()) {
                        RegisterCardIcon icon = (RegisterCardIcon) e.getSource();
                        TransferHandler handle = icon.getTransferHandler();
                        handle.exportAsDrag(icon, e, TransferHandler.COPY);
                    }
                }
            });
            registerView.add(icon).setLocation(gap, 6);
            gap += icon.getWidth() + CARD_GAP;
        }
        add(registerView).setLocation(0, 0);
    }
    private void createTurnIndicatorView() {
        turnIndicatorView = new JPanel(null);
        turnIndicatorView.setSize(508, 26);
        turnIndicatorView.setOpaque(false);
        turnLabel1 = new JLabel("Turn 1");
        turnLabel1.setForeground(Color.WHITE);
        turnLabel1.setSize(100, 22);
        turnLabel1.setFont(new Font(turnLabel1.getFont().getName(), Font.BOLD, 14));
        turnLabel2 = new JLabel("Turn 2");
        turnLabel2.setForeground(Color.WHITE);
        turnLabel2.setSize(100, 22);
        turnLabel2.setFont(new Font(turnLabel1.getFont().getName(), Font.BOLD, 14));
        turnLabel3 = new JLabel("Turn 3");
        turnLabel3.setForeground(Color.WHITE);
        turnLabel3.setFont(new Font(turnLabel1.getFont().getName(), Font.BOLD, 14));
        turnLabel3.setSize(100, 22);
        turnLabel4 = new JLabel("Turn 4");
        turnLabel4.setForeground(Color.WHITE);
        turnLabel4.setFont(new Font(turnLabel1.getFont().getName(), Font.BOLD, 14));
        turnLabel4.setSize(100, 22);
        turnLabel5 = new JLabel("Turn 5");
        turnLabel5.setForeground(Color.WHITE);
        turnLabel5.setFont(new Font(turnLabel1.getFont().getName(), Font.BOLD, 14));
        turnLabel5.setSize(100, 22);
        turnIndicatorView.add(turnLabel1).setLocation(25, 0);
        turnIndicatorView.add(turnLabel2).setLocation(128, 0);
        turnIndicatorView.add(turnLabel3).setLocation(232, 0);
        turnIndicatorView.add(turnLabel4).setLocation(335, 0);
        turnIndicatorView.add(turnLabel5).setLocation(437, 0);
        add(turnIndicatorView).setLocation(6, 146);
    }
    private void createPickCardsView() {
        pickCardsView = new JPanel(new GridLayout(9,1));
        pickCardsView.setSize(142, 171);
        pickCardsView.setBorder(new MatteBorder(0, 2, 0, 2, Color.BLACK));
        pickCardsView.setOpaque(false);
        refreshNewCardButtons();
        add(pickCardsView).setLocation(521, 0);
    }
    private void createStatusView() {
        statusView = new JPanel(new GridLayout(6,1));
        statusView.setSize(320, 171);
        statusView.setOpaque(false);
        powerDownButton = new JButton("PowerDown");
        lifeTokensLabel = new JLabel("LifeTokens: " + player.getLifeTokens(), SwingConstants.CENTER);
        lifeTokensLabel.setForeground(Color.WHITE);
        dmgTokensLabel = new JLabel("DamageTokens: " + player.getDamageTokens(), SwingConstants.CENTER);
        dmgTokensLabel.setForeground(Color.WHITE);
        positionLabel = new JLabel("PlayerPosition: " + player.getPosition(), SwingConstants.CENTER);
        positionLabel.setForeground(Color.WHITE);
        doneButton = new JButton("Done");
        doneButton.setEnabled(false);
        doneButton.addActionListener(this);
        nextTurnButton = new JButton("Next Turn");
        nextTurnButton.addActionListener(this);
        statusView.add(powerDownButton);
        statusView.add(lifeTokensLabel);
        statusView.add(dmgTokensLabel);
        statusView.add(positionLabel);
        statusView.add(doneButton);
        statusView.add(nextTurnButton);
        add(statusView).setLocation(668, 0);
    }
    private void refreshNewCardButtons() {
        newCardsToPickButtons.clear();
        pickCardsView.removeAll();
        for (int index = 0; index < 9; index++) {
            try {
                RegisterCard card = newCardsToPick.get(index);
                PickNewCardButton btn = new PickNewCardButton(card);
                btn.setTransferHandler(new RegisterCardTransferHandler(newCardsToPick.get(index).toString()));
                btn.addMouseMotionListener(new MouseAdapter() {
                    @Override
                    public void mouseDragged(MouseEvent e) {
                        if (!btn.isPicked()) {
                            JButton btn = (JButton) e.getSource();
                            TransferHandler handle = btn.getTransferHandler();
                            handle.exportAsDrag(btn, e, TransferHandler.COPY);
                        }
                    }
                });
                newCardsToPickButtons.add(btn);
                pickCardsView.add(btn);
            } catch (IndexOutOfBoundsException e) {
                PickNewCardButton btn = new PickNewCardButton();
                pickCardsView.add(btn);
            }
        }
    }

    /*
    Command Methods
     */
    public void resetRegisterCards() {
        for (int i = 0; i < 5; i++) {
            if (player.getProgrammedCard(i) != null && player.getProgrammedCard(i).isLocked()) {
                registerCardIcons[i].setCard(player.getProgrammedCard(i));
                registerCardIcons[i].setChangeable(false);
            } else {
                registerCardIcons[i].removeCard();
            }
        }
    }
    public void resetNewCardButtons() {
        pickCardsView.removeAll();
        for (int index = 0; index < 9; index++) {
            PickNewCardButton btn = new PickNewCardButton();
            pickCardsView.add(btn);
        }
    }
    public void newCardsToPick() {
        newCardsToPick = player.getDealtCards();
        refreshNewCardButtons();
    }
    public void setRegisterCardIconsChangeable() {
        for (RegisterCardIcon icon : registerCardIcons) {
            if (icon.getCard() != null && !icon.getCard().isLocked()) {
                icon.setChangeable(true);
            }
        }
    }
    public void setRegisterCardIconsNotChangeable() {
        for (RegisterCardIcon icon : registerCardIcons) {
            icon.setChangeable(false);
        }
    }
    public void setTurnIndicator(int turn) {
        switch (turn) {
            case 0:
                turnLabel1.setForeground(Color.WHITE);
                turnLabel2.setForeground(Color.WHITE);
                turnLabel3.setForeground(Color.WHITE);
                turnLabel4.setForeground(Color.WHITE);
                turnLabel5.setForeground(Color.WHITE);
                break;
            case 1:
                turnLabel1.setForeground(Color.RED);
                turnLabel2.setForeground(Color.WHITE);
                turnLabel3.setForeground(Color.WHITE);
                turnLabel4.setForeground(Color.WHITE);
                turnLabel5.setForeground(Color.WHITE);
                break;
            case 2:
                turnLabel1.setForeground(Color.WHITE);
                turnLabel2.setForeground(Color.RED);
                turnLabel3.setForeground(Color.WHITE);
                turnLabel4.setForeground(Color.WHITE);
                turnLabel5.setForeground(Color.WHITE);
                break;
            case 3:
                turnLabel1.setForeground(Color.WHITE);
                turnLabel2.setForeground(Color.WHITE);
                turnLabel3.setForeground(Color.RED);
                turnLabel4.setForeground(Color.WHITE);
                turnLabel5.setForeground(Color.WHITE);
                break;
            case 4:
                turnLabel1.setForeground(Color.WHITE);
                turnLabel2.setForeground(Color.WHITE);
                turnLabel3.setForeground(Color.WHITE);
                turnLabel4.setForeground(Color.RED);
                turnLabel5.setForeground(Color.WHITE);
                break;
            case 5:
                turnLabel1.setForeground(Color.WHITE);
                turnLabel2.setForeground(Color.WHITE);
                turnLabel3.setForeground(Color.WHITE);
                turnLabel4.setForeground(Color.WHITE);
                turnLabel5.setForeground(Color.RED);
                break;
        }
    }
    public void setDoneButtonEnabled(boolean b) {
        doneButton.setEnabled(b);
    }
    public void setNextTurnButtonEnabled(boolean b) {
        nextTurnButton.setEnabled(b);
    }
    public void updateStatusView() {
        lifeTokensLabel.setText("LifeTokens: " + player.getLifeTokens());
        dmgTokensLabel.setText("DamageTokens: " + player.getDamageTokens());
        positionLabel.setText("PlayerPosition: " + player.getPosition());
    }

    /*
    Getters
     */
    public ArrayList<RegisterCard> getProgrammedCards() {
        ArrayList<RegisterCard> temp = new ArrayList<>();
        for (RegisterCardIcon icon : registerCardIcons) {
            temp.add(icon.getCard());
        }
        return temp;
    }

    /*
    Help Methods and Classes
     */
    private boolean programmedCardsIsValid() {
        for (RegisterCardIcon card : registerCardIcons) {
            if (card.getCard() == null) {
                return false;
            }
        }
        return true;
    }
    private class RegisterCardIcon extends JLabel {

        private RegisterCard card;
        private boolean isChangeable = true;

        public RegisterCardIcon() {
            setBorder(new LineBorder(Color.BLACK, 2));
            setHorizontalAlignment(SwingConstants.CENTER);
            setVerticalAlignment(SwingConstants.CENTER);
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
            setOpaque(true);
            setText("<html>Drop card<br>here</html>");
            setSize(96, 140);
        }

        public RegisterCard getCard() {
            return card;
        }
        public void setCard(RegisterCard card) {
            this.card = card;
            setIcon(card.getMainIcon());
        }
        public void setChangeable(boolean b) {
            isChangeable = b;
        }
        public boolean isChangeable() {
            return isChangeable;
        }
        public void removeCard() {
            card = null;
            setIcon(null);
            setBackground(Color.WHITE);
            setText("<html>Drop card<br>here</html>");
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (card != null) {
                g.setColor(Color.WHITE);
                g.setFont(new Font("Impact", Font.PLAIN, 20));
                g.drawString(Integer.toString(card.getPoints()), 34, 27);
            }
        }
    }
    private class PickNewCardButton extends JButton {

        private RegisterCard card;
        private boolean picked;

        public PickNewCardButton() {
            setText("");
            setBorderPainted(false);
            setFocusPainted(false);
            setIcon(emptyNewCardIcon);
            setIconTextGap(0);
            setContentAreaFilled(false);
        }
        public PickNewCardButton(RegisterCard card) {
            this.card = card;
            setText(card.toString());
            setBorderPainted(false);
            setFocusPainted(false);
            setIcon(card.getPickIcon());
            setIconTextGap(0);
            setContentAreaFilled(false);
            setRolloverIcon(card.getPickIconRollover());
        }

        public RegisterCard getCard() {
            return card;
        }
        public boolean isPicked() {
            return picked;
        }
        public void setPicked(boolean b) {
            if (b) {
                setIcon(emptyNewCardIcon);
                setRolloverEnabled(false);
            } else {
                setIcon(card.getPickIcon());
                setRolloverEnabled(true);
            }
            picked = b;
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (card != null) {
                g.setColor(Color.WHITE);
                g.setFont(new Font("Impact", Font.ROMAN_BASELINE, 14));
                g.drawString(Integer.toString(card.getPoints()), 111, 15);
            }
        }
    }
    private class RegisterCardTransferHandler extends TransferHandler {

        public final DataFlavor SUPPORTED_DATE_FLAVOR = DataFlavor.stringFlavor;

        private String value;

        public RegisterCardTransferHandler(String value) {
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
            if (source.getClass() == PickNewCardButton.class) {
                if (action != TransferHandler.NONE) {
                    setPickedCard(((PickNewCardButton) source).getCard(), true);
                }
            }
            if (source.getClass() == RegisterCardIcon.class) {
                if (action != TransferHandler.NONE) {
                    ((RegisterCardIcon) source).removeCard();
                }
            }
        }

        /*
        Transfer stuff
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
                            RegisterCardIcon icon = ((RegisterCardIcon) component);
                            if (icon.getCard() != null) {
                                setPickedCard(icon.getCard(), false);
                            }
                            icon.setCard(getMatchingCard((String) value));
                            icon.setTransferHandler
                                    (new RegisterCardTransferHandler(icon.getCard().toString()));
                            accept = true;
                        }
                    }
                } catch (Exception exp) {
                    exp.printStackTrace();
                }
            }
            return accept;
        }

        /*
        Helper methods
         */
        private RegisterCard getMatchingCard(String value) {
            for (RegisterCard card : newCardsToPick) {
                if (card.toString().equals(value)) {
                    return card;
                }
            }
            return null;
        }
        private void setPickedCard(RegisterCard card, boolean b) {
            for (PickNewCardButton btn : newCardsToPickButtons) {
                if (btn.getText().equals(card.toString())) {
                    System.out.println(b);
                    btn.setPicked(b);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == doneButton) {
            if (programmedCardsIsValid()) {
                EventTram.getInstance().publish(EventTram.Event.PLAYER_PICKED_CARDS, getProgrammedCards(), null);
                doneButton.setEnabled(false);
            } else {
                EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, "Please choose 5 cards", Color.RED);
            }
        }
        if (e.getSource() == nextTurnButton){
            EventTram.getInstance().publish(EventTram.Event.READY_FOR_NEW_TURN, null, null);
        }
    }
}
