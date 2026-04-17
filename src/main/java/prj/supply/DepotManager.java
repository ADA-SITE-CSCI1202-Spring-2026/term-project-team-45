package prj.supply;

import prj.fleet.Aircraft;

import java.util.EnumMap;
import java.util.Map;
import java.util.HashMap;

public class DepotManager {
    private final Map<SupplyItem, Integer> airportSupply = new HashMap<>();

    // To be only used when initializing the DepotManager class
    private final int INITIAL_FUEL = 25000; // In Liters
    private final int INITIAL_MEAL = 10000; // In Kilograms
    private final int INITIAL_LUGGAGE = 1000; // In # of Units
    private final int INITIAL_MONEY = 20000; // In Manats

    // Default amount for each resource when re-stocking to be used in the EnumMap for buyResource method
    private final int FUEL_BUY_AMOUNT = 10000;
    private final int MEAL_BUY_AMOUNT = 2000;
    private final int LUGGAGE_BUY_AMOUNT = 250;

    // TODO: Find a way to initialize the EnumMap at the time of declaration
    private final Map<SupplyItem, Integer> defaultResourceBuyAmount = new EnumMap<>(Map.of(
            SupplyItem.FUEL, FUEL_BUY_AMOUNT,
            SupplyItem.MEAL, MEAL_BUY_AMOUNT,
            SupplyItem.LUGGAGE_CART, LUGGAGE_BUY_AMOUNT
    ));

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

    // To be used when a successful processing takes place
    public void addMoney(int amount) {
        airportSupply.put(SupplyItem.MONEY, airportSupply.get(SupplyItem.MONEY) + amount);
    }

    // TODO: Finish the method
    public void buyResource(SupplyItem item) {
        airportSupply.put(item, airportSupply.get(item) + defaultResourceBuyAmount.get(item));
    }
}
