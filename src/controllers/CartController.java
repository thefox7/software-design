package controllers;

import models.Cart;
import models.Product;
import models.ProductFactory;

public class CartController {

    private Cart cart;
    private ProductFactory productFactory;

    public CartController() {
        this.cart = Cart.getInstance();
        this.productFactory = new ProductFactory();
    }

    public void addProductToCart(String productType) {
        Product product;
        if (productType.equals("Laptop")) {
            product = productFactory.createLaptop();
        } else {
            product = productFactory.createSmartphone();
        }
        cart.addItem(product.getName());
    }

    public void removeProductFromCart(String productName) {
        cart.removeItem(productName);
    }

    public Cart getCart() {
        return cart;
    }
}
