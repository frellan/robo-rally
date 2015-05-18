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

    public GUI() {
        main = new MainFrame();
        startMsg();
        EventTram.getInstance().register(this);
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

    private void showGamePanel() {
        main.remove(start);
        gamePanel = new GamePanel(model);
        main.add(gamePanel, BorderLayout.CENTER);
        main.revalidate();
        main.repaint();
    }

    public void chooseCards(Player player) {
        gamePanel.pickCards(player);
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
            case INIT_MODEL:
                this.model = (RoboRally) o;
                showSummary();
                break;
            case SHOW_GAMEPANEL:
                showGamePanel();
                break;
            case CHOOSE_CARDS:
                chooseCards((Player) o);
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
