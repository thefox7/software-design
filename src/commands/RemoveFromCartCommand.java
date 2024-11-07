package commands;

import models.Cart;
import models.Product;

public class RemoveFromCartCommand {
    private Cart cart;
    private Product product;

    public RemoveFromCartCommand(Cart cart, Product product) {
        this.cart = cart;
        this.product = product;
    }

    public void execute() {
        cart.removeProduct(product);
    }
}
