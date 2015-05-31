package edu.chl.roborally.view;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.cards.RegisterCard;
import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.utilities.EventTram;
import edu.chl.roborally.utilities.GlobalImageHolder;

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
 *
 * Holds all of the graphical controls for a single player in the game.
 */
class ControlView extends JPanel implements ActionListener{

    private final Player player;
    private ImageIcon hiddenCardIcon;
    private ImageIcon emptyNewCardIcon;

    private JPanel registerView;
    private JPanel turnIndicatorView;
    private JPanel pickCardsView;
    private JPanel statusView;
    private ArrayList<RegisterCard> newCardsToPick = new ArrayList<>();
    private ArrayList<PickNewCardButton> newCardsToPickButtons = new ArrayList<>();
    private final RegisterCardIcon[] registerCardIcons = new RegisterCardIcon[5];

    private JLabel turnLabel1;
    private JLabel turnLabel2;
    private JLabel turnLabel3;
    private JLabel turnLabel4;
    private JLabel turnLabel5;

    private JButton powerDownButton;
    private JLabel robotStatusLabel;
    private JLabel checkpointLabel;
    private LifeTokensPanel lifeTokensPanel;
    private DamageTokensPanel damageTokensPanel;
    private JButton doneButton;
    private JButton nextTurnButton;

    private static final int CARD_GAP = 7;

    /**
     * Creates the control view which is used by every player to control and program the robot.
     * Also contains information about the current status of the game.
     * @param player The unique player to create controls for.
     */
    ControlView(Player player) {
        try {
            hiddenCardIcon = new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResource("cards/hidden.png")));
            emptyNewCardIcon = new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResource("cards/empty_pick.png")));
        } catch (java.io.IOException | NullPointerException e){
            System.out.println("cards/empty_pick.png or cards/hidden.png could not be read");
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

    /**
     * These methods creates the individual panels of the
     * ControlView and adds them to the layout.
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
        turnIndicatorView.setSize(500, 26);
        turnIndicatorView.setOpaque(false);
        turnLabel1 = new JLabel("Turn 1");
        turnLabel1.setForeground(Color.WHITE);
        turnLabel1.setSize(60, 22);
        turnLabel1.setFont(new Font(turnLabel1.getFont().getName(), Font.BOLD, 14));
        turnLabel2 = new JLabel("Turn 2");
        turnLabel2.setForeground(Color.WHITE);
        turnLabel2.setSize(60, 22);
        turnLabel2.setFont(new Font(turnLabel1.getFont().getName(), Font.BOLD, 14));
        turnLabel3 = new JLabel("Turn 3");
        turnLabel3.setForeground(Color.WHITE);
        turnLabel3.setFont(new Font(turnLabel1.getFont().getName(), Font.BOLD, 14));
        turnLabel3.setSize(60, 22);
        turnLabel4 = new JLabel("Turn 4");
        turnLabel4.setForeground(Color.WHITE);
        turnLabel4.setFont(new Font(turnLabel1.getFont().getName(), Font.BOLD, 14));
        turnLabel4.setSize(60, 22);
        turnLabel5 = new JLabel("Turn 5");
        turnLabel5.setForeground(Color.WHITE);
        turnLabel5.setFont(new Font(turnLabel1.getFont().getName(), Font.BOLD, 14));
        turnLabel5.setSize(60, 22);
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
        statusView = new JPanel(null);
        statusView.setSize(321, 171);
        statusView.setOpaque(false);

        JLabel robotIcon = new JLabel(new ImageIcon(player.getImage()));
        robotIcon.setBorder(new LineBorder(Color.BLACK, 2));
        robotIcon.setSize(44, 44);
        statusView.add(robotIcon).setLocation(6, 6);

        JLabel playingAs = new JLabel("<html><FONT COLOR=WHITE>Playing as: </FONT>" + player.getName());
        playingAs.setSize(200, 20);
        playingAs.setFont(new Font("Impact", Font.PLAIN, 16));
        playingAs.setForeground(player.getColor());
        statusView.add(playingAs).setLocation(56, 8);

        powerDownButton = new JButton("<html>POWER<br>DOWN</html>");
        powerDownButton.setSize(52, 40);
        powerDownButton.setMargin(new Insets(0, 0, 0, 0));
        powerDownButton.setFocusPainted(false);
        powerDownButton.setFont(new Font(this.getFont().getName(), Font.BOLD, 11));
        powerDownButton.setBackground(Color.RED);
        powerDownButton.setForeground(Color.WHITE);
        powerDownButton.addActionListener(this);
        statusView.add(powerDownButton).setLocation(262, 6);

        lifeTokensPanel = new LifeTokensPanel();
        statusView.add(lifeTokensPanel).setLocation(56, 32);

        robotStatusLabel = new JLabel("<html><FONT COLOR=WHITE>Status: </FONT>" + player.getStatus());
        robotStatusLabel.setSize(200, 20);
        robotStatusLabel.setFont(new Font("Impact", Font.PLAIN, 14));
        robotStatusLabel.setForeground(Color.GREEN);
        statusView.add(robotStatusLabel).setLocation(9, 94);

        checkpointLabel = new JLabel("Checkpoints cleared: " + player.getCheckpointID() + "/3");
        checkpointLabel.setSize(200, 20);
        checkpointLabel.setFont(new Font("Impact", Font.ROMAN_BASELINE, 14));
        checkpointLabel.setForeground(Color.WHITE);
        statusView.add(checkpointLabel).setLocation(9, 114);

        damageTokensPanel = new DamageTokensPanel();
        statusView.add(damageTokensPanel).setLocation(5, 54);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.setSize(308, 24);
        doneButton = new JButton("Done");
        doneButton.setEnabled(false);
        doneButton.addActionListener(this);
        buttonPanel.add(doneButton);
        nextTurnButton = new JButton("Next Turn");
        nextTurnButton.addActionListener(this);
        buttonPanel.add(nextTurnButton);
        statusView.add(buttonPanel).setLocation(6, 141);

        add(statusView).setLocation(663, 0);
    }

    /**
     * When the player receives new cards this method is called to update
     * the list of cards to choose from with new data.
     */
    private void refreshNewCardButtons() {
        newCardsToPickButtons.clear();
        pickCardsView.removeAll();
        for (int index = 0; index < 9; index++) {
            try {
                RegisterCard card = newCardsToPick.get(index);
                final PickNewCardButton btn = new PickNewCardButton(card);
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
    Commands
     */

    /**
     * Is called by the GUI class when a new round is initiated
     * to reset the register card panel. This is done to prepare for the new
     * cards that will be placed there.
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

    /**
     * Is called by the GUI class when a new round is initiated
     * to reset the list of cards to choose from before receiving new ones.
     */
    public void resetNewCardButtons() {
        pickCardsView.removeAll();
        for (int index = 0; index < 9; index++) {
            PickNewCardButton btn = new PickNewCardButton();
            pickCardsView.add(btn);
        }
    }

    /**
     * Is called by the GUI class when the PICK_CARDS event is fired.
     * It tells this class to update necessary components with the new data.
     */
    public void newCardsToPick() {
        newCardsToPick = player.getDealtCards();
        refreshNewCardButtons();
    }

    /**
     * Sets the register card icons to be changeable.
     * This means you can drag n drop onto them.
     */
    public void setRegisterCardIconsChangeable() {
        for (RegisterCardIcon icon : registerCardIcons) {
            if (icon.getCard() != null && !icon.getCard().isLocked()) {
                icon.setChangeable(true);
            }
        }
    }

    /**
     * Sets the register card icons to not be changeable.
     * This means you can't drag n drop onto them.
     */
    public void setRegisterCardIconsNotChangeable() {
        for (RegisterCardIcon icon : registerCardIcons) {
            icon.setChangeable(false);
        }
    }

    /**
     * Sets which turn to be displayed in the interface.
     * @param turn The turn to be displayed.
     */
    public void setTurnIndicator(int turn) {
        turnLabel1.setForeground(Color.WHITE);
        turnLabel2.setForeground(Color.WHITE);
        turnLabel3.setForeground(Color.WHITE);
        turnLabel4.setForeground(Color.WHITE);
        turnLabel5.setForeground(Color.WHITE);
        switch (turn) {
            case 0:
                break;
            case 1:
                turnLabel1.setForeground(Color.RED);
                break;
            case 2:
                turnLabel2.setForeground(Color.RED);
                break;
            case 3:
                turnLabel3.setForeground(Color.RED);
                break;
            case 4:
                turnLabel4.setForeground(Color.RED);
                break;
            case 5:
                turnLabel5.setForeground(Color.RED);
                break;
        }
    }

    /**
     * Sets if the done button should be enabled.
     * @param b True to enable, false to disable.
     */
    public void setDoneButtonEnabled(boolean b) {
        doneButton.setEnabled(b);
    }

    /**
     * Sets if the next turn button should be enabled.
     * @param b True to enable, false to disable.
     */
    public void setNextTurnButtonEnabled(boolean b) {
        nextTurnButton.setEnabled(b);
    }

    /**
     * Sets if the power down button should be enabled.
     * @param b True to enable, false to disable.
     */
    public void setPowerDownButtonEnabled(boolean b) {
        powerDownButton.setEnabled(b);
    }

    /**
     * Updates the data inside the status view
     * i.e damage tokens, player positions etc.
     */
    public void updateStatusView() {
        lifeTokensPanel.setLifeTokens(player.getLifeTokens());
        robotStatusLabel.setText("<html><FONT COLOR=WHITE>Status: </FONT>" + player.getStatus());
        switch (player.getStatus()) {
            case ALIVE:
                robotStatusLabel.setForeground(Color.GREEN);
                break;
            case DEAD:
                robotStatusLabel.setForeground(Color.RED);
                break;
            case POWERDOWN:
                robotStatusLabel.setForeground(Color.ORANGE);
                break;
            case KAPUT:
                robotStatusLabel.setForeground(Color.BLACK);
                break;
        }
        checkpointLabel.setText("Checkpoints cleared: " + player.getCheckpointID() + "/3");
        damageTokensPanel.setDamageTokens(player.getDamageTokens());
    }

    /*
    Help Methods and Classes
     */

    /**
     * Is used to check if the player have chosen the required amount
     * of register cards before sending them of to the model.
     * @return True if correct amount, false if not.
     */
    private boolean programmedCardsIsValid() {
        for (RegisterCardIcon card : registerCardIcons) {
            if (card.getCard() == null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Is used to package the chosen register cards to an ArrayList.
     * @return The cards currently in the register panel.
     */
    private ArrayList<RegisterCard> getProgrammedCards() {
        ArrayList<RegisterCard> temp = new ArrayList<>();
        for (RegisterCardIcon icon : registerCardIcons) {
            temp.add(icon.getCard());
        }
        return temp;
    }

    /**
     * A modified JLabel component used to display the register cards in the register panel.
     */
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

    /**
     * A modified JButton component used to display the register card to choose from.
     */
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
            if (card != null && !picked) {
                g.setColor(Color.WHITE);
                g.setFont(new Font("Impact", Font.ROMAN_BASELINE, 14));
                g.drawString(Integer.toString(card.getPoints()), 111, 15);
            }
        }
    }

    /**
     * JPanel containing the damage token icons and the logic for showing the correct amount.
     */
    private class DamageTokensPanel extends JPanel {

        private final ImageIcon set1DisabledIcon = new ImageIcon(GlobalImageHolder.getInstance().getDamageTokens().getSubimage(0, 0, 34, 40));
        private final ImageIcon set1EnabledIcon = new ImageIcon(GlobalImageHolder.getInstance().getDamageTokens().getSubimage(34, 0, 34, 40));
        private final ImageIcon set2DisabledIcon = new ImageIcon(GlobalImageHolder.getInstance().getDamageTokens().getSubimage(68, 0, 34, 40));
        private final ImageIcon set2EnabledIcon = new ImageIcon(GlobalImageHolder.getInstance().getDamageTokens().getSubimage(102, 0, 34, 40));
        private final ImageIcon set3DisabledIcon = new ImageIcon(GlobalImageHolder.getInstance().getDamageTokens().getSubimage(136, 0, 34, 40));
        private final ImageIcon set3EnabledIcon = new ImageIcon(GlobalImageHolder.getInstance().getDamageTokens().getSubimage(170, 0, 34, 40));

        private final JLabel dmgToken1;
        private final JLabel dmgToken2;
        private final JLabel dmgToken3;
        private final JLabel dmgToken4;
        private final JLabel dmgToken5;
        private final JLabel dmgToken6;
        private final JLabel dmgToken7;
        private final JLabel dmgToken8;
        private final JLabel dmgToken9;
        private final JLabel dmgToken10;

        private DamageTokensPanel() {
            setSize(340, 40);
            setLayout(null);
            setOpaque(false);
            dmgToken1 = new JLabel(set1DisabledIcon);
            dmgToken1.setSize(34, 40);
            add(dmgToken1).setLocation(0, 0);
            dmgToken2 = new JLabel(set1DisabledIcon);
            dmgToken2.setSize(34, 40);
            add(dmgToken2).setLocation(32, 0);
            dmgToken3 = new JLabel(set1DisabledIcon);
            dmgToken3.setSize(34, 40);
            add(dmgToken3).setLocation(64, 0);
            dmgToken4 = new JLabel(set1DisabledIcon);
            dmgToken4.setSize(34, 40);
            add(dmgToken4).setLocation(95, 0);
            dmgToken5 = new JLabel(set2DisabledIcon);
            dmgToken5.setSize(34, 40);
            add(dmgToken5).setLocation(126, 0);
            dmgToken6 = new JLabel(set2DisabledIcon);
            dmgToken6.setSize(34, 40);
            add(dmgToken6).setLocation(156, 0);
            dmgToken7 = new JLabel(set2DisabledIcon);
            dmgToken7.setSize(34, 40);
            add(dmgToken7).setLocation(186, 0);
            dmgToken8 = new JLabel(set2DisabledIcon);
            dmgToken8.setSize(34, 40);
            add(dmgToken8).setLocation(216, 0);
            dmgToken9 = new JLabel(set2DisabledIcon);
            dmgToken9.setSize(34, 40);
            add(dmgToken9).setLocation(246, 0);
            dmgToken10 = new JLabel(set3DisabledIcon);
            dmgToken10.setSize(34, 40);
            add(dmgToken10).setLocation(276, 0);
        }

        private void setDamageTokens(int amount) {
            dmgToken1.setIcon(set1DisabledIcon);
            dmgToken2.setIcon(set1DisabledIcon);
            dmgToken3.setIcon(set1DisabledIcon);
            dmgToken4.setIcon(set1DisabledIcon);
            dmgToken5.setIcon(set2DisabledIcon);
            dmgToken6.setIcon(set2DisabledIcon);
            dmgToken7.setIcon(set2DisabledIcon);
            dmgToken8.setIcon(set2DisabledIcon);
            dmgToken9.setIcon(set2DisabledIcon);
            dmgToken10.setIcon(set3DisabledIcon);
            switch (amount) {
                case 10: dmgToken10.setIcon(set3EnabledIcon);
                case 9: dmgToken9.setIcon(set2EnabledIcon);
                case 8: dmgToken8.setIcon(set2EnabledIcon);
                case 7: dmgToken7.setIcon(set2EnabledIcon);
                case 6: dmgToken6.setIcon(set2EnabledIcon);
                case 5: dmgToken5.setIcon(set2EnabledIcon);
                case 4: dmgToken4.setIcon(set1EnabledIcon);
                case 3: dmgToken3.setIcon(set1EnabledIcon);
                case 2: dmgToken2.setIcon(set1EnabledIcon);
                case 1: dmgToken1.setIcon(set1EnabledIcon);
            }
        }
    }

    /**
     * JPanel containing the life token icons and the logic for showing the correct amount.
     */
    private class LifeTokensPanel extends JPanel {

        private final Image emptyHeart = GlobalImageHolder.getInstance().getHeartTokens().getSubimage(0, 0, 7, 7).getScaledInstance(14, 14, Image.SCALE_FAST);
        private final Image fullHeart = GlobalImageHolder.getInstance().getHeartTokens().getSubimage(7, 0, 7, 7).getScaledInstance(14, 14, Image.SCALE_FAST);
        private final ImageIcon emptyHeartIcon = new ImageIcon(emptyHeart);
        private final ImageIcon fullHeartIcon = new ImageIcon(fullHeart);

        private final JLabel lifeToken1;
        private final JLabel lifeToken2;
        private final JLabel lifeToken3;

        private LifeTokensPanel() {
            setSize(50, 14);
            setLayout(null);
            setOpaque(false);
            lifeToken1 = new JLabel(fullHeartIcon);
            lifeToken1.setSize(14, 14);
            add(lifeToken1).setLocation(0, 0);
            lifeToken2 = new JLabel(fullHeartIcon);
            lifeToken2.setSize(14, 14);
            add(lifeToken2).setLocation(17, 0);
            lifeToken3 = new JLabel(fullHeartIcon);
            lifeToken3.setSize(14, 14);
            add(lifeToken3).setLocation(34, 0);
        }

        private void setLifeTokens(int amount) {
            lifeToken1.setIcon(emptyHeartIcon);
            lifeToken2.setIcon(emptyHeartIcon);
            lifeToken3.setIcon(emptyHeartIcon);
            switch (amount) {
                case 3: lifeToken3.setIcon(fullHeartIcon);
                case 2: lifeToken2.setIcon(fullHeartIcon);
                case 1: lifeToken1.setIcon(fullHeartIcon);
            }
        }
    }

    /**
     * A modified TransferHandler used to transfer register card information between panels.
     * This is done using strings.
     */
    private class RegisterCardTransferHandler extends TransferHandler {

        public final DataFlavor SUPPORTED_DATE_FLAVOR = DataFlavor.stringFlavor;

        private final String value;

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
            return new StringSelection(getValue());
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
                            if (icon.getCard() != null && !icon.isChangeable && icon.card.isLocked()) {
                                return false;
                            }
                            if (icon.getCard() != null) {
                                setPickedCard(icon.getCard(), false);
                            }
                            try {
                                icon.setCard(getMatchingCard((String) value));
                            } catch (NullPointerException e) {
                                return false;
                            }
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
        if (e.getSource() == powerDownButton) {
            EventTram.getInstance().publish(EventTram.Event.POWER_DOWN, player, null);
        }
    }
}
