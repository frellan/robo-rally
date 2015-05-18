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
        setBackground(Color.DARK_GRAY);

        powerDown = new JButton("PowerDown");
        powerDown.setFont(new Font("Serif", Font.PLAIN, 30));
        powerDown.setBackground(Color.RED);
        powerDown.setForeground(Color.WHITE);
        powerDown.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.BLACK));
        powerDown.addActionListener(this);


        lifeTokens = new JLabel("LifeTokens: " + player.getLifeTokens(), SwingConstants.CENTER);
        lifeTokens.setForeground(Color.GREEN);
        lifeTokens.setFont(new Font("Serif", Font.PLAIN, 22));

        dmgTokens = new JLabel("DamageTokens: " + player.getDamageTokens(), SwingConstants.CENTER);
        dmgTokens.setForeground(Color.GREEN);
        dmgTokens.setFont(new Font("Serif", Font.PLAIN, 22));

        position = new JLabel("PlayerPosition: " + player.getPosition(), SwingConstants.CENTER);
        position.setForeground(Color.GREEN);
        position.setFont(new Font("Serif", Font.PLAIN, 22));

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
