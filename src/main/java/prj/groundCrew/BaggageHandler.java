package prj.groundCrew;

import prj.fleet.Aircraft;
import prj.supply.SupplyItem;

public class BaggageHandler implements IGroundService {
    @Override
    public boolean canService(Aircraft plane) {
        return plane.getResources().get(SupplyItem.LUGGAGE_CART) > 0;
    }

    @Override
    public String serviceFlight(Aircraft plane) {
        return "Baggage Handler loaded " + plane.getResources().get(SupplyItem.LUGGAGE_CART)
                + " carts onto " + plane.getFlightNumber() + ".";

    }
}
