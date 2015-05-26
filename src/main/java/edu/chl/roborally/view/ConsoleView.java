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
 * in a textPane.
 *
 * If you want to print the message with a custom color, send a Color as the second parameter in the event.
 *
 */
public class ConsoleView extends JPanel implements IEventHandler {

    private JTextPane textPane;

    protected ConsoleView(){
        setLayout(new BorderLayout());
        setSize(314, 492);
        EventTram.getInstance().register(this);
        textPane = new JTextPane();
        textPane.setEditable(false);
        textPane.setBackground(Color.DARK_GRAY);
        textPane.setForeground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getVerticalScrollBar().setBackground(Color.DARK_GRAY);
        scrollPane.getHorizontalScrollBar().setBackground(Color.DARK_GRAY);
        add(scrollPane, BorderLayout.CENTER);
    }

    /*
    Class methods
     */
    private void append(String text){
        StyledDocument doc = textPane.getStyledDocument();
        try {
            doc.insertString(doc.getLength(), text, null);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }
    private void append(String text, Color color){
        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet keyWord = new SimpleAttributeSet();
        StyleConstants.setForeground(keyWord, color);
        try {
            doc.insertString(doc.getLength(), text, keyWord);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onEvent(EventTram.Event evt, Object o, Object o2) {
        if (evt == EventTram.Event.PRINT_MESSAGE){
            if (o2 != null) {
                append((String) o, (Color) o2);

            } else {
                append((String) o);
            }
        }
    }
}
