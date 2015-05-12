package edu.chl.roborally.view.gui;

import edu.chl.roborally.utilities.EventTram;
import edu.chl.roborally.utilities.IEventHandler;
import edu.chl.roborally.controller.AppController;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.RoboRally;
import edu.chl.roborally.model.maps.MapFactory;
import edu.chl.roborally.view.UI;
import javafx.scene.layout.Border;

import javax.swing.*;
import java.awt.*;
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
        main.add(start, BorderLayout.CENTER);
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
        main.remove(start);
        gamePanel = new GamePanel(model);
        main.add(gamePanel, BorderLayout.CENTER);
        main.revalidate();
        main.repaint();
    }

    @Override
    public void chooseCards(Player player) {
        gamePanel.pickCards(player);
        main.revalidate();
        main.repaint();
    }

    @Override
    public void onEvent(EventTram.Event evt, Object o) {
        if(EventTram.Event.INIT_SETUP == evt){
            menu();
        } else if (EventTram.Event.SET_NAMES == evt) {
            chooseMap(new MapFactory().getMaps());
        } else if (EventTram.Event.NEW_MODEL == evt) {
            this.model = (RoboRally) o;
            showSummary();
        } else if (EventTram.Event.SHOW_GAMEPANEL == evt) {
            showGamePanel();
        } else if (EventTram.Event.CHOOSE_CARDS == evt) {
            chooseCards((Player) o);
        }
    }
}
