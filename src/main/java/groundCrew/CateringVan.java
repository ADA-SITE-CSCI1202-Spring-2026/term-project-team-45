package groundCrew;

import prj.fleet.Aircraft;

public class CateringVan implements IGroundService{
    @Override
    public boolean canService(Aircraft plane) {
        return plane.getRequiredMeals() > 0;
    }

    @Override
    public String serviceFlight(Aircraft plane) {
        return "Catering Van loaded " + plane.getRequiredMeals()
                + " meals onto " + plane.getFlightNumber() + ".";
    }
}
