package edu.chl.roborally.view.gui;

import edu.chl.roborally.EventTram;
import edu.chl.roborally.IEventHandler;
import edu.chl.roborally.controller.AppController;
import edu.chl.roborally.model.Player;
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

    @Override
    public void chooseCards(Player p) {

    }

    @Override
    public void onEvent(EventTram.Event evt, Object o) {
        if(EventTram.Event.INIT_GAME == evt){
            menu();
        } else if (EventTram.Event.SET_NAMES == evt) {
            chooseMap(new MapFactory().getMaps());
        } else if (EventTram.Event.SET_MAP == evt) {

        }
    }
}
