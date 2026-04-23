package prj.groundCrew;

import prj.fleet.Aircraft;
import prj.supply.SupplyItem;

public class CrewService implements IGroundService {
    @Override
    public boolean canService(Aircraft plane) {
        return plane.getResources().getOrDefault(SupplyItem.CREW,0) > 0;
    }

    @Override
    public String serviceFlight(Aircraft plane) {
        return "Crew Service dispatched a crew of " + plane.getResources().get(SupplyItem.CREW)
                + " to airplane " + plane.getFlightNumber() + ".";
    }
}
