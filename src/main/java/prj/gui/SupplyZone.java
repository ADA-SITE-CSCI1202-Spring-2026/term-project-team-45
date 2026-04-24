package prj.gui;

import prj.supply.SupplyItem;

import javax.swing.*;

public class SupplyZone extends JPanel {
    // This array is meant to ensure that the MONEY enum does not appear as a purchasable option in the JComboBox dropdown menu
    private final SupplyItem[] resourceEnumSubset = {SupplyItem.FUEL, SupplyItem.MEAL, SupplyItem.LUGGAGE, SupplyItem.CARGO, SupplyItem.LUXURY_MEAL, SupplyItem.CREW};
    private final JComboBox<SupplyItem> resourcePurchaseMenu = new JComboBox<>(resourceEnumSubset);

    private final JButton purchaseButton = new JButton("Purchase");

    public SupplyZone() {
        add(resourcePurchaseMenu);
        add(purchaseButton);
    }

    public JComboBox<SupplyItem> getResourcePurchaseMenu() {
        return resourcePurchaseMenu;
    }

    public JButton getPurchaseButton() {
        return purchaseButton;
    }
}
