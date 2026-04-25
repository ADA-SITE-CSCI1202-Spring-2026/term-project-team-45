package prj.fleet;

import prj.supply.SupplyItem;

import java.util.Map;
import java.util.Random;

public class CommercialJet extends Aircraft {
    private final int requiredBaggage;
    private final int requiredRations;  // meal

    public CommercialJet(int requiredFuel, int requiredCrew, int requiredBaggage, int requiredRations, int revenueGenerated) {
        super(requiredFuel, requiredCrew, revenueGenerated);
        this.requiredBaggage = requiredBaggage;
        this.requiredRations = requiredRations;
    }

    @Override
    public void generateAndAssignAircraftModel() {
        String[] modelList = {"Boeing 737", "Airbus A320neo", "Boeing 787-8", "Embraer E-190", "Airbus A319-100"};

        // Generate a number between 0 and size of the array to be used to index the array
        Random random = new Random();
        int listNumber = random.nextInt(modelList.length);
        // Assign the model at the index as the model of the aircraft
        setAircraftModel(modelList[listNumber]);
    }

    @Override
    public String getAircraftType() {
        return "Commercial Jet";
    }

    @Override
    public Map<SupplyItem,Integer> getResources(){
        return Map.of(SupplyItem.FUEL, getRequiredFuel(), SupplyItem.CREW, getRequiredCrew(), SupplyItem.MEAL, requiredRations, SupplyItem.LUGGAGE, requiredBaggage);
    }

    @Override
    public String generateDemandedResources(boolean isForFileOperations) {
        SupplyItem[] tempResourcesList = {SupplyItem.FUEL, SupplyItem.CREW, SupplyItem.MEAL, SupplyItem.LUGGAGE};
        StringBuilder requiredResourcesText = new StringBuilder();
        String EnumToString = "";

        if (!isForFileOperations) {
            for (SupplyItem item: tempResourcesList) {
                if (getResources().get(item) > 0) {
                    switch (item) {
                        case SupplyItem.FUEL -> EnumToString = "Fuel";
                        case SupplyItem.MEAL -> EnumToString = "Meal";
                        case SupplyItem.CREW -> EnumToString = "Crew";
                        case SupplyItem.LUGGAGE -> EnumToString = "Luggage";
                    }

                    requiredResourcesText.append(EnumToString).append(": ").append(getResources().get(item)).append(", ");
                }
            }
        } else {
            for (SupplyItem item: tempResourcesList) {
                switch (item) {
                    case SupplyItem.FUEL -> EnumToString = "Fuel";
                    case SupplyItem.MEAL -> EnumToString = "Meal";
                    case SupplyItem.CREW -> EnumToString = "Crew";
                    case SupplyItem.LUGGAGE -> EnumToString = "Luggage";
                }

                requiredResourcesText.append(EnumToString).append(": ").append(getResources().get(item)).append(", ");
            }
        }

        return requiredResourcesText.toString();
    }
}



