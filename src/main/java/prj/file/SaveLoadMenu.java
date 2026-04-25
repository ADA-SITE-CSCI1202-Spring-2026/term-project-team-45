package prj.file;

import javax.swing.*;

public class SaveLoadMenu extends JMenuBar {
    private final JMenu fileMenu;
    private final JMenuItem save;
    private final JMenuItem load;

    public SaveLoadMenu() {
        fileMenu = new JMenu("File");

        save = new JMenuItem("Save");
        load = new JMenuItem("Load");

        fileMenu.add(save);
        fileMenu.add(load);

        add(fileMenu);
    }

    public JMenuItem getSaveItem() {
        return save;
    }

    public JMenuItem getLoadItem() {
        return load;
    }
}