package observers;

import java.util.ArrayList;
import java.util.List;

public class DiscountNotifier {
    private List<DiscountObserver> observers = new ArrayList<>();

    public void addObserver(DiscountObserver observer) {
        observers.add(observer);
    }

    public void notifyDiscount(String product) {
        for (DiscountObserver observer : observers) {
            observer.onDiscountApplied(product);
        }
    }
}
