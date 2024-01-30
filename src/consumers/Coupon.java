package consumers;

public class Coupon {
    private String number;
    private double discountPercentage;

    //constructor
    public Coupon(String number, double discountPercentage) {
        this.number = number;
        this.discountPercentage = discountPercentage;
    }

    //getters
    public String getNumber() {
        return number;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

}
