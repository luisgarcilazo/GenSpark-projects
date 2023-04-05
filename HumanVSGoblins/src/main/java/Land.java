import java.util.Random;

public class Land {
    private int width;
    private int height;
    //main.java.Land represented as a grid of entities
    private Entity[][] grid;
    //0,0 corresponds to top-left
    public Land(int width, int height){
        //minimum size of grid is 9x9
        if (width <= 0 || height <= 0){
            throw new IllegalArgumentException("Not valid input for Land.");
        }
        this.height = height;
        this.width = width;
        this.grid = new Entity[width][height];
        for(int i = 0; i < width; i++){
            for (int j = 0; j < height; j++){
                grid[i][j] = null;
            }
        }
    }
    //returns 0 if add is succesful, -1 otherwise
    public int addToGrid(Entity entity){
        if(entity.getX() >= width || entity.getY() >= height || entity.getX() < 0 || entity.getY() < 0){
            System.out.println("A non-valid entity was tried to be added.");
            return -1;
        }
        if (this.grid[entity.getX()][entity.getY()] == null){
            this.grid[entity.getX()][entity.getY()] = entity;
            return 0;
        } else {
            System.out.println("An entity already occupies this spot. Add failed.");
            return -1;
        }
    }
    public Entity[][] getGrid(){
        return grid;
    }

    //returns an error code of -1 if the entity trying to move died, 0 if the entity did not move, 1 else
    public int move(Entity entity, Direction direction){
        int newX = entity.getX();
        int newY = entity.getY();
        switch(direction){
            case EAST:
                System.out.println("Trying to move east.");
                newX = entity.getX()+1;
                break;
            case WEST:
                System.out.println("Trying to move west.");
                newX = entity.getX()-1;
                break;
            case NORTH:
                System.out.println("Trying to move north.");
                newY = entity.getY()+1;
                break;
            case SOUTH:
                System.out.println("Trying to move south.");
                newX = entity.getX();
                newY = entity.getY()-1;
        }
        //error handling delegated to main
        if (newX >= this.width || newY >= this.height || newX < 0 || newY < 0){
            System.out.println("Unable to move to this direction. Please try again.");
            return -1;
        }
        //if newX and newY are null then we know we are in an unoccupied cell, so we are free to move there
        if(this.grid[newX][newY] == null){
            System.out.println("Cell is empty. Let us move!");
            System.out.println("New x-position is: " + newX);
            System.out.println("New y-position is: " + newY);
            this.grid[entity.getX()][entity.getY()] =  null;
            entity.setX(newX);
            entity.setY(newY);
            this.addToGrid(entity);
            return 1;
        } else {
            System.out.println(this.grid[newX][newY].getName() + " occupies this cell. Combat will be initiated.");
            //unoccupied cell, engage combat
            Random rand = new Random();
            int randNum =  rand.nextInt(3); //gets an integer from 0 to 1
            int val = fight(entity, this.grid[newX][newY],randNum);
            switch(val){
                case -1:
                    //entity trying to move received damage
                    if(entity.getHealth() <= 0){
                        System.out.println("You took a hit!");
                        return -1;
                    }
                case 0:
                    //nothing happens
                    System.out.println("Couldn't move into the occupied grid. Try again next turn.");
                    return 0;
                case 1:
                    //entity in place of where trying to move receives damage
                    if(this.grid[newX][newY].getHealth() <= 0){ //received lethal damage
                        System.out.println(this.grid[newX][newY].getName() +" has received lethal damage and died. Moving to this space.");
                        removeFromGrid(this.grid[newX][newY]);
                        this.grid[entity.getX()][entity.getY()] =  null;
                        entity.setX(newX);
                        entity.setY(newY);
                        return 1;
                    } else{
                        System.out.println("The unit at this spot is still alive. Try again next turn.");
                        return 0;
                    }
            }
        }
        return 0;
    }

    public Entity getEntityAt(int x, int y){
        return this.grid[x][y];
    }

    //returns the entity deleted
    public Entity removeFromGrid(Entity entity){
        if (entity == null){
            return null;
        }
        this.grid[entity.getX()][entity.getY()] = null;
        return entity;
    }

    //prints the whole grid with entities marked by their special character
    @Override
    public String toString(){
        String s = "";
        for(int i = 0; i < this.height; i++){
            for(int j = 0; j < this.width; j++){
                if(getEntityAt(j,i) != null){
                    s = s + " " + getEntityAt(j,i).getUTFChar();
                } else {
                    if(i == 0 || i == this.height - 1){
                        s = s + " |";
                    } else {
                        s = s+ " _";
                    }
                }
                //add new line character if we are at the end of the row
                if(j == this.height - 1){
                    s = s + "\n";
                }
            }
        }
        return s;
    }
    public int fight(Entity e1, Entity e2, int randNum){

        System.out.println("A fight between " + e1.getName() + " and " + e2.getName() + " begins. The dice rolls a " +  randNum + ".");
        //rolls number from 0 to 2, match is determined based on this number
        switch(randNum){
            case 0:
                //0 corresponds to no outcome, both parties
                System.out.println("Both entities stumble to the ground while trying to fight. Nothing happens.");
                return 0;
            case 1:
                //1 corresponds to entity 1 attacking entity 2
                System.out.println(e1.getName() + " attacks " + e2.getName() + ". The damage dealt was " + e1.getStrength() + ".");
                e2.setHealth(e2.getHealth() - e1.getStrength());
                return 1;
            case 2:
                //2 corresponds to entity 2 attacking entity 1
                System.out.println(e2.getName() + " attacks " + e1.getName() + ". The damage dealt was " + e2.getStrength() + ".");
                e1.setHealth(e1.getHealth() - e2.getStrength());
                return -1;
        }
        return 0;
    }
}
