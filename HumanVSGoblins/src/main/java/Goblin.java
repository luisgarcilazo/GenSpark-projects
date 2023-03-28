public class Goblin implements Entity {
    private String name = "Unknown Goblin";
    private int x;
    private int y;
    private int health = 3;

    private int strength = 1;

    public Goblin(int x, int y){
        if (x < 0 || y < 0){
            throw new IllegalArgumentException("Not valid input for Goblin.");
        }
        this.x = x;
        this.y = y;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public char getUTFChar() {
        return 'G';
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public void setName(String name) {
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
}
