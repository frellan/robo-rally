package edu.chl.roborally.view;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.utilities.EventTram;
import edu.chl.roborally.utilities.IEventHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by axel on 2015-05-18.
 */
public class StatusView extends JPanel implements ActionListener, IEventHandler {

    private Player player;
    private JButton powerDown;
    private JLabel lifeTokens;
    private JLabel dmgTokens;
    private JLabel position;
    private JButton done;
    private JButton nextTurn;

    public StatusView (Player player){
        this.player = player;
        setLayout(new GridLayout(6,1));
        setSize(320, 170);
        setBackground(Color.DARK_GRAY);

        powerDown = new JButton("PowerDown");

        lifeTokens = new JLabel("LifeTokens: " + player.getLifeTokens(), SwingConstants.CENTER);
        lifeTokens.setForeground(Color.WHITE);

        dmgTokens = new JLabel("DamageTokens: " + player.getDamageTokens(), SwingConstants.CENTER);
        dmgTokens.setForeground(Color.WHITE);

        position = new JLabel("PlayerPosition: " + player.getPosition(), SwingConstants.CENTER);
        position.setForeground(Color.WHITE);

        done = new JButton("Done");

        nextTurn = new JButton("Next Turn");

        add(powerDown);
        add(lifeTokens);
        add(dmgTokens);
        add(position);
        add(done);
        add(nextTurn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == done) {

        }
        if (e.getSource() == nextTurn){
            EventTram.getInstance().publish(EventTram.Event.NEW_TURN, null, null);
        }
    }

    @Override
    public void onEvent(EventTram.Event evt, Object o, Object o2) {
        if(evt == EventTram.Event.CHOOSE_CARDS){
            nextTurn.setEnabled(false);
        }
    }
}

