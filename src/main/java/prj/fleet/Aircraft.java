package prj.fleet;

import prj.supply.SupplyItem;

import java.util.Map;

public abstract class Aircraft {
    private final int flightNumber;
    private static int idGenerator = 1;

    private final int requiredFuel;
    private final int requiredCrew;
    private final int revenueGenerated;

    // This field must only be assigned a value after the constructor call has been made as it is difficult/unnecessary to generate a model midst constructor call
    private String aircraftModel;

    // Define the constructor for the common fields of the Aircraft's subclasses
    // Constructor is defined as protected to ensure only related classes can call

    public Aircraft(int requiredFuel, int requiredCrew, int revenueGenerated) {
        this.flightNumber = idGenerator++;
        this.requiredFuel = requiredFuel;
        this.requiredCrew = requiredCrew;
        this.revenueGenerated = revenueGenerated;
    }

    // Getter methods are set as public as the "world" might require access to the information

    public int getFlightNumber() {
        return this.flightNumber;
    }

    public int getRequiredFuel() {
        return this.requiredFuel;
    }

    public int getRequiredCrew() {
        return this.requiredCrew;
    }

    public int getRevenueGenerated() {
        return this.revenueGenerated;
    }

    public String getAircraftModel() {
        // Ensure that a null String is interpreted as an unknown model aircraft
        if (this.aircraftModel == null) {
            return "Unknown Model";
        }

        return this.aircraftModel;
    }

    // Setters are not required

    // Default access modifier as it has the lowest level access which allows access from child classes from the same package (private doesn't work)
    public void setAircraftModel(String aircraftModel) {
        this.aircraftModel = aircraftModel;
    }

    public static void resetIdGenerator() {
        idGenerator = 1;
    }

    public abstract Map<SupplyItem, Integer> getResources();

    // If boolean is true it will generate an alternate String that is suited for saving and loading data
    // the alternate String differs in that it also shows resources that have 0 demand by the respective aircraft
    public abstract String generateDemandedResources(boolean isForFileOperations);

    public abstract void generateAndAssignAircraftModel();
    public abstract String getAircraftType();
}
