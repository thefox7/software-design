package models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static Cart instance;
    private List<Product> products;

    private Cart() {
        products = new ArrayList<>();
    }

    public static Cart getInstance() {
        if (instance == null) {
            instance = new Cart();
        }
        return instance;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void displayCart() {
        if (products.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Products in your cart:");
            for (Product product : products) {
                product.displayInfo();
            }
        }
    }
}
