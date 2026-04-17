package prj.gui;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

public class RadioZone extends JPanel {
    private JTextPane radioDisplay;

    private StyledDocument radioDoc;
    private Style info;
    private Style warning;
    private Style error;

    public RadioZone(int width, int height) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        radioDisplay = new JTextPane() {
            @Override
            public boolean getScrollableTracksViewportWidth() {
                return true;
            }
        };
        //radioDisplay.setText("Welcome Chief! You have a tiring job ahead.");
        radioDisplay.setEditable(false);
        radioDisplay.setBackground(new Color(192, 192, 192));
        radioDoc = radioDisplay.getStyledDocument();

        info = radioDisplay.addStyle("Info", null);
        StyleConstants.setForeground(info, Color.BLACK);
        StyleConstants.setFontSize(info, 14);

        warning = radioDisplay.addStyle("Warning", null);
        StyleConstants.setForeground(warning, new Color(233, 213, 2));
        StyleConstants.setItalic(warning, true);
        StyleConstants.setFontSize(warning, 14);

        error = radioDisplay.addStyle("Error", null);
        StyleConstants.setForeground(error, new Color(255, 44, 44));
        StyleConstants.setBold(error, true);
        StyleConstants.setFontSize(error, 14);

        // Test
        try {
            radioDoc.insertString(radioDoc.getLength(), "ERROR: This is an Error\n", error);
            radioDoc.insertString(radioDoc.getLength(), "WARNING: This is a Warning\n", warning);
            radioDoc.insertString(radioDoc.getLength(), "INFO: This is an Info", info);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        // Test

        JScrollPane radioDisplayScroll = new JScrollPane(radioDisplay);
        radioDisplayScroll.setPreferredSize(new Dimension(width / 2, height / 2));
        add(radioDisplayScroll);

    }
}
