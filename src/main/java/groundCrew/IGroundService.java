package groundCrew;

import prj.fleet.Aircraft;

public interface IGroundService {
    public boolean canService(Aircraft plane);
    public String serviceFlight(Aircraft plane);
}
