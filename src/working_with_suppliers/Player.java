package working_with_suppliers;

public class Player {
    private String name;
    private int health;

    //constructor
    public Player(String name, int health) {
        this.name = name;
        this.health = health;
    }

    //getters
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    //methods
    public void takeDamage(int damage){
        health -= damage;
    }

    public boolean isAlive(){
        return health > 0;
    }
}
