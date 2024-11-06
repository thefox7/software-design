import models.*;
import factories.*;
import decorators.*;
import facades.*;
import services.*;
import observers.*;
import strategies.*;
import mvc.*;

public class Main {
    public static void main(String[] args) {
        // Singleton pattern
        DatabaseConnection db = DatabaseConnection.getInstance();
        db.connect();

        // Factory pattern
        Product laptop = ProductFactory.createProduct("Laptop");

        // Decorator pattern
        CustomizableProduct decoratedLaptop = new ExtendedWarranty(new BasicLaptop());
        System.out.println(decoratedLaptop.getDescription() + " - $" + decoratedLaptop.getPrice());

        // Facade pattern
        CheckoutFacade checkout = new CheckoutFacade();
        checkout.checkout(laptop);

        // Observer pattern
        ProductNotifier notifier = new ProductNotifier();
        notifier.addObserver(new Customer("Alice"));
        notifier.notifyObservers("Laptop back in stock!");

        // Strategy pattern
        DiscountContext discountContext = new DiscountContext();
        discountContext.setDiscountStrategy(new PercentageDiscount(10));
        System.out.println("Discounted price: $" + discountContext.applyDiscount(1000));

        // MVC
        Cart cart = new Cart();
        CartView cartView = new CartView();
        CartController cartController = new CartController(cart, cartView);

        cartController.addProductToCart(laptop);
        cartController.displayCart();
    }
}
