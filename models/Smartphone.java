package models;

public class Smartphone extends Product {
    public Smartphone() {
        this.name = "Smartphone";
        this.price = 800.0;
    }

    @Override
    public void displayInfo() {
        System.out.println("Product: " + name + ", Price: $" + price);
    }
}
