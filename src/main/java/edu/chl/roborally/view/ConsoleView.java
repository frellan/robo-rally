package edu.chl.roborally.view;

import edu.chl.roborally.utilities.EventTram;
import edu.chl.roborally.utilities.IEventHandler;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;


/**
 * Created by axel on 2015-05-18.
 *
 * This Panel works as a "terminal", to use it:
 * fire the PRINT_MESSAGE event with a string that you want to print and it will print it
 * in a jTextPane.
 *
 * If you want to print the message with a custom color, send a Color as the second parameter in the event.
 *
 */
public class ConsoleView extends JPanel implements IEventHandler {

    private JTextPane jTextPane;


    public ConsoleView(){

        this.setLayout(new BorderLayout());

        jTextPane = new JTextPane();
        jTextPane.setEditable(false);
        jTextPane.setBackground(Color.DARK_GRAY);
        jTextPane.setForeground(Color.GREEN);

        EventTram.getInstance().register(this);

        JScrollPane scrollPane = new JScrollPane(jTextPane);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getVerticalScrollBar().setBackground(Color.DARK_GRAY);
        scrollPane.getHorizontalScrollBar().setBackground(Color.DARK_GRAY);

        this.add(scrollPane, BorderLayout.CENTER);

        this.setSize(314, 492);
    }

    private void append(String str){
        StyledDocument doc = jTextPane.getStyledDocument();
        try {
            doc.insertString(doc.getLength(), "\n" + str, null);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    private void append(String str, Color color){
        StyledDocument doc = jTextPane.getStyledDocument();
        SimpleAttributeSet keyWord = new SimpleAttributeSet();
        StyleConstants.setForeground(keyWord, color);
        try {
            doc.insertString(doc.getLength(), str, keyWord);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onEvent(EventTram.Event evt, Object o, Object o2) {
        if(evt == EventTram.Event.PRINT_MESSAGE){
            if(o2 != null) {
                append((String) o, (Color) o2);

            }else{
                append((String) o);
            }
        }
    }
}
