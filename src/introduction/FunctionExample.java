package introduction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionExample {
    public static void main(String[] args) {

        List<User> users = List.of(
                new User("Alice", "alice@example.com"),
                new User("Bob", "bob@example.com"),
                new User("Charlie", "charlie@example.com")
        );

        // Function to extract emails
        //Function<User, String> extractEmail = User::getEmail;  //--> getMail method from User class

        Function<User, String> extractEmail = user -> user.getEmail(); //lambda version
//-------------------------------------------------------------------------------------------------
        // Example of using Function in Java:
        Map<String, Integer> nameMap = new HashMap<>();

        // in the below line the Function is used:
        //Integer value = nameMap.computeIfAbsent("Gizem", g -> g.length());  //lambda version
        Integer value = nameMap.computeIfAbsent("Gizem", String::length);

        //System.out.println(value);
//-------------------------------------------------------------------------------------------------
        //Function to create invitation message
        Function<User, String> createInvitation = user -> {
            String userName = user.getName();
            String message = "Dear %s, \nWe are pleased to invite you to the Java Developer Conference 2024." +
                    "\nYour participation is greatly anticipated!\nBest Regards,\nJava Conference Organizers";
            return String.format(message, user.getName());
        };

        // Instance of EmailService
        EmailService es = new EmailService();

        // Combine the functions to send out invitations
        List<String> emailsList = users.stream()
                .map(
                        user -> {
                            String emailAddress = extractEmail.apply(user);
                            String invitation = createInvitation.apply(user);
                            es.sendEmail(emailAddress, invitation); // use Email Service to send the email
                            return emailAddress;
                        }
                )
                .collect(Collectors.toList());

        System.out.println("Invitations sent to all users: " + emailsList);

    }

}
