package prj.groundCrew;

import prj.fleet.Aircraft;
import prj.supply.SupplyItem;

public class FuelingTruck implements IGroundService{
    @Override
    public boolean canService(Aircraft plane) {
        return plane.getResources().getOrDefault(SupplyItem.FUEL,0) > 0;
    }

    @Override
    public String serviceFlight(Aircraft plane) {
        return "Fueling Truck pumped " + plane.getResources().get(SupplyItem.FUEL)
                + "L of jet fuel into " + plane.getFlightNumber() + ".";
    }

}
