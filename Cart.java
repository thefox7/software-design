package models;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private static Cart instance;
    private Map<String, Integer> items;

    private Cart() {
        items = new HashMap<>();
    }

    public static Cart getInstance() {
        if (instance == null) {
            instance = new Cart();
        }
        return instance;
    }

    public void addItem(String itemName) {
        items.put(itemName, items.getOrDefault(itemName, 0) + 1);
    }

    public void removeItem(String itemName) {
        items.remove(itemName);
    }

    public Map<String, Integer> getItems() {
        return items;
    }
}
