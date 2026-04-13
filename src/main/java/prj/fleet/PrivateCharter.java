package prj.fleet;

import java.util.Random;

public class PrivateCharter extends Aircraft {
    private int vipPassengers;

    public PrivateCharter(int flightNumber, double requiredFuel, int turnaroundTime,int vipPassengers){
        super(flightNumber, requiredFuel, turnaroundTime);
        this.vipPassengers=vipPassengers;
    }

    public int getVipPassengers(){
        return this.vipPassengers;
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
