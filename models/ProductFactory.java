package models;

public class ProductFactory {
    public Product createProduct(String type) {
        switch (type.toLowerCase()) {
            case "laptop":
                return new Laptop();
            case "smartphone":
                return new Smartphone();
            default:
                return null;
        }
    }
}
