package models;

public class Laptop extends Product {
    public Laptop() {
        this.name = "Laptop";
        this.price = 1200.0;
    }

    @Override
    public void displayInfo() {
        System.out.println("Product: " + name + ", Price: $" + price);
    }
}
