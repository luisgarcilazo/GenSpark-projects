import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int done = 0;
        while (done == 0){
            System.out.println("""
                           Hello! What is your name?
                           """);
            Scanner sc = new Scanner(System.in);
            String name = "";
            try{
                name = sc.nextLine();
            } catch(NoSuchElementException nse){
                System.out.println("Input not detected. Please try again. \n");
                continue;
            }
            System.out.println("\n\nWell," + name + " I am thinking of a number between 1 and 20.\nTake a guess.");
            int[] flags = new int[2];
            //array to hold the flags for the guessing name, stored as array for easier testing and passing as reference
            //flags[0] is count (how many tries user has used)
            //flags[1] is if the answer is correct or not
            int count = 0;
            int guess = 1;
            int correct = 0;
            Random rand = new Random();
            int correctNum =  rand.nextInt(21) + 1;
            while (flags[0] != 6){
                try {
                    guess = sc.nextInt();
                    flags = guessNumber(1,20,guess,correctNum,flags,name);
                    //break if correct == true
                    if (flags[1] == 1){
                        break;
                    }
                } catch(InputMismatchException ime){
                    System.out.println("Incorrect input. Please enter an integer between 1 through 20.\n");
                    sc.nextLine();
                }
            }
            if(flags[1] == 0){
                System.out.println("Sorry, " + name +", you ran out of tries.");
            }
            System.out.println("Would you like to play again? (y or n)");
            String choice = "";
            try{
                choice = sc.next();
                if (choice.equalsIgnoreCase("y")){
                    continue;
                } else {
                    System.out.println("Thanks for playing!");
                    done = 1;
                }
            } catch(NoSuchElementException nse){
                System.out.println("Input not detected. Thanks for playing. \n");
                continue;
            }

        }
    }
    //outputs depending on what the user has guessed and the correct num, high and low depend upon limits passed
    //flag array is returned, which contains two ints for knowing whether the user got the correct guess and # of tries
    public static int[] guessNumber(int lowerLimit, int upperLimit,int guess, int correctNum, int[] flags, String name){
        if(guess > upperLimit || guess < lowerLimit){
            System.out.println("Number is out of range. Please try again.");
            flags[1] = 0; //set correct flag to false
        } else {
            flags[0]++;
            if (guess > correctNum){
                System.out.println("Your guess is too high");
                flags[1] = 0; //set correct flag to false
            } else if(guess < correctNum){
                System.out.println("Your guess is too low.");
                flags[1] = 0; //set correct flag to false
            } else {
                flags[1] = 1;
                if (flags[0] == 2){
                    System.out.println("Good job, " + name + "! You guessed my number in 1 guess");
                } else {
                    System.out.println("Good job, " + name + "! You guessed my number in " + flags[0] + " guesses!");
                }
            }
        }
        return flags;
    }
}