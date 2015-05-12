package edu.chl.roborally.view.gui;

import edu.chl.roborally.utilities.EventTram;
import edu.chl.roborally.utilities.IEventHandler;
import edu.chl.roborally.controller.AppController;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.RoboRally;
import edu.chl.roborally.model.maps.MapFactory;
import edu.chl.roborally.view.UI;
import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by axel on 2015-04-29.
 */
public class GUI extends UI implements IEventHandler{

    private JFrame main;
    private StartPanel start;
    private RoboRally model;
    private GamePanel gamePanel;

    public GUI(AppController appController){
        super(appController);
        main = new MainFrame();
        startMsg();
        EventTram.getInstance().register(this);
    }

    @Override
    public void startMsg() {
        start = new StartPanel();
        main.setContentPane(start);
        main.revalidate();
    }

    @Override
    public void menu() {
        appController.initGameController();
        choosePlayerNames();
    }

    @Override
    public void choosePlayerNames() {
        start.nbrOfPlayers();
    }

    @Override
    public void chooseMap(ArrayList<String> maps) {
        start.chooseMap(maps);
    }

    private void showSummary() {
        start.summary(model.getPlayerNames(), model.getGameBoard().getName());
    }

    private void showGamePanel() {
        gamePanel = new GamePanel(model);
        main.remove(start);
        main.add(gamePanel);
        main.revalidate();
        main.repaint();
    }

    @Override
    public void chooseCards(Player player) {
        gamePanel.pickCards(player);
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
            case SET_MAP:
                break;
            case NEW_MODEL:
                this.model = (RoboRally) o;
                showSummary();
                break;
            case RUN_GAME:
                showGamePanel();
                break;
            case CHOOSE_CARDS:
                chooseCards((Player) o);
                break;
        }
    }
}
