
public class Human implements Entity{
    String name;
    private int x;
    private int y;

    private int health;

    private int strength = 1;

    public Human(String name, int x, int y, int health){
        if(name == null || x < 0 || y < 0 || health <= 0){
            throw new IllegalArgumentException("Not valid input for a human.");
        }
        this.name = name;
        this.x = x;
        this.y = y;
        this. health = health;
    }
    @Override
    public char getUTFChar() {
        return 'H';
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }
    public int getHealth(){
        return this.health;
    }
    public String getName(){
        return this.name;
    }
    public int getStrength(){
        return this.strength;
    }
    public void setHealth(int health){
        this.health = health;
    }
    public void setName(String name){
        this.name = name;
    }

    @Override
    public void setX(int x) {
        if (x < 0){
            throw new IllegalArgumentException("Not a valid x value");
        }
        this.x = x;
    }

    @Override
    public void setY(int y) {
        if (y < 0){
            throw new IllegalArgumentException("Not a valid y value");
        }
        this.y = y;
    }

    public void train(){
        strength++;
    }

    @Override
    public String toString(){
        return "main.java.Human(name: " + name + ", health: " + health + ")";
    }
}
