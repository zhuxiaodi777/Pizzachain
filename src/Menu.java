package java;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Item> menuItems;

    // Constructor to initialize the list of menu items
    public Menu() {
        this.menuItems = new ArrayList<>();
    }

    // Method to add an item to the menu
    public void addItem(Item item) {
        menuItems.add(item);
    }

    // Method to remove an item from the menu
    public void removeItem(Item item) {
        menuItems.remove(item);
    }

    // Method to get only the available items from the menu
    public List<Item> getAvailableItems() {
        List<Item> availableItems = new ArrayList<>();
        for (Item item : menuItems) {
            if (item.isAvailable()) {
                availableItems.add(item);
            }
        }
        return availableItems;
    }

    @Override
    public String toString() {
        return "Menu{" + "menuItems=" + menuItems + '}';
    }
}
