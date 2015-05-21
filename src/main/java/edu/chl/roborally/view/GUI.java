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

    private JFrame main;
    private StartPanel start;
    private RoboRally model;
    private ArrayList<GamePanel> gamePanels = new ArrayList<>();
    private JTabbedPane tabbedPane = new JTabbedPane();

    public GUI() {
        main = new MainFrame();
        EventTram.getInstance().register(this);
        menu();
    }

    /**
     * Shows start menu
     */
    public void menu() {
        start = new StartPanel();
        main.add(start, BorderLayout.CENTER);
        main.revalidate();
    }

    /**
     * Set how many players the game should have
     */
    public void selectPlayers() {
        start.nbrOfPlayers();
    }

    /**
     * Choose Map
     * @param maps
     */
    public void chooseMap(ArrayList<GameBoard> maps) {
        start.chooseMap(maps);
    }

    private void showSummary() {
        start.summary(model.getPlayerNames(), model.getGameBoard().getName());
    }

    private void createGamePanels() {
        for (Player player : model.getPlayers()) {
            gamePanels.add(new GamePanel(model.getGameBoard(),model.getPlayers(),player));
        }
        createTabbedPane();
    }

    private void createTabbedPane() {
        for (GamePanel panel : gamePanels) {
            tabbedPane.addTab(panel.getPlayer().getName(),panel);
        }
        showGamePanels();
    }

    private void showGamePanels() {
        main.remove(start);
        main.add(tabbedPane, BorderLayout.CENTER);
        main.setSize(1022, 790);
        main.revalidate();
        main.repaint();
    }

    public void pickCards(Player player) {
        for (GamePanel panel : gamePanels) {
            if (panel.getPlayer().getiD() == player.getiD()) {
                panel.pickCards();
            }
        }
        main.revalidate();
        main.repaint();
    }

    @Override
    public void onEvent(EventTram.Event evt, Object o, Object o2) {
        switch (evt) {
            case SELECT_PLAYERS:
                selectPlayers();
                break;
            case SET_NBR_OF_ROBOTS:
                chooseMap(MapFactory.getInstance().getMaps());
                break;
            case NEW_MODEL:
                this.model = (RoboRally) o;
                showSummary();
                break;
            case SHOW_GAMEPANEL:
                createGamePanels();
                break;
            case CHOOSE_CARDS:
                pickCards((Player) o);
                break;
            case UPDATE_BOARD:
                for(GamePanel panel : gamePanels)
                    panel.getBoardView().repaint();
                break;
            //showCardsAndStatus not used yet --> Status View not initialized
            /*case UPDATE_STATUS:
                for(GamePanel panel : gamePanels)
                    panel.getControlView().getStatusView().repaint();
                break;*/
        }
    }
}
