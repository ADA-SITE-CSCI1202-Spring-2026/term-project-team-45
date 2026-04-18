package prj.fleet;

import java.util.Random;

public class CommercialJet extends Aircraft {
    private int requiredMeals;

    public CommercialJet(int requiredFuel, int turnaroundTime, int requiredBaggage, int requiredMeals) {
        super(requiredFuel, turnaroundTime, requiredBaggage);
        this.requiredMeals = requiredMeals;
    }

    public int getRequiredMeals() {
        return requiredMeals;
    }

    public void setRequiredMeals(int requiredMeals) {
        this.requiredMeals = requiredMeals;
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
}
