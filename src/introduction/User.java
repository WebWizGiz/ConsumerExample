package introduction;

public class User {
    private String name;
    private String email;

    //constructor
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    //getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
