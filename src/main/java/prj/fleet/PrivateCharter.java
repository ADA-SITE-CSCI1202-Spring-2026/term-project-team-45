package prj.fleet;

import prj.supply.SupplyItem;

import java.util.Map;
import java.util.Random;

public class PrivateCharter extends CommercialJet {
    private int requiredPremiumRations;

    public PrivateCharter(int requiredFuel, int turnaroundTime, int requiredCrew, int requiredBaggage, int requiredRations, int requiredPremiumRations, int revenueGenerated) {
        super(requiredFuel, turnaroundTime, requiredCrew, requiredBaggage, requiredRations, revenueGenerated);
        this.requiredPremiumRations = requiredPremiumRations;
    }

    public int getRequiredPremiumRations() {
        return this.requiredPremiumRations;
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
        return Map.of(SupplyItem.FUEL, getRequiredFuel(), SupplyItem.CREW, getRequiredCrew(), SupplyItem.MEAL, getRequiredRations(), SupplyItem.LUGGAGE, getRequiredBaggage(), SupplyItem.LUXURY_MEAL, requiredPremiumRations);
    }
}

