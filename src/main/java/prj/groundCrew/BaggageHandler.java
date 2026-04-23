package prj.groundCrew;

import prj.fleet.Aircraft;
import prj.supply.SupplyItem;

public class BaggageHandler implements IGroundService {
    @Override
    public boolean canService(Aircraft plane) {
        return plane.getResources().getOrDefault(SupplyItem.LUGGAGE,0) > 0;
    }

    @Override
    public String serviceFlight(Aircraft plane) {
        return "Baggage Handler loaded " + plane.getResources().get(SupplyItem.LUGGAGE)
                + " carts onto " + plane.getFlightNumber() + ".";

    }
}
