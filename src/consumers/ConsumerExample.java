package consumers;

import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Order order = new Order();

        //define consumer
        Consumer<Order> processOrder = o -> System.out.println("Order processed. Total: $" + String.format("%.2f", o.getTotalPrice()));

        //define apply discount consumer
        BiConsumer<Order, Double> applyDiscount = (o, d) -> {
            o.applyDiscount(d);
            System.out.println("Discount of $" + d + " applied. New total: $" + String.format("%.2f", o.getTotalPrice()));
        };

        CheckoutService checkoutService = new CheckoutService(processOrder, applyDiscount);
        System.out.println("Welcome to the Java Bookstore!");

        String action;
        do {
            System.out.println("Choose an action: [add] item, [checkout], or [quit]");
            action = input.nextLine();
            switch (action) {
                case "add":
                    System.out.println("Enter the name of the book: ");
                    String item = input.nextLine();
                    System.out.println("Enter the price of the book: ");
                    //Double price = input.nextDouble();
                    double price = Double.parseDouble(input.nextLine());
                    order.addItem(item, price);
                    System.out.println("Item added to order.");
                    break;

                case "checkout":
                    System.out.println("Enter any discount amount, if applicable: ");
                    double discount = Double.parseDouble(input.nextLine());
                    checkoutService.checkout(order, discount);
                    order = new Order(); // reset the order for next customer
                    break;

                case "quit":
                    System.out.println("Thank you for visiting the Java Book Store..");
                    break;

                default:
                    System.out.println("Invalid action. Please try again.");

            }
        } while (!action.equalsIgnoreCase("quit"));

        input.close();
    }
}
