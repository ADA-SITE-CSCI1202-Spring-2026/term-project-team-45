package prj.file;

import prj.generator.TaskGenerator;
import prj.gui.DepotZone;
import prj.gui.QueueZone;
import prj.gui.RadioZone;
import prj.supply.DepotManager;

public class SaveLoadController {
    private final SaveLoadLogic saveLoadLogic;
    private final SaveLoadMenu saveLoadMenu;
    private final DepotManager depotManager;
    private final TaskGenerator taskGenerator;
    private final DepotZone depotZone;
    private final QueueZone queueZone;
    private final RadioZone radioZone;

    public SaveLoadController(SaveLoadLogic saveLoadLogic, SaveLoadMenu saveLoadMenu, DepotManager depotManager, TaskGenerator taskGenerator, DepotZone depotZone, QueueZone queueZone, RadioZone radioZone) {
        this.saveLoadLogic = saveLoadLogic;
        this.saveLoadMenu = saveLoadMenu;
        this.depotManager = depotManager;
        this.taskGenerator = taskGenerator;
        this.depotZone = depotZone;
        this.queueZone = queueZone;
        this.radioZone = radioZone;

        this.saveLoadMenu.getSaveItem().addActionListener(e -> this.saveLoadLogic.SaveState(this.depotManager, this.taskGenerator, this.radioZone));
        this.saveLoadMenu.getLoadItem().addActionListener(e -> this.saveLoadLogic.LoadState(this.depotManager, this.depotZone, this.taskGenerator, this.queueZone, this.radioZone));
    }
}
