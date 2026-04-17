package prj.groundCrew;

import prj.fleet.Aircraft;

public class FuelingTruck implements IGroundService{
    @Override
    public boolean canService(Aircraft plane) {
        return plane.getRequiredFuel() > 0;
    }

    @Override
    public String serviceFlight(Aircraft plane) {
        return "Fueling Truck pumped " + plane.getRequiredFuel()
                + "L of jet fuel into " + plane.getFlightNumber() + ".";
    }

}
