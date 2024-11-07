package commands;

import models.Cart;
import models.Product;

public class RemoveFromCartCommand {
    private Product product;

    public RemoveFromCartCommand(Product product) {
        this.product = product;
    }

    public void execute() {
        Cart.getInstance().removeProduct(product);
        System.out.println(product.getName() + " removed from cart.");
    }
}
