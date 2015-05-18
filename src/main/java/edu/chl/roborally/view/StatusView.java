package edu.chl.roborally.view;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.utilities.EventTram;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by axel on 2015-05-18.
 */
public class StatusView extends JPanel implements ActionListener {

    private Player player;
    private JButton powerDown;
    private JLabel lifeTokens;
    private JLabel dmgTokens;
    private JLabel position;

    public StatusView (Player player){
        this.player = player;
        setLayout(new GridLayout(4,1));
        setSize(322, 162);

        powerDown = new JButton("PowerDown");
        powerDown.addActionListener(this);

        lifeTokens = new JLabel("LifeTokens " + player.getLifeTokens());
        dmgTokens = new JLabel("DamageTokens " + player.getDamageTokens());
        position = new JLabel("PlayerPosition " + player.getPosition());

        add(powerDown);
        add(lifeTokens);
        add(dmgTokens);
        add(position);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        EventTram.getInstance().publish(EventTram.Event.POWER_DOWN, null);
    }

}
