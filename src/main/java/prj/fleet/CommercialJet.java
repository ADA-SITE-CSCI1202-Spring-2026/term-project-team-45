package prj.fleet;

public class CommercialJet extends Aircraft {
    private int passengerAmount;


    protected CommercialJet(int flightNumber, double requiredFuel, int turnaroundTime, int passengerAmount) {
        super(flightNumber, requiredFuel, turnaroundTime);
        this.passengerAmount = passengerAmount;
    }

    public int getPassengerAmount() {
        return this.passengerAmount;
    }

    // Setter is not created for passenger amount as it should not be configurable after creation of the commercial jet

    @Override
    public void generateAndAssignAircraftModel() {

    }
}
