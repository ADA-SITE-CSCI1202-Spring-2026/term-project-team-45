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

        add(new QueueZone(width, height));
        add(new SupplyZone());
        add(new RadioZone(width, height));
        add(new DepotZone());
    }
}
