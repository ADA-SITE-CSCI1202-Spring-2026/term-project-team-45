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
    private Style success;

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

        // Define the various styles for text such as error showing up as bold and red etc.
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

        success = radioDisplay.addStyle("Success", null);;
        StyleConstants.setForeground(success, new Color(0, 128, 0));
        StyleConstants.setBold(success, true);
        StyleConstants.setFontSize(success, 14);

        JScrollPane radioDisplayScroll = new JScrollPane(radioDisplay);
        radioDisplayScroll.setPreferredSize(new Dimension(width / 2, height / 2));
        add(radioDisplayScroll);

    }

    public void sendPurchaseErrorMessage() {
        try {
            radioDoc.insertString(radioDoc.getLength(), "ERROR: Purchase failed, not enough money!\n", error);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    public void sendPurchaseSuccessMessage() {
        try {
            radioDoc.insertString(radioDoc.getLength(), "SUCCESS: Purchase successful, resource added!\n", success);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }
}
