package commands;

import models.Cart;
import models.Product;

public class AddToCartCommand {
    private Cart cart;
    private Product product;

    public AddToCartCommand(Cart cart, Product product) {
        this.cart = cart;
        this.product = product;
    }

    public void execute() {
        cart.addProduct(product);
    }
}
