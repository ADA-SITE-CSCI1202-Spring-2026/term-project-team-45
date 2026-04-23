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
                flightQueue.add(new CommercialJet(rr.nextInt(5000, 15000), rr.nextInt(1,10), rr.nextInt(100,200), rr.nextInt(50,150), rr.nextInt(30000, 60000)));
                getLastAircraftOnQueue().generateAndAssignAircraftModel();
            }
            case 1 -> {
                flightQueue.add(new CargoFreighter(rr.nextInt(5000, 12000), rr.nextInt(1,5), rr.nextInt(30,120), rr.nextInt(25000, 35000)));
                getLastAircraftOnQueue().generateAndAssignAircraftModel();
            }
            case 2 -> {
                flightQueue.add(new PrivateCharter(rr.nextInt(3000, 8000), rr.nextInt(1,8), rr.nextInt(10,40), rr.nextInt(201),  rr.nextInt(40000, 80000)));
                getLastAircraftOnQueue().generateAndAssignAircraftModel();
            }
        }
    }

    public Aircraft getLastAircraftOnQueue() {
        return flightQueue.peekLast();
    }

    public Aircraft getAndRemoveLastAircraftOnQueue() {
        return flightQueue.poll();
    }
}
