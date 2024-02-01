package custom_functional_interfaces.lesson1;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class App {
    public static void main(String[] args) {
        Calculator addition = Double :: sum; // method reference
        Calculator subtruction = (n1, n2) -> n1 - n2; // lambda expression
        Calculator multiplication = (n1, n2) -> n1 * n2;
        Calculator division = (n1, n2) ->{
            if (n2 == 0) throw  new ArithmeticException("Division by zero is not allowed.");
            return n1/n2;
        };

        //Preffered: always to use the Built-in functional interfaces in the java.util.function package
        BinaryOperator<Double> sum = Double :: sum;

        //Demo
        System.out.println("Addition: " + addition.calculate(10, 5));
        System.out.println("Subtruction: " + subtruction.calculate(10, 5));
        System.out.println("Multiplication: " + multiplication.calculate(10, 5));
        System.out.println("Division: " + division.calculate(10, 5));
        System.out.println("BinaryOperator sum: " + sum.apply(15.0, 2.0));

    }
}
