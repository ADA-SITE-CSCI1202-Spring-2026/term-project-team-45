package prj.gui;

// This class applies MVC principles in order to keep Business Logic completely isolated from GUI
// This is arguably the single most important file which allows the GUI to work as intended
// This class encompasses all 4 GUI zones and the Business Logic

import prj.supply.DepotManager;
import prj.supply.SupplyItem;

public class Controller {
    private final DepotManager depotManager;
    private final QueueZone queueGUI;
    private final SupplyZone supplyGUI;
    private final RadioZone radioGUI;
    private final DepotZone depotGUI;

    public Controller(DepotManager depotManager, QueueZone queueGUI, SupplyZone supplyGUI, RadioZone radioGUI, DepotZone depotGUI) {
        this.depotManager = depotManager;
        this.queueGUI = queueGUI;
        this.supplyGUI = supplyGUI;
        this.radioGUI = radioGUI;
        this.depotGUI = depotGUI;

        for (SupplyItem item : SupplyItem.values()) {
            this.depotGUI.setResourceLabelValue(item, depotManager.getResourceAmount(item));
        }

        this.supplyGUI.getPurchaseButton().addActionListener(e -> ControlAndUpdateResourcePurchaseControl());
    }

    // This method is meant to ensure that when a resource is purchased the supply text is updated and and either a success or error message is sent to radio log
    public void ControlAndUpdateResourcePurchaseControl() {
        if (depotManager.buyResource((SupplyItem) supplyGUI.getResourcePurchaseMenu().getSelectedItem())) {
            depotGUI.setResourceLabelValue((SupplyItem) supplyGUI.getResourcePurchaseMenu().getSelectedItem(), depotManager.getResourceAmount((SupplyItem) supplyGUI.getResourcePurchaseMenu().getSelectedItem()));
            depotGUI.setResourceLabelValue(SupplyItem.MONEY, depotManager.getResourceAmount(SupplyItem.MONEY)); // deduct money
            radioGUI.sendPurchaseSuccessMessage();
        } else {
            radioGUI.sendPurchaseErrorMessage();
        }
    }
}
