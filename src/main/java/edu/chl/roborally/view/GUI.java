package edu.chl.roborally.view;

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
public class GUI implements IEventHandler{

    private JFrame main;
    private StartPanel start;
    private RoboRally model;
    private GamePanel gamePanel;
    private ArrayList<GamePanel> gamePanels = new ArrayList<>();
    private JTabbedPane tabbedPane = new JTabbedPane();

    public GUI() {
        main = new MainFrame();
        EventTram.getInstance().register(this);
        startMsg();
    }

    public void startMsg() {
        start = new StartPanel();
        main.add(start, BorderLayout.CENTER);
        main.revalidate();
    }

    public void menu() {
        choosePlayerNames();
    }

    public void choosePlayerNames() {
        start.nbrOfPlayers();
    }

    public void chooseMap(ArrayList<String> maps) {
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
    public void onEvent(EventTram.Event evt, Object o) {
        switch (evt) {
            case INIT_SETUP:
                menu();
                break;
            case SET_NAMES:
                chooseMap(new MapFactory().getMaps());
                break;
            case CREATE_MODEL:
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
                gamePanel.getBoardView().repaint();
                break;
            case UPDATE_STATUS:
                gamePanel.getStatusView().repaint();
                break;
        }
    }
}
