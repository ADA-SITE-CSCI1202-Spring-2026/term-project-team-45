package prj.fleet;

import prj.supply.SupplyItem;

import java.util.Map;
import java.util.Random;

public class CargoFreighter extends Aircraft {
    private int requiredCargoItems;

    public CargoFreighter(int requiredFuel, int turnaroundTime,int requiredCrew,int requiredCargoItems){
        super(requiredFuel, turnaroundTime,requiredCrew);
        this.requiredCargoItems=requiredCargoItems;
    }

    public int getRequiredCargoItems(){
        return this.requiredCargoItems;
    }

    public void setRequiredCargoItems(int requiredCargoItems) {
        this.requiredCargoItems = requiredCargoItems;
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

    @Override
    public Map<SupplyItem,Integer> getResources(){
        return Map.of(SupplyItem.FUEL,getRequiredFuel(),SupplyItem.CREW,
                getRequiredCrew(),SupplyItem.CARGO,requiredCargoItems );
    }




}
