package models;

public abstract class Product {
    protected String name;
    protected double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public abstract void displayInfo();

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
