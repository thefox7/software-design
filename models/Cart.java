package models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void displayCart() {
        System.out.println("Products in your cart:");
        for (Product product : products) {
            product.displayInfo();
        }
    }
}
