package prj.fleet;

public abstract class Aircraft {
    private int flightNumber;
    private double requiredFuel;
    private int turnaroundTime;

    // Define the constructor for the common fields of the Aircraft's subclasses
    // Constructor is defined as protected to ensure only related classes can call

    protected Aircraft(int flightNumber, double requiredFuel, int turnaroundTime) {
        this.flightNumber = flightNumber;
        this.requiredFuel = requiredFuel;
        this.turnaroundTime = turnaroundTime;
    }

    // Getter methods are set as public as the "world" might require access to the information

    public int getFlightNumber() {
        return this.flightNumber;
    }

    public double getRequiredFuel() {
        return this.requiredFuel;
    }

    public int getTurnaroundTime() {
        return this.turnaroundTime;
    }

    // Setter methods are set public as the "world" might change them but could be removed depending on lack of need or security of the program

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setRequiredFuel(double requiredFuel) {
        this.requiredFuel = requiredFuel;
    }

    public void setTurnaroundTime(int turnaroundTime) {
        this.turnaroundTime = turnaroundTime;
    }
}
