public interface Entity {

    //returns name for object
    String getName();

    //returns UTF-char to be displayed for this char
    char getUTFChar();

    //returns x-pos for entity
    int getX();

    //returns y-pos for entity
    int getY();

    //returns hp for entity
    int getHealth();


    int getStrength();

    //setter for health
    void setHealth(int health);

    //setter for name
    void setName(String name);

    //setter for x-pos
    void setX(int x);

    //setter for y-pos
    void setY(int y);
}
