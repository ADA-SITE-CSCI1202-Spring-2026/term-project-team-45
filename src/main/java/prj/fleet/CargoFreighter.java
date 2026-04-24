package prj.fleet;

import prj.supply.SupplyItem;

import java.util.Map;
import java.util.Random;

public class CargoFreighter extends Aircraft {
    private final int requiredCargoCrates;

    public CargoFreighter(int requiredFuel, int requiredCrew, int requiredCargoCrates, int revenueGenerated) {
        super(requiredFuel, requiredCrew, revenueGenerated);
        this.requiredCargoCrates = requiredCargoCrates;
    }

    @Override
    public void generateAndAssignAircraftModel() {
        String[] modelList = {"Boeing 747-8F", "Antonov An-124 Ruslan", "Airbus A330-200F", "Boeing 777F", "Cessna 208 Caravan Cargo"};

        // Generate a number between 0 and size of the array to be used to index the array
        Random random = new Random();
        int listNumber = random.nextInt(modelList.length);

        // Assign the model at the index as the model of the aircraft
        setAircraftModel(modelList[listNumber]);
    }

    @Override
    public String getAircraftType() {
        return "Cargo Freighter";
    }

    @Override
    public Map<SupplyItem,Integer> getResources() {
        return Map.of(SupplyItem.FUEL, getRequiredFuel(), SupplyItem.CREW, getRequiredCrew(), SupplyItem.CARGO, requiredCargoCrates);
    }

    @Override
    public String generateDemandedResources() {
        SupplyItem[] tempResourcesList = {SupplyItem.FUEL, SupplyItem.CREW, SupplyItem.CARGO};
        StringBuilder requiredResourcesText = new StringBuilder();
        String EnumToString = "";

        for (SupplyItem item: tempResourcesList) {
            if (getResources().get(item) != null && getResources().get(item) > 0) {
                switch (item) {
                    case SupplyItem.FUEL -> EnumToString = "Fuel";
                    case SupplyItem.CARGO -> EnumToString = "Cargo";
                    case SupplyItem.CREW -> EnumToString = "Crew";
                }

                requiredResourcesText.append(EnumToString).append(": ").append(getResources().get(item)).append(", ");
            }
        }

        return requiredResourcesText.toString();
    }
}
