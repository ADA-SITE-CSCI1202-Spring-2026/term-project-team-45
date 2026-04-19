package prj.fleet;

import prj.supply.SupplyItem;

import java.util.Map;
import java.util.Random;

public class PrivateCharter extends CommercialJet {
    private int requiredLuxuryItems;
    private int requiredPremiumRations;

    public PrivateCharter(int requiredFuel, int turnaroundTime,int requiredCrew,int requiredLuxuryItems,int requiredPremiumRations){
        super(requiredFuel, turnaroundTime,requiredCrew);
        this.requiredLuxuryItems=requiredLuxuryItems;
        this.requiredPremiumRations=requiredPremiumRations;
    }

    public int getRequiredLuxuryItems() {
        return requiredLuxuryItems;
    }

    public int getRequiredPremiumRations() {
        return requiredPremiumRations;
    }

    public void setRequiredLuxuryItems(int requiredLuxuryItems) {
        this.requiredLuxuryItems = requiredLuxuryItems;
    }

    public void setRequiredPremiumRations(int requiredPremiumRations) {
        this.requiredPremiumRations = requiredPremiumRations;
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
    public Map<SupplyItem,Integer> getResources(){
        return Map.of(SupplyItem.FUEL,getRequiredFuel(),SupplyItem.CREW,
                getRequiredCrew(),SupplyItem.MEAL, requiredPremiumRations,SupplyItem.LUXURY_ITEMS,requiredLuxuryItems);
    }
}

