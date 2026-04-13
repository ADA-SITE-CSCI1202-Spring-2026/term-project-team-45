package prj.fleet;

import java.util.Random;

public class CargoFreighter extends Aircraft {
    private int weightLimit;

    public CargoFreighter(int flightNumber, double requiredFuel, int turnaroundTime,int weightLimit){
        super(flightNumber, requiredFuel, turnaroundTime);
        this.weightLimit=weightLimit;
    }

    public int getWeightLimit(){
        return this.weightLimit;
    }

    @Override
    public void generateAndAssignAircraftModel() {
        String[] modelList = {"Boeing 747-8F", "Antonov An-124 Ruslan", "Airbus A330-200F", "Boeing 777F", "ACessna 208 Caravan Cargo"};

        // Generate a number between 0 and size of the array to be used to index the array
        Random random = new Random();
        int listNumber = random.nextInt(modelList.length);

        // Assign the model at the index as the model of the aircraft
        setAircraftModel(modelList[listNumber]);
    }




}
