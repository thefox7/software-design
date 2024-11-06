package factories;

import models.*;

public class ProductFactory {
    public static Product createProduct(String type) {
        return switch (type) {
            case "Laptop" -> new Laptop();
            case "Smartphone" -> new Smartphone();
            default -> throw new IllegalArgumentException("Unknown product type");
        };
    }
}
