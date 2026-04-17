package prj.fleet;

import java.util.Random;

public class CommercialJet extends Aircraft {
    private int passengerAmount;


    protected CommercialJet(int flightNumber, double requiredFuel, int turnaroundTime,int requiredMeals,int requiredBaggage, int passengerAmount) {
        super(flightNumber, requiredFuel, turnaroundTime, requiredMeals,requiredBaggage);
        this.passengerAmount = passengerAmount;
    }

    public int getPassengerAmount() {
        return this.passengerAmount;
    }

    // Setter is not created for passenger amount as it should not be configurable after creation of the commercial jet

    @Override
    public void generateAndAssignAircraftModel() {
        String[] modelList = {"Boeing 737", "Airbus A320neo", "Boeing 787-8", "Embraer E-190", "Airbus A319-100"};

        // Generate a number between 0 and size of the array to be used to index the array
        Random random = new Random();
        int listNumber = random.nextInt(modelList.length);
        // Assign the model at the index as the model of the aircraft
        setAircraftModel(modelList[listNumber]);
    }
}
