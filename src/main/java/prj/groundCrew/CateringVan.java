package prj.groundCrew;

import prj.fleet.Aircraft;
import prj.supply.SupplyItem;

public class CateringVan implements IGroundService{
    @Override
    public boolean canService(Aircraft plane) {
        return plane.getResources().get(SupplyItem.MEAL) > 0;
    }

    @Override
    public String serviceFlight(Aircraft plane) {
        return "Catering Van loaded " + plane.getResources().get(SupplyItem.MEAL)
                + " meals onto " + plane.getFlightNumber() + ".";
    }
}
