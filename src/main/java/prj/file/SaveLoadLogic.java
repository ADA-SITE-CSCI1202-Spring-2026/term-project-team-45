package prj.file;

import prj.fleet.*;
import prj.generator.TaskGenerator;
import prj.gui.DepotZone;
import prj.gui.QueueZone;
import prj.gui.RadioZone;
import prj.supply.*;

import java.io.*;
import java.util.*;

public class SaveLoadLogic {
    private final Map<SupplyItem, Integer> loadStateResourceMap = new EnumMap<>(SupplyItem.class);
    private final Deque<Aircraft> loadStateAircraftQueue = new ArrayDeque<>();

    public void SaveState(DepotManager depotManager, TaskGenerator taskGenerator) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("savedState.txt", false))) {
            writer.println("DEPOT BEGIN");
            for (SupplyItem item: SupplyItem.values()) {
                writer.println(item + ": " + depotManager.getResourceAmount(item));
            }
            writer.println("DEPOT END\n");

            writer.println("QUEUE BEGIN");
            for (Aircraft aircraft: taskGenerator.getFlightQueue()) {
                writer.println(aircraft.getAircraftType() + ": " + aircraft.getAircraftModel() + ": " + aircraft.generateDemandedResources(true) + "Money: " + aircraft.getRevenueGenerated());
            }
            writer.println("QUEUE END");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
