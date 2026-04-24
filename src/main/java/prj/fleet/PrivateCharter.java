package prj.fleet;

import prj.supply.SupplyItem;

import java.util.Map;
import java.util.Random;

public class PrivateCharter extends Aircraft {
    private final int requiredPremiumRations;
    private final int requiredBaggage;

    public PrivateCharter(int requiredFuel, int requiredCrew, int requiredBaggage, int requiredPremiumRations, int revenueGenerated) {
        super(requiredFuel, requiredCrew, revenueGenerated);
        this.requiredPremiumRations = requiredPremiumRations;
        this.requiredBaggage = requiredBaggage;
    }

    @Override
    public void generateAndAssignAircraftModel() {
        String[] modelList = {"Gulfstream G650", "Bombardier Global 7500", "Dassault Falcon 8X", "Embraer Praetor 600", "Cessna Citation Longitude"};

        // Generate a number between 0 and size of the array to be used to index the array
        Random random = new Random();
        int listNumber = random.nextInt(modelList.length);

        // Assign the model at the index as the model of the aircraft
        setAircraftModel(modelList[listNumber]);
    }

    @Override
    public String getAircraftType() {
        return "Private Charter";
    }

    @Override
    public Map<SupplyItem,Integer> getResources(){
        return Map.of(SupplyItem.FUEL, getRequiredFuel(), SupplyItem.CREW, getRequiredCrew(), SupplyItem.LUGGAGE, requiredBaggage, SupplyItem.LUXURY_MEAL, requiredPremiumRations);
    }

    @Override
    public String generateDemandedResources() {
        SupplyItem[] tempResourcesList = {SupplyItem.FUEL, SupplyItem.CREW, SupplyItem.LUXURY_MEAL, SupplyItem.LUGGAGE};
        StringBuilder requiredResourcesText = new StringBuilder();
        String EnumToString = "";

        for (SupplyItem item: tempResourcesList) {
            if (getResources().get(item) != null && getResources().get(item) > 0) {
                switch (item) {
                    case SupplyItem.FUEL -> EnumToString = "Fuel";
                    case SupplyItem.LUXURY_MEAL -> EnumToString = "Luxury Meal";
                    case SupplyItem.CREW -> EnumToString = "Crew";
                    case SupplyItem.LUGGAGE -> EnumToString = "Luggage";
                }

                requiredResourcesText.append(EnumToString).append(": ").append(getResources().get(item)).append(", ");
            }
        }

        return requiredResourcesText.toString();
    }
}

