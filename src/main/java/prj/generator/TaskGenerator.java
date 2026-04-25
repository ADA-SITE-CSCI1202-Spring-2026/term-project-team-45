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
                flightQueue.add(new CommercialJet(rr.nextInt(5000, 15001), rr.nextInt(11), rr.nextInt(201), rr.nextInt(151), rr.nextInt(30000, 60001)));
                getLastAircraftOnQueue().generateAndAssignAircraftModel();
            }
            case 1 -> {
                flightQueue.add(new CargoFreighter(rr.nextInt(5000, 12001), rr.nextInt(6), rr.nextInt(121), rr.nextInt(25000, 35001)));
                getLastAircraftOnQueue().generateAndAssignAircraftModel();
            }
            case 2 -> {
                flightQueue.add(new PrivateCharter(rr.nextInt(3000, 8001), rr.nextInt(9), rr.nextInt(41), rr.nextInt(201),  rr.nextInt(40000, 80001)));
                getLastAircraftOnQueue().generateAndAssignAircraftModel();
            }
        }
    }

    public Aircraft getFirstAircraftOnQueue() {
        return flightQueue.peekFirst();
    }

    public Aircraft getAndRemoveFirstAircraftFromQueue() {
        return flightQueue.poll();
    }

    // This method is meant to be read-only value to be used with showing aircraft on the GUI
    public Aircraft getLastAircraftOnQueue() {
        return flightQueue.peekLast();
    }

    public Deque<Aircraft> getFlightQueue() {
        return flightQueue;
    }

    public void resetAircraftQueue() {
        flightQueue.clear();
    }

    public void repopulateAircraftQueue(Deque<Aircraft> flightQueue) {
        this.flightQueue.addAll(flightQueue);
    }
}
