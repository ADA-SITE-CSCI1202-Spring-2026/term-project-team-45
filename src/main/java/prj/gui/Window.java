package prj.gui;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private final int width = 700;
    private final int height = 500;

    public Window() {
        super("Ground Operations Dashboard");
        setSize(width, height);
        setLayout(new GridLayout(2, 2));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        QueueZone queueZone = new QueueZone(width, height);
        SupplyZone supplyZone = new SupplyZone();
        RadioZone radioZone = new RadioZone(width, height);
        DepotZone depotZone = new DepotZone();

        add(queueZone);
        add(supplyZone);
        add(radioZone);
        add(depotZone);
    }
}
