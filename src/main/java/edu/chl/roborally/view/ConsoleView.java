package edu.chl.roborally.view;

import edu.chl.roborally.utilities.EventTram;
import edu.chl.roborally.utilities.IEventHandler;

import javax.swing.*;
import java.awt.*;

/**
 * Created by axel on 2015-05-18.
 *
 * This Panel works as a "terminal", to use it:
 * fire the PRINT_MESSAGE event with a string that you want to print and it will print it
 * in a textArea.
 *
 */
public class ConsoleView extends JPanel implements IEventHandler {

    private JTextArea textArea;

    public ConsoleView(){

        this.setLayout(new BorderLayout());

        textArea = new JTextArea(20,5);
        textArea.setEditable(false);
        textArea.setBackground(Color.DARK_GRAY);
        textArea.setForeground(Color.GREEN);

        EventTram.getInstance().register(this);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getVerticalScrollBar().setBackground(Color.DARK_GRAY);
        scrollPane.getHorizontalScrollBar().setBackground(Color.DARK_GRAY);

        this.add(scrollPane, BorderLayout.CENTER);

        this.setSize(314, 492);
    }

    public void printMessage(String str){
        textArea.append(str + "\n");
    }

    @Override
    public void onEvent(EventTram.Event evt, Object o) {
        if(evt == EventTram.Event.PRINT_MESSAGE){
            printMessage((String) o);
        }
    }
}
