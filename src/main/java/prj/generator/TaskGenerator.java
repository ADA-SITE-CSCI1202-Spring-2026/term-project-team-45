package prj.generator;

import prj.fleet.*;

import java.util.*;
import java.util.random.RandomGenerator;

public class TaskGenerator {
    private final RandomGenerator rr = RandomGenerator.of("L64X128MixRandom");

    private final Deque<Aircraft> flightQueue = new ArrayDeque<>();

    public void generateAndAddAircraftTask() {
        switch(rr.nextInt(3)) {
            case 0 -> {
                flightQueue.add(new CommercialJet(rr.nextInt(1000, 20001), 100, rr.nextInt(36), rr.nextInt(251), rr.nextInt(401), rr.nextInt(25000, 35000)));
                getLastAircraftOnQueue().generateAndAssignAircraftModel();
            }
            case 1 -> {
                flightQueue.add(new CargoFreighter(rr.nextInt(1000, 20001), 100, rr.nextInt(36), rr.nextInt(501), rr.nextInt(25000, 35000)));
                getLastAircraftOnQueue().generateAndAssignAircraftModel();
            }
            case 2 -> {
                flightQueue.add(new PrivateCharter(rr.nextInt(1000, 20001), 100, rr.nextInt(36), rr.nextInt(121), rr.nextInt(201),  rr.nextInt(25000, 35000)));
                getLastAircraftOnQueue().generateAndAssignAircraftModel();
            }
        }
    }

    public Aircraft getLastAircraftOnQueue() {
        return flightQueue.peekLast();
    }
}
