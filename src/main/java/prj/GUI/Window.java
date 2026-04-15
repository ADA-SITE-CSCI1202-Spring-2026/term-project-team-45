package prj.GUI;

import javax.swing.*;
import java.awt.*;

public class Window {
    public static void main(String[] args) {
        // Retrieve Display Size
        int displayWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        //int displayHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

        // Set default width and height as variable arguments for reusability
        int width = 700;
        int height = 500;

        // Initialize the Window
        JFrame frame = new JFrame("Ground Operations Dashboard");
        frame.setLayout(new GridLayout(2, 2));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // TODO: Holding Pattern Top Left
        // TODO: Terminal Depot Top Right
        // TODO: Radio Bottom Left
        // TODO: Supply Bottom Right

        // #Begin Aircraft Queue Zone#
        JPanel queueZone = new JPanel();
        queueZone.setLayout(new BoxLayout(queueZone, BoxLayout.Y_AXIS));

        JTextArea queueDisplay = new JTextArea();
        queueDisplay.setLineWrap(true);
        queueDisplay.setWrapStyleWord(true);
        queueDisplay.setEditable(false);
        queueDisplay.setFocusable(false);

        JScrollPane queueDisplayScroll = new JScrollPane(queueDisplay);
        queueDisplayScroll.setPreferredSize(new Dimension(width / 2, height / 2));
        //queueDisplayScroll.setMinimumSize(new Dimension(350, 250));
        //queueDisplayScroll.setMaximumSize(new Dimension(350, 250));
        queueZone.add(queueDisplayScroll);


        JButton button = new JButton("Clear Next Flight");
        // JButton uses MaximumSize to determine size of the button
        button.setMaximumSize(new Dimension(displayWidth, 20));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        //button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        //button.setBackground(new Color(0, 191, 255));
        queueZone.add(button);

        frame.add(queueZone, BorderLayout.WEST);
        // #End Aircraft Queue Zone#

        // Placeholders to see the grid layout
        frame.add(new JPanel());
        frame.add(new JPanel());
        frame.add(new JPanel());



        frame.setSize(width, height);
        frame.setVisible(true);
    }
}
