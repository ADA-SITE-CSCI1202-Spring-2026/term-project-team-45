package prj.fleet;

import prj.supply.SupplyItem;

import java.util.Map;
import java.util.Random;

public class CommercialJet extends Aircraft {
    private int requiredBaggage;
    private int requiredRations;  // meal

    public CommercialJet(int requiredFuel, int turnaroundTime, int requiredCrew, int requiredBaggage, int requiredRations) {
        super(requiredFuel, turnaroundTime, requiredCrew);
        this.requiredBaggage = requiredBaggage;
        this.requiredRations = requiredRations;
    }

    public int getRequiredBaggage() {
        return this.requiredBaggage;
    }

    public int getRequiredRations() {
        return this.requiredRations;
    }

    public void setRequiredBaggage(int requiredBaggage) {
        this.requiredBaggage = requiredBaggage;
    }

    public void setRequiredRations(int requiredRations) {
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
    public Map<SupplyItem,Integer> getResources(){
        return Map.of(SupplyItem.FUEL, getRequiredFuel(), SupplyItem.CREW, getRequiredCrew(), SupplyItem.MEAL, requiredRations, SupplyItem.LUGGAGE, requiredBaggage);
    }
}

