package prj.groundCrew;

import prj.fleet.Aircraft;
import prj.supply.SupplyItem;

public class CargoLoader implements IGroundService {
    @Override
    public boolean canService(Aircraft plane) {
        return plane.getResources().getOrDefault(SupplyItem.CARGO,0) > 0;
    }

    @Override
    public String serviceFlight(Aircraft plane) {
        return "Cargo Loader loaded " + plane.getResources().get(SupplyItem.CARGO)
                + " parcels onto airplane #" + String.format("%06d",plane.getFlightNumber()) + ".";
    }
}
