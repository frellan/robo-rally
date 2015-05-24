package edu.chl.roborally.view;

import edu.chl.roborally.model.maps.GameBoard;
import edu.chl.roborally.utilities.EventTram;
import edu.chl.roborally.utilities.IEventHandler;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.RoboRally;
import edu.chl.roborally.model.maps.MapFactory;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by axel on 2015-04-29.
 */
public class GUI implements IEventHandler {

    private JFrame mainFrame;
    private StartPanel startPanel;
    private RoboRally model;
    private ArrayList<GamePanel> gamePanels = new ArrayList<>();
    private JTabbedPane tabbedPane = new JTabbedPane();
    private int turnIndex = 1;

    public GUI() {
        mainFrame = new MainFrame();
        EventTram.getInstance().register(this);
        showStartPanel();
    }

    /*
    Menu related methods
     */
    public void showStartPanel() {
        startPanel = new StartPanel();
        mainFrame.add(startPanel, BorderLayout.CENTER);
        mainFrame.revalidate();
    }
    public void selectPlayers() {
        startPanel.nbrOfPlayers();
    }
    public void chooseMap(ArrayList<GameBoard> maps) {
        startPanel.chooseMap(maps);
    }
    private void showSummary() {
        startPanel.summary(model.getPlayerNames());
    }

    /*
    Create game screens
     */
    private void createGamePanels() {
        for (Player player : model.getPlayers()) {
            gamePanels.add(new GamePanel(model.getGameBoard(),model.getPlayers(),player));
        }
    }
    private void createTabbedPane() {
        for (GamePanel panel : gamePanels) {
            tabbedPane.addTab(panel.getPlayer().getName(),panel);
        }
    }
    private void showGamePanels() {
        mainFrame.remove(startPanel);
        mainFrame.add(tabbedPane, BorderLayout.CENTER);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    /*
    Game related methods
     */
    private void setGamePanelsForNewRound() {
        for (GamePanel panel : gamePanels) {
            panel.getControlView().setTurnIndicator(0);
            panel.getControlView().resetRegisterCards();
            panel.getControlView().resetNewCardButtons();
            panel.getControlView().setRegisterCardIconsChangeable(true);
            panel.getControlView().setNextTurnButtonEnabled(false);
        }
        turnIndex = 1;
    }
    private void pickCards(Player player) {
        for (GamePanel panel : gamePanels) {
            if (panel.getPlayer().getiD() == player.getiD()) {
                panel.getControlView().newCardsToPick(player);
                panel.getControlView().setDoneButtonEnabled(true);
            }
        }
    }
    private void setGamePanelsForNewTurn() {
        for (GamePanel panel : gamePanels) {
            panel.getControlView().setTurnIndicator(turnIndex);
            panel.getControlView().setRegisterCardIconsChangeable(false);
            panel.getControlView().setDoneButtonEnabled(false);
            panel.getControlView().setNextTurnButtonEnabled(true);
        }
        turnIndex++;
    }

    @Override
    public void onEvent(EventTram.Event evt, Object o, Object o2) {
        switch (evt) {
            case SHOW_MENU:
                selectPlayers();
                break;
            case SET_ROBOTS:
                chooseMap(MapFactory.getInstance().getMaps());
                break;
            case NEW_MODEL_CREATED:
                this.model = (RoboRally) o;
                showSummary();
                break;
            case SHOW_GAMEPANEL:
                createGamePanels();
                createTabbedPane();
                showGamePanels();
                break;
            case NEW_ROUND:
                setGamePanelsForNewRound();
                break;
            case PICK_CARDS:
                pickCards((Player) o);
                break;
            case NEW_TURN:
                setGamePanelsForNewTurn();
                break;
            case UPDATE_BOARD:
                for(GamePanel panel : gamePanels)
                    panel.getBoardView().repaint();
                break;
        }
    }
}
