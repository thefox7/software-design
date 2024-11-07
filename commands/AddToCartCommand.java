package commands;

import models.Cart;
import models.Product;

public class AddToCartCommand {
    private Product product;

    public AddToCartCommand(Product product) {
        this.product = product;
    }

    public void execute() {
        Cart.getInstance().addProduct(product);
        System.out.println(product.getName() + " added to cart.");
    }
}
