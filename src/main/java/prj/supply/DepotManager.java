package prj.supply;

import java.util.EnumMap;
import java.util.Map;
import java.util.HashMap;

public class DepotManager {
    private final Map<SupplyItem, Integer> airportSupply = new HashMap<>();

    // To be only used when initializing the DepotManager class
    private final int INITIAL_FUEL = 25000; // In Liters
    private final int INITIAL_MEAL = 10000; // In # of Units
    private final int INITIAL_LUGGAGE = 1000; // In # of Units
    private final int INITIAL_CARGO = 200; // In Crates
    private final int INITIAL_LUXURY_MEAL = 100; // In # of Units
    private final int INITIAL_CREW = 30; // In Person(s)
    private final int INITIAL_MONEY = 50000; // In Manats

    // Default purchase amount for each resource
    private final int FUEL_BUY_AMOUNT = 10000;
    private final int MEAL_BUY_AMOUNT = 1000;
    private final int LUGGAGE_BUY_AMOUNT = 250;
    private final int CARGO_BUY_AMOUNT = 50;
    private final int LUXURY_MEAL_BUY_AMOUNT = 40;
    private final int CREW_BUY_AMOUNT = 5;

    // Use EnumMap since it is meant to work with Enum, Value maps and initialize an unmodifiable map to store default purchase amount values
    private final Map<SupplyItem, Integer> defaultResourceBuyAmount = new EnumMap<>(Map.of(
            SupplyItem.FUEL, FUEL_BUY_AMOUNT,
            SupplyItem.MEAL, MEAL_BUY_AMOUNT,
            SupplyItem.LUGGAGE, LUGGAGE_BUY_AMOUNT,
            SupplyItem.CARGO, CARGO_BUY_AMOUNT,
            SupplyItem.LUXURY_MEAL, LUXURY_MEAL_BUY_AMOUNT,
            SupplyItem.CREW, CREW_BUY_AMOUNT
    ));

    // Price for each resource per defined default amount (in manats)
    private final int FUEL_PRICE = 5000;
    private final int MEAL_PRICE = 3000;
    private final int LUGGAGE_PRICE = 1000;
    private final int CARGO_PRICE = 1000;
    private final int LUXURY_MEAL_PRICE = 500;
    private final int CREW_PRICE = 400; // Price of hiring a single crew member for a single task

    // Use EnumMap to create an unmodifiable resource to price pair to be used by buyResource method
    private final Map<SupplyItem, Integer> resourcePrice = new EnumMap<>(Map.of(
            SupplyItem.FUEL, FUEL_PRICE,
            SupplyItem.MEAL, MEAL_PRICE,
            SupplyItem.LUGGAGE, LUGGAGE_PRICE,
            SupplyItem.CARGO, CARGO_PRICE,
            SupplyItem.LUXURY_MEAL, LUXURY_MEAL_PRICE,
            SupplyItem.CREW, CREW_PRICE
    ));

    public DepotManager() {
        airportSupply.put(SupplyItem.FUEL, INITIAL_FUEL);
        airportSupply.put(SupplyItem.MEAL, INITIAL_MEAL);
        airportSupply.put(SupplyItem.LUGGAGE, INITIAL_LUGGAGE);
        airportSupply.put(SupplyItem.CARGO, INITIAL_CARGO);
        airportSupply.put(SupplyItem.LUXURY_MEAL, INITIAL_LUXURY_MEAL);
        airportSupply.put(SupplyItem.CREW, INITIAL_CREW);
        airportSupply.put(SupplyItem.MONEY, INITIAL_MONEY);
    }

    // More flexible helper getter to get any resource amount
    public int getResourceAmount(SupplyItem item) {
        return airportSupply.get(item);
    }

    // Check to see there is enough of the resource in the supply before it is to be consumed
    public boolean checkResourceSupply(SupplyItem item, int amount) {
        return airportSupply.get(item) >= amount;
    }

    public void deductResource(SupplyItem item, int amount) {
        if (checkResourceSupply(item, amount)) {
            airportSupply.put(item, airportSupply.get(item) - amount);
        }
    }

    // To be used when a successful processing takes place
    public void addMoney(int amount) {
        airportSupply.put(SupplyItem.MONEY, airportSupply.get(SupplyItem.MONEY) + amount);
    }

    public boolean buyResource(SupplyItem item) {
        if (resourcePrice.get(item) <= airportSupply.get(SupplyItem.MONEY)) {
            airportSupply.put(item, airportSupply.get(item) + defaultResourceBuyAmount.get(item));
            airportSupply.put(SupplyItem.MONEY, airportSupply.get(SupplyItem.MONEY) - resourcePrice.get(item));

            // true indicates a successful purchase and shall be reflected in the radio
            return true;
        }

        // false indicates lack of money to purchase the resource and shall put out an ERROR in the radio
        return false;
    }
}
