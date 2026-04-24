package prj.groundCrew;

import prj.fleet.Aircraft;

public interface IGroundService {
    boolean canService(Aircraft plane);
    String serviceFlight(Aircraft plane);
}
