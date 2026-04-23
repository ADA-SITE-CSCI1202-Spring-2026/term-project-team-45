package prj.gui;

import prj.file.SaveLoadMenu;
import prj.generator.TaskGenerator;
import prj.supply.DepotManager;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private final int width = 700;
    private final int height = 500;

    public Window() {
        super("Skyways Tycoon: Ground Operations Dashboard");
        setSize(width, height);
        setLayout(new GridLayout(2, 2));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        DepotManager depotManager = new DepotManager(); // initialize the central depot manager to be represented by the GUI

        QueueZone queueZone = new QueueZone(width, height);
        SupplyZone supplyZone = new SupplyZone();
        RadioZone radioZone = new RadioZone(width, height);
        DepotZone depotZone = new DepotZone();
        SaveLoadMenu saveLoadMenu = new SaveLoadMenu();
        TaskGenerator taskGenerator = new TaskGenerator();

        add(queueZone);
        add(supplyZone);
        add(radioZone);
        add(depotZone);
        setJMenuBar(saveLoadMenu);

        Controller controller = new Controller(depotManager, queueZone, supplyZone, radioZone, depotZone, taskGenerator);
    }
}
