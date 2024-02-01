package custom_functional_interfaces.PracticeExercise1;

@FunctionalInterface
public interface StringProcessor {
String process (String input);  //--> abstract method

    //default methods
    default String defaultProcess(String input){
        return "Processed: " + process(input);
    }


}
