package prj.supply;

import prj.fleet.Aircraft;

import java.util.Map;
import java.util.HashMap;

public class DepotManager {
    private final Map<SupplyItem, Integer> airportSupply = new HashMap<>();

    private final int INITIAL_FUEL = 25000; // In Liters
    private final int INITIAL_MEAL = 10000; // In Kilograms
    private final int INITIAL_LUGGAGE = 1000; // In # of Units
    private final int INITIAL_MONEY = 20000; // In Manats

    public DepotManager() {
        airportSupply.put(SupplyItem.FUEL, INITIAL_FUEL);
        airportSupply.put(SupplyItem.MEAL, INITIAL_MEAL);
        airportSupply.put(SupplyItem.LUGGAGE_CART, INITIAL_LUGGAGE);
        airportSupply.put(SupplyItem.MONEY, INITIAL_MONEY);
    }

    // Double-purposed function: Check if resource deduction is possible and deduct if possible
    public boolean CheckAndDeductResource(SupplyItem item, int amount) {
        if (airportSupply.get(item) - amount > 0) {
            airportSupply.put(item, airportSupply.get(item) - amount);

            // use the return keyword in GUI to send ERROR message to radio if not possible
            // true means resource deduction possible
            return true;
        }

        return false;
    }
}
