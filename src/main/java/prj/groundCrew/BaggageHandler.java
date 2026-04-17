package prj.groundCrew;

import prj.fleet.Aircraft;

public class BaggageHandler implements IGroundService {
    @Override
    public boolean canService(Aircraft plane) {
        return plane.getRequiredBaggage() > 0;
    }

    @Override
    public String serviceFlight(Aircraft plane) {
        return "  " + plane.getRequiredBaggage();  //uncompleted

    }
}
