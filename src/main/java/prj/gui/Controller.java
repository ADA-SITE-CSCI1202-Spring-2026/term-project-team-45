package prj.gui;

// This class applies MVC principles in order to keep Business Logic completely isolated from GUI
// This is arguably the single most important file which allows the GUI to work as intended
// This class encompasses all 4 GUI zones and the Business Logic
// This class also defines the timer which will generate the Aircraft queue

import prj.fleet.Aircraft;
import prj.generator.TaskGenerator;
import prj.groundCrew.*;
import prj.supply.DepotManager;
import prj.supply.SupplyItem;

import javax.swing.*;
import java.util.List;

public class Controller {
    private final DepotManager depotManager;
    private final QueueZone queueGUI;
    private final SupplyZone supplyGUI;
    private final RadioZone radioGUI;
    private final DepotZone depotGUI;
    private final TaskGenerator taskGenerator;
    private final Timer taskTimer;

    public Controller(DepotManager depotManager, QueueZone queueGUI, SupplyZone supplyGUI, RadioZone radioGUI, DepotZone depotGUI, TaskGenerator taskGenerator) {
        this.depotManager = depotManager;
        this.queueGUI = queueGUI;
        this.supplyGUI = supplyGUI;
        this.radioGUI = radioGUI;
        this.depotGUI = depotGUI;
        this.taskGenerator = taskGenerator;

        for (SupplyItem item : SupplyItem.values()) {
            this.depotGUI.setResourceLabelValue(item, depotManager.getResourceAmount(item));
        }

        this.supplyGUI.getPurchaseButton().addActionListener(e -> ControlAndUpdateResourcePurchaseControl());



        this.queueGUI.getClearFlightButton().addActionListener(e -> ControlAndUpdateTaskClearance());


        // TODO: Fix money shown on task is not equal to money added when task is cleared;

        // Generate a new aircraft task every 3000ms (3s)
        taskTimer = new Timer(3000, e -> {
            taskGenerator.generateAndAddAircraftTask();
            queueGUI.getAircraftListAndAdd(taskGenerator.getLastAircraftOnQueue());
            radioGUI.sendAircraftArrivalMessage(taskGenerator.getLastAircraftOnQueue());
        });
        taskTimer.start();
    }

    // This method is meant to ensure that when a resource is purchased the supply text is updated and either a success or error message is sent to radio log
    public void ControlAndUpdateResourcePurchaseControl() {
        if (depotManager.buyResource((SupplyItem) supplyGUI.getResourcePurchaseMenu().getSelectedItem())) {
            depotGUI.setResourceLabelValue((SupplyItem) supplyGUI.getResourcePurchaseMenu().getSelectedItem(), depotManager.getResourceAmount((SupplyItem) supplyGUI.getResourcePurchaseMenu().getSelectedItem()));
            depotGUI.setResourceLabelValue(SupplyItem.MONEY, depotManager.getResourceAmount(SupplyItem.MONEY)); // deduct money
            radioGUI.sendPurchaseSuccessMessage();
        } else {
            radioGUI.sendPurchaseErrorMessage();
        }
    }

    public void ControlAndUpdateTaskClearance() {

        Aircraft aircraft = taskGenerator.getLastAircraftOnQueue();
        if (aircraft == null) return;
        boolean canProcess = true;
        StringBuilder missingResources = new StringBuilder();

        // RESOURCE CHECK

        for (var entry : aircraft.getResources().entrySet()) {
            if (!depotManager.checkResourceSupply(entry.getKey(), entry.getValue())) {
                canProcess = false;
                int available = depotManager.getResourceAmount(entry.getKey());
                missingResources.append(entry.getKey())
                        .append(" (need: ")
                        .append(entry.getValue())
                        .append(", have: ")
                        .append(available)
                        .append("), ");
            }
        }

        if (canProcess) {
            taskGenerator.getAndRemoveLastAircraftOnQueue();

            // POLYMORPHISM
            List<IGroundService> groundCrews = List.of(
                    new FuelingTruck(),
                    new CateringVan(),
                    new BaggageHandler(),
                    new CargoLoader(),
                    new CrewService(),
                    new LuxuryService()
            );

            for (IGroundService service : groundCrews) {
                if (service.canService(aircraft)) {
                    radioGUI.sendCustomMessage(service.serviceFlight(aircraft));
                }
            }


            // RESOURCE DEDUCTION
            for (var entry : aircraft.getResources().entrySet()) {

                depotManager.deductResource(entry.getKey(), entry.getValue());
                depotGUI.setResourceLabelValue(
                        entry.getKey(),
                        depotManager.getResourceAmount(entry.getKey())
                );
            }

            // ADDING MONEY
            depotManager.addMoney(aircraft.getRevenueGenerated());

            depotGUI.setResourceLabelValue(
                    SupplyItem.MONEY,
                    depotManager.getResourceAmount(SupplyItem.MONEY)
            );
            queueGUI.removeAircraftFromList();
            radioGUI.sendTaskClearMessage(aircraft);

        } else {
            radioGUI.sendTaskErrorMessage(aircraft);
            radioGUI.sendMissingResourceMessage(
                    "Missing resources for Flight #" + aircraft.getFlightNumber() + ": " + missingResources
            );

        }
    }
}
