package models;

public class ProductFactory {
    public Product createLaptop() {
        return new Laptop();
    }

    public Product createSmartphone() {
        return new Smartphone();
    }
}
