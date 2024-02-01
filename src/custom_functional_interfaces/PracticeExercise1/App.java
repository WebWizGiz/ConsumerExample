package custom_functional_interfaces.PracticeExercise1;

public class App {
    public static void main(String[] args) {

        //lambda expression to convert a string to UPPERCASE
        StringProcessor upperCaseProcessor = input -> input.toUpperCase();

        //lambda expression to reverse a string
        StringProcessor reverseProcesor = input -> {
            StringBuilder reversed = new StringBuilder(input);
            return reversed.toString();
        };

        //demo
        String inputString = "This is an example!";
        System.out.println("Old one: " + inputString);

        //apply and print them
        String resultUppercase = upperCaseProcessor.process(inputString);
        String resultReversed = reverseProcesor.process(inputString);

        System.out.println("Uppercased: " + resultUppercase);
        System.out.println("Reversed: " + resultReversed);

        //test the default method
        String resultDefaultMethod= upperCaseProcessor.defaultProcess(inputString);
        System.out.println("Default Processed: " + resultDefaultMethod);

    }
}
