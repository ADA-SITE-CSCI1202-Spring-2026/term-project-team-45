package prj.fleet;

public abstract class Aircraft {
    private int flightNumber;
    private static int idGenerator = 1;

    private int requiredFuel;
    private int turnaroundTime;
    private int requiredMeals;
    private int requiredBaggage;

    // This field must only be assigned a value after the constructor call has been made as it is difficult/unnecessary to generate a model midst constructor call
    private String aircraftModel;

    // Define the constructor for the common fields of the Aircraft's subclasses
    // Constructor is defined as protected to ensure only related classes can call

    public Aircraft(int requiredFuel, int turnaroundTime, int requiredMeals, int requiredBaggage) {
        this.flightNumber = idGenerator++;
        this.requiredFuel = requiredFuel;
        this.turnaroundTime = turnaroundTime;
        this.requiredMeals = requiredMeals;
        this.requiredBaggage = requiredBaggage;
    }

    // Getter methods are set as public as the "world" might require access to the information

    public int getFlightNumber() {
        return this.flightNumber;
    }

    public int getRequiredFuel() {
        return this.requiredFuel;
    }

    public int getTurnaroundTime() {
        return this.turnaroundTime;
    }

    public int getRequiredMeals() {
        return requiredMeals;
    }

    public int getRequiredBaggage() {
        return requiredBaggage;
    }

    public String getAircraftModel() {
        // Ensure that a null String is interpreted as an unknown model aircraft
        if (this.aircraftModel == null) {
            return "Unknown Model";
        }

        return this.aircraftModel;
    }

    // Setter methods are set public as the "world" might change them but could be removed depending on lack of need or security of the program

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setRequiredFuel(int requiredFuel) {
        this.requiredFuel = requiredFuel;
    }

    public void setTurnaroundTime(int turnaroundTime) {
        this.turnaroundTime = turnaroundTime;
    }

    public void setRequiredMeals(int requiredMeals) {
        this.requiredMeals = requiredMeals;
    }

    public void setRequiredBaggage(int requiredBaggage) {
        this.requiredBaggage = requiredBaggage;
    }

    // Default access modifier as it has the lowest level access which allows access from child classes from the same package (private doesn't work)
    void setAircraftModel(String aircraftModel) {
        this.aircraftModel = aircraftModel;
    }

    public abstract void generateAndAssignAircraftModel();
}
