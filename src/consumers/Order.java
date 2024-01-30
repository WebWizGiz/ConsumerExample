package consumers;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<String> items;
    private double totalPrice;
    private List<Coupon> appliedCoupons;

    //constructor
    public Order() {
        this.items = new ArrayList<String>();
        this.totalPrice = 0.0;
        this.appliedCoupons = new ArrayList<>();

    }

    //method to add an item - no return value
    public void addItem(String item, double price) {
        items.add(item);
        totalPrice += price;
    }

    //getters
    public List<String> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    //method to apply the discount
    public void applyDiscount(double discount){
        totalPrice -= discount;
    }

    //method to apply the coupons
    public void applyCoupon(Coupon coupon){
        double discount = totalPrice * (coupon.getDiscountPercentage() / 100);
        totalPrice -= discount;
        appliedCoupons.add(coupon);
        System.out.println("Coupon " + coupon.getNumber() + " applied. Discount: $" + String.format("%.2f", discount));
    }
}
