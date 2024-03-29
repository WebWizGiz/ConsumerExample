package consumers;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class CheckoutService {   //means I want to pay now!
    private Consumer<Order> processOrder;  //I will give just 1 single argument, its "Order" = is a list of item and price
    private BiConsumer<Order, Coupon> applyDiscount;  //It should take 2 arguments, Double discount and Order..

    //constructor
    public CheckoutService(Consumer<Order> processOrder, BiConsumer<Order, Coupon> applyDiscount) {
        this.processOrder = processOrder;
        this.applyDiscount = applyDiscount;
    }

    //method - no returns value
    public void checkout(Order o, Coupon coupon) {
        if (coupon != null) {
            applyDiscount.accept(o, coupon);
        }

        processOrder.accept(o);
    }

}
