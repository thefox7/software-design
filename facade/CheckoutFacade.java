package facade;

import models.Cart;

public class CheckoutFacade {
    public void checkout() {
        Cart cart = Cart.getInstance();
        System.out.println("Checking out the following items:");
        cart.displayCart();
        System.out.println("Total amount: $" + cart.getProducts().stream().mapToDouble(p -> p.getPrice()).sum());
        System.out.println("Thank you for your purchase!");
    }
}
