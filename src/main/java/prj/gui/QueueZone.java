package prj.gui;

import javax.swing.*;
import java.awt.*;

public class QueueZone extends JPanel {
    private JPanel aircraftList;
    private JButton executeTask;

    private final int displayWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();

    public QueueZone(int width, int height) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // The "box" which will store all the incoming aircraft
        aircraftList = new JPanel();
        aircraftList.setLayout(new BoxLayout(aircraftList, BoxLayout.Y_AXIS));

        // TODO: Implement Ability to Add Aircraft JPanels everytime an Aircraft is spawned

        add(aircraftList);

        executeTask = new JButton("Clear Next Flight");
        // JButton is sized based on MaximumSize
        executeTask.setMaximumSize(new Dimension(displayWidth, 20));
        executeTask.setAlignmentX(CENTER_ALIGNMENT);
        //executeTask.setContentAreaFilled(false);
        executeTask.setFocusPainted(false);
        //executeTask.setBackground(Color.BLACK);

        add(executeTask);
    }
}
