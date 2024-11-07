package models;

public class Smartphone extends Product {
    public Smartphone() {
        super("Smartphone", 800.0);
    }

    @Override
    public void displayInfo() {
        System.out.println("Product: " + name + ", Price: $" + price);
    }
}
