package custom_functional_interfaces.PracticeExercise2;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        //lambda expression to double
        NumberProcessor doubleProcessor = number -> number * 2;

        //lamda expression to square
        NumberProcessor squareProcessor = number -> number * number;

        //lambda expression to increment a number by one
        NumberProcessor incrementProcessor = number -> number + 1;

        //test
        int[] numbers = {3, 5, 7};

        System.out.println("Orginal Numbers: " + Arrays.toString(numbers));
        //apply and print them
        System.out.println("Doubled: " + processedNumbers(numbers, doubleProcessor));
        System.out.println("Squared: " + processedNumbers(numbers, squareProcessor));
        System.out.println("Incremented: " + processedNumbers(numbers, incrementProcessor));

    }

    //helper method to process an array of numbers using a NumberProcessor
    private static String processedNumbers(int[] numbers, NumberProcessor incrementProcessor) {
    int[] resultNumbers = Arrays.stream(numbers).map(incrementProcessor::process).toArray();
    return Arrays.toString(resultNumbers);
    }
}
