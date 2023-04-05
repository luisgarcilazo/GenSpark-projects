import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Humans VS Goblins\n\nHow would you like to name your character?: ");
        Scanner sc = new Scanner(System.in);
        String name = "";
        //get user name
        boolean validName = false;
        while(!validName){
            try {
                name = sc.nextLine();
                if(name.equals("\n") || name.equals("")){
                    sc.nextLine();
                    throw new NoSuchElementException();
                }
                validName = true;
            } catch(Exception e){
                System.out.println("Not a valid input. Please try again.");
                sc.nextLine();
            }
        }
        System.out.println("Welcome " + name + "." + "Please choose your difficult level (easy = e, medium = m, hard = h).");
        String difficultyLevel = "";
        boolean validDifficulty = false;
        //get user difficulty user wants to play
        while(!validDifficulty){
            try{
                difficultyLevel = sc.nextLine();
                if(difficultyLevel.equalsIgnoreCase("e") || difficultyLevel.equalsIgnoreCase("m") || difficultyLevel.equalsIgnoreCase("h")){
                    validDifficulty = true;
                }
            } catch(Exception e){
                System.out.println("Not a valid input. Please try again. Enter e, m or h. ");
            }
        }
        //sets ups values depending on difficulty chosen
        int width= (difficultyLevel.equalsIgnoreCase("e")) ? 5 : (difficultyLevel.equalsIgnoreCase("m")) ? 6 : 7;
        int height = (difficultyLevel.equalsIgnoreCase("e")) ? 5 : (difficultyLevel.equalsIgnoreCase("m")) ? 6 : 7;
        int health = (difficultyLevel.equalsIgnoreCase("e")) ? 8 : (difficultyLevel.equalsIgnoreCase("m")) ? 7 : 6;
        int numberToSpawn = (difficultyLevel.equalsIgnoreCase("e")) ? 5 : (difficultyLevel.equalsIgnoreCase("m")) ? 7 : 10;
        //set up game; land, human and goblin objects
        Land land = new Land(width, height);
        Human player = new Human(name,0,0,health);
        ArrayList<Goblin> goblins = new ArrayList<>();
        System.out.println(name + " will spawn at x: 0, y: 0. Goblin enemies will be generated shortly.");
        land.addToGrid(player);
        Random random = new Random();
        for(int i = 0; i < numberToSpawn; i++){
            int randomX = random.nextInt(width);
            int randomY = random.nextInt(height);
            while(land.getEntityAt(randomX,randomY) != null){ //recalculate x and y until we are at a spot where there isn't a goblin or a human
                randomX = random.nextInt(width);
                randomY = random.nextInt(height);
            }
            Goblin g = new Goblin(randomX,randomY);
            goblins.add(g);
            land.addToGrid(g);
        }


        System.out.println("Goblin enemies generated successfully. Reach and kill all the goblins to win.");
        boolean done = false;
        while(!done){
            System.out.println("Current player status: " + player);
            System.out.println("\nCurrent grid\n\n" + land.toString());
            System.out.println("You can move to adjacent cells, please select a direction. Moving to occupied cells engages combat.");
            System.out.println("Enter a character from the following: n/s/e/w\n");
            String command = "";
            try{
                command = sc.nextLine();
                if(!command.equalsIgnoreCase("n") && !command.equalsIgnoreCase("s") &&
                   !command.equalsIgnoreCase("e") && !command.equalsIgnoreCase("w")) {
                    throw new NoSuchElementException();
                }

            } catch (Exception e){
                System.out.println("Command not recognized. Please try again");
            }
            int commandRv = 0;
            switch(command){

                case "n":
                    System.out.println("Trying to move north.");
                    commandRv = land.move(player,Direction.NORTH);
                    break;
                case "s":
                    System.out.println("Trying to move south.");
                    commandRv = land.move(player,Direction.SOUTH);
                    break;
                case "e":
                    System.out.println("Trying to move east.");
                    commandRv = land.move(player,Direction.EAST);
                    break;
                case "w":
                    System.out.println("Trying to move west.");
                    commandRv = land.move(player,Direction.WEST);
            }
            if(commandRv == -1){
                if (player.getHealth() <= 0){
                    System.out.println("You have died from combat. The goblins are victorious and celebrate a feast as their reign of terror will continue.");
                    done = true;
                } else if(player.getBandageCount() > 0){
                    System.out.println("You have taken damage from combat. Would you like to use a bandage to recover 1 health? (" + player.getBandageCount() + " left) (y/n): " );
                    String bandageChoice = "";
                    try{
                        bandageChoice = sc.nextLine();
                        if(!bandageChoice.equalsIgnoreCase("y") && !bandageChoice.equalsIgnoreCase("n")) {
                            throw new NoSuchElementException();
                        }
                        if(bandageChoice.equalsIgnoreCase("y")){
                            player.useBandage();
                        }
                    } catch (Exception e){
                        System.out.println("Command not recognized. Please try again");
                    }
                }
            }
            if(goblins.size() == 0){ //check if user has killed all goblins, if they have then game is won
                System.out.println("You have killed all the goblins and ended their reign of terror. A nearby village celebrates your feat with a feast.");
                done = true;
            }
        }
    }
}