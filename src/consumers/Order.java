package consumers;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<String> items;
    private double totalPrice;

    //constructor

    public Order() {
        this.items = new ArrayList<String>();
        this.totalPrice = 0.0;

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
}
