package prj.gui;

import prj.fleet.Aircraft;

import javax.swing.*;
import java.awt.*;

public class QueueZone extends JPanel {
    private JPanel aircraftList;
    private JButton clearFlightButton;

    private final int displayWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();

    public QueueZone(int width, int height) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // The "box" which will store all the incoming aircraft
        aircraftList = new JPanel();
        aircraftList.setLayout(new BoxLayout(aircraftList, BoxLayout.Y_AXIS));

        JScrollPane aircraftListScroll = new JScrollPane(aircraftList);
        aircraftListScroll.setPreferredSize(new Dimension(width / 2, height / 2));
        add(aircraftListScroll);

        clearFlightButton = new JButton("Clear Next Flight");
        // JButton is sized based on MaximumSize
        clearFlightButton.setMaximumSize(new Dimension(displayWidth, 20));
        clearFlightButton.setAlignmentX(CENTER_ALIGNMENT);
        clearFlightButton.setFocusPainted(false);

        add(clearFlightButton);
    }

    public JButton getClearFlightButton() {
        return this.clearFlightButton;
    }

    public void getAircraftListAndAdd(Aircraft aircraft) {
        // Create a panel which will hold all necessary information about the incoming aircraft
        JPanel tempTask = new JPanel();
        tempTask.setLayout(new BoxLayout(tempTask, BoxLayout.Y_AXIS));
        tempTask.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        tempTask.setMaximumSize(new Dimension(displayWidth, 35));

        // Add the aircraft model and type into the GUI
        JLabel tempAircraftInfo = new JLabel(aircraft.getAircraftType() + ": " + aircraft.getAircraftModel());
        tempAircraftInfo.setAlignmentX(CENTER_ALIGNMENT);
        tempTask.add(tempAircraftInfo);

        // Add the resources demanded by the aircraft into the GUI
        JLabel tempResourceInfo = new JLabel(aircraft.generateDemandedResources() + "Money: " + aircraft.getRevenueGenerated() + "₼");
        tempResourceInfo.setAlignmentX(CENTER_ALIGNMENT);
        tempTask.add(tempResourceInfo);
        aircraftList.add(Box.createRigidArea(new Dimension(0, 10)));
        aircraftList.add(tempTask);

        // Update screen
        revalidate();
        repaint();
    }

    public void removeAircraftFromList() {
        if (aircraftList.getComponentCount() > 0) {
            aircraftList.remove(0); // To remove the invisible Line Border
            aircraftList.remove(0); // To remove the Aircraft Task Panel

            revalidate();
            repaint();
        }
    }
}
