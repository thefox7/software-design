package models;

public class Laptop extends Product {
    public Laptop() {
        super("Laptop", 1200.0);
    }

    @Override
    public void displayInfo() {
        System.out.println("Product: " + name + ", Price: $" + price);
    }
}
