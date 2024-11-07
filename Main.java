import commands.AddToCartCommand;
import commands.RemoveFromCartCommand;
import facade.CheckoutFacade;
import models.Cart;
import models.ProductFactory;
import observers.DiscountNotifier;

public class Main {
    public static void main(String[] args) {
        ProductFactory factory = new ProductFactory();
        Cart cart = Cart.getInstance();
        CheckoutFacade checkout = new CheckoutFacade();

        // Observer example
        DiscountNotifier notifier = new DiscountNotifier();
        notifier.addObserver(product -> System.out.println("Discount on " + product + " applied!"));
        notifier.notifyDiscount("Laptop");

        // Command example
        var laptop = factory.createProduct("laptop");
        var smartphone = factory.createProduct("smartphone");

        AddToCartCommand addLaptop = new AddToCartCommand(laptop);
        AddToCartCommand addSmartphone = new AddToCartCommand(smartphone);

        addLaptop.execute();
        addSmartphone.execute();

        RemoveFromCartCommand removeLaptop = new RemoveFromCartCommand(laptop);
        removeLaptop.execute();

        cart.displayCart();

        // Facade example
        checkout.checkout();
    }
}
