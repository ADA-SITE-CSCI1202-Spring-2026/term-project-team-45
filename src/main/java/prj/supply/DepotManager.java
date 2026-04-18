package prj.supply;

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

    // Default purchase amount for each resource
    private final int FUEL_BUY_AMOUNT = 10000;
    private final int MEAL_BUY_AMOUNT = 2000;
    private final int LUGGAGE_BUY_AMOUNT = 250;

    // Use EnumMap since it is meant to work with Enum, Value maps and initialize an unmodifiable map to store default purchase amount values
    private final Map<SupplyItem, Integer> defaultResourceBuyAmount = new EnumMap<>(Map.of(
            SupplyItem.FUEL, FUEL_BUY_AMOUNT,
            SupplyItem.MEAL, MEAL_BUY_AMOUNT,
            SupplyItem.LUGGAGE_CART, LUGGAGE_BUY_AMOUNT
    ));

    // Price for each resource per defined default amount (in manats)
    private final int FUEL_PRICE = 5000;
    private final int MEAL_PRICE = 3000;
    private final int LUGGAGE_PRICE = 1000;

    // Use EnumMap to create an unmodifiable resource to price pair to be used by buyResource method
    private final Map<SupplyItem, Integer> resourcePrice = new EnumMap<>(Map.of(
            SupplyItem.FUEL, FUEL_PRICE,
            SupplyItem.MEAL, MEAL_PRICE,
            SupplyItem.LUGGAGE_CART, LUGGAGE_PRICE
    ));

    public DepotManager() {
        airportSupply.put(SupplyItem.FUEL, INITIAL_FUEL);
        airportSupply.put(SupplyItem.MEAL, INITIAL_MEAL);
        airportSupply.put(SupplyItem.LUGGAGE_CART, INITIAL_LUGGAGE);
        airportSupply.put(SupplyItem.MONEY, INITIAL_MONEY);
    }

    public int getFuelAmount() {
        return airportSupply.get(SupplyItem.FUEL);
    }

    public int getMealAmount() {
        return airportSupply.get(SupplyItem.MEAL);
    }

    public int getLuggageAmount() {
        return airportSupply.get(SupplyItem.LUGGAGE_CART);
    }

    public int getMoneyAmount() {
        return airportSupply.get(SupplyItem.MONEY);
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

    // TODO: Implement Java Swing components to the DepotManage methods in order to allow the methods to update text on GUI
    // TODO: Implement the Java Swing components without using
}
