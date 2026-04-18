package prj.groundCrew;

import prj.fleet.Aircraft;
import prj.supply.SupplyItem;

public class LuxuryService implements IGroundService{
    @Override
    public boolean canService(Aircraft plane) {
        return plane.getResources().get(SupplyItem.LUXURY_ITEMS) > 0;
    }

    @Override
    public String serviceFlight(Aircraft plane) {
        return "Luxury service provided " + plane.getResources().get(SupplyItem.LUXURY_ITEMS)
                + " luxury items to the airplane " + plane.getFlightNumber() + ".";
    }
}
