import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("""
                           You are in a land full of dragons. In front of you,
                           you see two caves. In one cave, the dragon is friendly
                           and wil share his treasure with you. The other dragon
                           is greedy and hungry and will eat you on sight.
                           Which cave will you go into? (1 or 2) 
                           """);
        int userChoice = 0;
        Scanner sc = new Scanner(System.in);
        while (userChoice == 0){
            try {
                userChoice = sc.nextInt();
                if(userChoice == 1){
                    System.out.println("""
                                      
                                      
                                      You approach the cave...
                                      It is dark and spooky
                                      A large dragon jumps out in front of you! He opens his jaws and...
                                      Gobbles you down in one bite!
                                      
                                      """);
                } else if (userChoice == 2){
                    System.out.println("""
                                      
                                      
                                      You approach the cave...
                                      It is adorned with many human toys and is illumined by natural light
                                      A small dragon jumps out in front of you! He opens his jaws and...
                                      Gives you the biggest and happiest smile a dragon could make!
                                      """);
                } else {
                    System.out.println("Incorrect number. Please enter either '1' or '2'");
                }
            } catch (Exception e){
                System.out.println("Incorrect input. Please enter either '1' or '2'.");
                sc.nextLine(); //goes to next line to reset scanner, will become stuck otherwise
                userChoice = 0;
                continue;
            }
        }
    }
}