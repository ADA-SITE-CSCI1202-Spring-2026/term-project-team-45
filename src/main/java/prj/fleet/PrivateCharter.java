package prj.fleet;

import java.util.Random;

public class PrivateCharter extends CommercialJet {

    public PrivateCharter(int requiredFuel, int turnaroundTime, int requiredBaggage, int requiredMeals){
        super(requiredFuel, turnaroundTime, requiredBaggage, requiredMeals);
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
}

