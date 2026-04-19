package prj.gui;

import prj.supply.SupplyItem;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.EnumMap;


public class DepotZone extends JPanel {
    private final Map<SupplyItem, JLabel> resourceMap = new EnumMap<>(SupplyItem.class);

    public DepotZone() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // The given Strings to the labels are temporary as they will be overridden by the Controller
        resourceMap.put(SupplyItem.FUEL, new JLabel("Fuel"));
        resourceMap.put(SupplyItem.MEAL, new JLabel("Meal"));
        resourceMap.put(SupplyItem.LUGGAGE_CART, new JLabel("Luggage"));
        resourceMap.put(SupplyItem.MONEY, new JLabel("Money"));

        // Quickly iterate over the map to assign each label a font size and boldness rather than waste space writing individually
        for (SupplyItem item : resourceMap.keySet()) {
            resourceMap.get(item).setFont(new Font("Serif", Font.BOLD, 24));
            add(resourceMap.get(item));
        }
    }

    public void setResourceLabelValue(SupplyItem item, int value) {
        switch (item) {
            case SupplyItem.FUEL -> resourceMap.get(item).setText("Fuel: " + value);
            case SupplyItem.MEAL -> resourceMap.get(item).setText("Meal: " + value);
            case SupplyItem.LUGGAGE_CART -> resourceMap.get(item).setText("Luggage: " + value);
            case SupplyItem.MONEY -> resourceMap.get(item).setText("Money: " + value);
            default -> {}
        }
    }
}
