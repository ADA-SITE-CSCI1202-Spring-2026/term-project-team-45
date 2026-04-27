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

    public void SaveState(DepotManager depotManager, TaskGenerator taskGenerator, RadioZone radioZone) {
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

            radioZone.sendSuccessfulSaveMessage();

        } catch (IOException e) {
            radioZone.sendFailedSaveMessage();
            e.printStackTrace();
        }
    }

    public void LoadState(DepotManager depotManager, DepotZone depotZone, TaskGenerator taskGenerator, QueueZone queueZone, RadioZone radioZone) {
        try (BufferedReader br = new BufferedReader(new FileReader("savedState.txt"))) {
            String line;

            // reset the queue to make sure when a state is loaded 2nd time it does not add to the previous load's state
            loadStateAircraftQueue.clear();
            Aircraft.resetIdGenerator();

            // Read out DEPOT BEGIN
            br.readLine();
            while ((line = br.readLine()) != null && !line.equals("DEPOT END")) {
                String[] resourceArray = line.split(": ");
                loadStateResourceMap.put(SupplyItem.valueOf(resourceArray[0]), Integer.valueOf(resourceArray[1]));
            }
            // Read out DEPOT END

            br.readLine(); // Read out newline

            // Read out QUEUE BEGIN
            br.readLine();
            while ((line = br.readLine()) != null && !line.equals("QUEUE END")) {
                String[] queueArray = line.split(": |, ");

                switch(queueArray[0]) {
                    case "Commercial Jet" -> {
                        loadStateAircraftQueue.add(new CommercialJet(Integer.parseInt(queueArray[3]), Integer.parseInt(queueArray[5]),
                                Integer.parseInt(queueArray[9]), Integer.parseInt(queueArray[7]), Integer.parseInt(queueArray[11])));
                        loadStateAircraftQueue.peekLast().setAircraftModel(queueArray[1]);
                    }
                    case "Cargo Freighter" -> {
                        loadStateAircraftQueue.add(new CargoFreighter(Integer.parseInt(queueArray[3]), Integer.parseInt(queueArray[5]),
                                Integer.parseInt(queueArray[7]), Integer.parseInt(queueArray[9])));
                        loadStateAircraftQueue.peekLast().setAircraftModel(queueArray[1]);
                    }
                    case "Private Charter" -> {
                        loadStateAircraftQueue.add(new PrivateCharter(Integer.parseInt(queueArray[3]), Integer.parseInt(queueArray[5]),
                                Integer.parseInt(queueArray[9]), Integer.parseInt(queueArray[7]), Integer.parseInt(queueArray[11])));
                        loadStateAircraftQueue.peekLast().setAircraftModel(queueArray[1]);
                    }
                }
            }

            // Reassign values from the new temporary loadStateMap to the Depot manager map and change the values on the GUI
            depotManager.repopulateAirportSupply(loadStateResourceMap);
            for (SupplyItem item: SupplyItem.values()) {
                depotZone.setResourceLabelValue(item, depotManager.getResourceAmount(item));
            }

            // Clear Aircraft queue and assign from the load state
            taskGenerator.resetAircraftQueue();
            taskGenerator.repopulateAircraftQueue(loadStateAircraftQueue);

            // Clear the GUI panel and re-state the necessary aircraft
            queueZone.clearAircraftListPanel();
            radioZone.clearRadioDisplay();
            for (Aircraft aircraft: taskGenerator.getFlightQueue()) {
                queueZone.getAircraftListAndAdd(aircraft);
            }

            radioZone.sendSuccessfulLoadMessage();

        } catch (IOException e) {
            radioZone.sendFailedLoadMessage();
            e.printStackTrace();
        }
    }
}
