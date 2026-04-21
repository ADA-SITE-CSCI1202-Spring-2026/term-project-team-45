package prj.generator;

import prj.fleet.*;

import java.util.*;
import java.util.random.RandomGenerator;

public class TaskGenerator {
    private final RandomGenerator rr = RandomGenerator.of("L64X128MixRandom");

    private final Deque<Aircraft> flightQueue = new ArrayDeque<>();

    /*
    private final List<Aircraft> flightTaskList = new ArrayList<>(List.of(
            new CargoFreighter(15000, 100, 0, 0),
            new CargoFreighter(0, 100, 15, 0),
            new CargoFreighter(0, 100, 0, 50),
            new CargoFreighter(10000, 100, 0, 15),
            new CargoFreighter(rr.nextInt(5000, 20001), 100, 0, rr.nextInt(31)),
            new CargoFreighter(0, 100, rr.nextInt(16), rr.nextInt(31)),
            new CommercialJet(7000, 100, 0, 0, 0),
            new CommercialJet(0, 100, 2, 0, 0),
            new CommercialJet(0, 100, 0, 100, 0),
            new CommercialJet(0, 100, 0, 0, 300),
            new CommercialJet(3000, 100, 10, 0, 0),
            new CommercialJet(0, 100, 3, 20, 100),
            new CommercialJet(rr.nextInt(1000, 3001), 100, 0, 0, rr.nextInt(20, 81))
    ));
    */

    /*
    public void generateAndAddAircraftTask() {
        int randomListIndex = rand.nextInt(flightTaskList.size());
        flightQueue.add(flightTaskList.get(randomListIndex));
    }
    */

    public void generateAndAddAircraftTask() {
        switch(rr.nextInt(3)) {
            case 0 -> flightQueue.add(new CommercialJet(rr.nextInt(1000, 20001), 100, rr.nextInt(36), rr.nextInt(251), rr.nextInt(401), rr.nextInt(25000, 35000)));
            case 1 -> flightQueue.add(new CargoFreighter(rr.nextInt(1000, 20001), 100, rr.nextInt(36), rr.nextInt(501), rr.nextInt(25000, 35000)));
            case 2 -> flightQueue.add(new PrivateCharter(rr.nextInt(1000, 20001), 100, rr.nextInt(36), rr.nextInt(251), rr.nextInt(401), rr.nextInt(51), rr.nextInt(25000, 35000)));
        }
    }

    public Aircraft getLastAircraftOnQueue() {
        return flightQueue.peekLast();
    }
}
