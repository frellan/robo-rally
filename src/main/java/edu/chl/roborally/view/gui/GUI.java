package edu.chl.roborally.view.gui;

import edu.chl.roborally.EventTram;
import edu.chl.roborally.IEventHandler;
import edu.chl.roborally.controller.AppController;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.view.UI;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by axel on 2015-04-29.
 */
public class GUI extends UI implements IEventHandler{

    private JFrame main;
    private JPanel start;
    private JPanel setup;

    public GUI(AppController appController){
        super(appController);
        main = new MainFrame();

        startMsg();

        EventTram.getInstance().register(this);
    }

    @Override
    public void startMsg() {
        start = new StartPanel();
        main.add(start);
        main.revalidate();
    }

    @Override
    public void menu() {
        setup = new SetupPanel();
        appController.initGameController();
        main.remove(start);
        main.revalidate();
        main.add(setup);
        main.repaint();
        main.revalidate();

    }

    @Override
    public void choosePlayerNames() {

    }

    @Override
    public void chooseMap(ArrayList<String> maps) {

    }

    @Override
    public void chooseCards(Player p) {

    }

    @Override
    public void onEvent(EventTram.Event evt, Object o) {
        if(EventTram.Event.INIT_SETUP == evt){
            menu();
        }
    }
}
