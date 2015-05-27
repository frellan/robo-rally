package edu.chl.roborally.controller;

import edu.chl.roborally.model.maps.GameBoard;
import edu.chl.roborally.utilities.EventTram;
import edu.chl.roborally.utilities.IEventHandler;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.RoboRally;
import edu.chl.roborally.model.maps.MapFactory;
import edu.chl.roborally.view.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by axel on 2015-04-29.
 *
 * Control class for the entire view package.
 * This tells the GUI what to display and when to do it.
 */
public class GUIController implements IEventHandler {

    private JFrame mainFrame;
    private StartPanel startPanel;
    private SelectMapPanel selectMapPanel;
    private SelectPlayersPanel selectPlayersPanel;
    private RoboRally model;
    private ArrayList<GamePanel> gamePanels = new ArrayList<>();
    private JTabbedPane tabbedPane = new JTabbedPane();
    private int turnIndex = 1;

    /**
     * Creates the class and creates a main frame to add all the upcoming components to.
     * Also registers it to listen for events coming from the view and model packages.
     */
    public GUIController() {
        mainFrame = new MainFrame();
        EventTram.getInstance().register(this);
        showStartPanel();
    }

    /*
    Menu related methods
     */

    /**
     * Creates a start panel and shows it in the main window.
     * This is essentially the main menu.
     */
    private void showStartPanel() {
        startPanel = new StartPanel();
        mainFrame.add(startPanel, BorderLayout.CENTER);
        mainFrame.revalidate();
    }

    /**
     * Creates a panel to choose the number of players that is
     * gonna play the game and shows it in the main window.
     */
    private void selectPlayers() {
        selectPlayersPanel = new SelectPlayersPanel();
        mainFrame.remove(startPanel);
        mainFrame.add(selectPlayersPanel, BorderLayout.CENTER);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    /**
     * Creates a panel to choose the map to play the game on.
     * Passes on a list of all the maps available.
     * That list is coming from the event that issued this method.
     * @param maps A list of all available maps.
     */
    private void chooseMap(ArrayList<GameBoard> maps) {
        selectMapPanel = new SelectMapPanel(maps);
        mainFrame.remove(selectPlayersPanel);
        mainFrame.add(selectMapPanel, BorderLayout.CENTER);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    /**
     * Tells the map panel to show a summary of the game that is about to start.
     */
    private void showSummary() {
        selectMapPanel.summary(model.getPlayers());
    }

    /*
    Create game screens
     */

    /**
     * Creates the game panels for the game. One for each player in the game.
     */
    private void createGamePanels() {
        for (Player player : model.getPlayers()) {
            gamePanels.add(new GamePanel(model.getBoard(),model.getPlayers(),player));
        }
    }

    /**
     * Adds the game panels to a tabbed pane to use in the upcoming game screen.
     * One tab for every player in the game containing that players game panel.
     */
    private void createTabbedPane() {
        for (GamePanel panel : gamePanels) {
            tabbedPane.addTab(panel.getPlayer().getName(),panel);
        }
    }

    /**
     * Shows the tabbed pane containing all the players game panels i the main window.
     */
    private void showGamePanels() {
        mainFrame.remove(selectMapPanel);
        mainFrame.add(tabbedPane, BorderLayout.CENTER);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    /*
    Game related methods
     */

    /**
     * Loops through the game panels and sets their components for a new round.
     */
    private void setGamePanelsForNewRound() {
        for (GamePanel panel : gamePanels) {
            panel.getControlView().setTurnIndicator(0);
            panel.getControlView().resetRegisterCards();
            panel.getControlView().resetNewCardButtons();
            panel.getControlView().setNextTurnButtonEnabled(false);
        }
        turnIndex = 1;
    }

    /**
     * Loops through the game panels to find the panel that belong to the given player.
     * When found it sets that panel to pick cards for the player.
     * @param player The player to pick cards.
     */
    private void newCardsForPlayer(Player player) {
        for (GamePanel panel : gamePanels) {
            if (panel.getPlayer().getID() == player.getID()) {
                panel.getControlView().newCardsToPick();
                panel.getControlView().setRegisterCardIconsChangeable();
                panel.getControlView().setDoneButtonEnabled(true);
            }
        }
    }

    /**
     * Loops through the game panels and sets their components for a new turn.
     */
    private void setGamePanelsForNewTurn() {
        for (GamePanel panel : gamePanels) {
            panel.getControlView().setTurnIndicator(turnIndex);
            panel.getControlView().setRegisterCardIconsNotChangeable();
            panel.getControlView().resetNewCardButtons();
            panel.getControlView().setDoneButtonEnabled(false);
            panel.getControlView().setNextTurnButtonEnabled(true);
        }
        turnIndex++;
    }

    @Override
    public void onEvent(EventTram.Event evt, Object o, Object o2) {
        switch (evt) {
            case SELECT_PLAYERS:
                selectPlayers();
                break;
            case PLAYERS_SELECTED:
                chooseMap(MapFactory.getInstance().getMaps());
                break;
            case MODEL_CREATED:
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
                newCardsForPlayer((Player) o);
                break;
            case NEW_TURN:
                setGamePanelsForNewTurn();
                break;
            case UPDATE_BOARD:
                for(GamePanel panel : gamePanels)
                    panel.getBoardView().update();
                break;
            case UPDATE_STATUS:
                for(GamePanel panel : gamePanels)
                    panel.getControlView().updateStatusView();
                break;
        }
    }
}
