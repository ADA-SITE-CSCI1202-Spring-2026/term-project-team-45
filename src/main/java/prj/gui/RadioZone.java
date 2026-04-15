package prj.gui;

import javax.swing.*;
import java.awt.*;

public class RadioZone extends JPanel {
    private JTextPane radioDisplay;

    public RadioZone(int width, int height) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        radioDisplay = new JTextPane() {
            @Override
            public boolean getScrollableTracksViewportWidth() {
                return true;
            }
        };
        //radioDisplay.setText("Welcome Chief! You have a tiring job ahead.");

        JScrollPane radioDisplayScroll = new JScrollPane(radioDisplay);
        radioDisplayScroll.setPreferredSize(new Dimension(width / 2, height / 2));
        add(radioDisplayScroll);

    }
}
