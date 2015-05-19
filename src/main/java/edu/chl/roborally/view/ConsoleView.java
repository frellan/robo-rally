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
 * If you want to print the message with a custom color, send a Color as the second parameter in the event.
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
        textArea.setFont(new Font("Sans-Serif", Font.PLAIN, 20));

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

    //Print message with standard color
    public void printMessage(String str){
        textArea.append(str + "\n");
    }

    //Print message with custom color
    public void printMessage(String str, Color color){
        textArea.setForeground(color);
        printMessage(str);
    }

    @Override
    public void onEvent(EventTram.Event evt, Object o, Object o2) {
        if(evt == EventTram.Event.PRINT_MESSAGE){
            if(o2 != null) {
                printMessage((String) o, (Color) o2);

            }else{
                printMessage((String) o);
            }
        }
    }
}
