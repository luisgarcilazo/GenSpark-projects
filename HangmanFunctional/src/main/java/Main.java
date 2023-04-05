import java.util.*;

public class Main {

    public final static String[] words =  { "cat",
                                            "dog",
                                            "panda",
                                            "fish",
                                            "bat",
                                            "ant",
                                            "goat",
                                            "bird",
                                            "lamb",
                                            "bug",
                                          };

    public static void main(String[] args){
        //get random word
        boolean playAgain = true;
        while(playAgain){
            Random rand = new Random();
            int randNum =  rand.nextInt(words.length); //gets an integer from 0 to 9 (string array index)
            String randWord = words[randNum];
            ArrayList<Character> missedLetters = new ArrayList<Character>();
            HashMap<Character, Boolean> hits = new HashMap<>();

            for(char c: randWord.toCharArray()){
                hits.put(c,false);
            }
            System.out.print("H A N G M A N\n");
            boolean done = false;
            Scanner sc = new Scanner(System.in);
            while (!done){
                System.out.println(generateScreen(randWord,missedLetters, hits));

                //check also if all in hashmap are true, if they are game over and don't take a guess
                for(boolean b: hits.values()){
                    if(b){
                        //loop shortcircuits if one before is false so can't become true at last character unless other are true
                        done = true; //update true
                    } else {
                        done = false;
                        break;  //instantly break from loop as
                    }
                }
                //if done becomes true here then it means it was true for all so we are done
                if (done){
                    System.out.print("\nYes! The secret word is " + randWord + "! You have won!");
                    continue; //jump to start so loop breaks
                }
                if(missedLetters.size() > 6) {
                    System.out.print("\nYou have no more guesses remaining. You lost.");
                    System.out.print("\nThe word was: " + randWord);
                    done = true;
                    continue; //jump to start so loop breaks
                }
                //guessing
                boolean reguess = true;
                while(reguess){
                    System.out.print("\n\nGuess a letter.");
                    char c = ' ';
                    try{
                        String input = sc.nextLine();
                        if(input.length() > 1){ throw new NoSuchElementException();} //throw an exception if user inputs more than 2 chars
                        c = input.charAt(0);
                        if(randWord.contains("" + c) && !hits.get(c)){ //if it is in the string and the word has not been hit
                            hits.put(c,true); //update to true
                            reguess = false;
                        } else if((randWord.contains("" + c) && hits.get(c)) || missedLetters.contains(c)) { //has already been guessed before, don't punish user
                            System.out.print("\n\nYou have already guessed that letter. Choose again.");
                        } else {
                            missedLetters.add(c); //add missed letter to list of missed letters
                            reguess = false;
                        }

                    } catch (Exception e) {
                        System.out.print("\nPlease try again. Incorrect input.");
                        continue; //resets the loop
                    }
                }
            }
            //out of loop, check if user still wants to play
            System.out.print("\nDo you want to play again? (yes or no)\n\n\n");
            try {
                String input = sc.nextLine();
                if(input.equalsIgnoreCase("yes")){
                    playAgain = true;
                    continue;
                } else {;
                    playAgain = false;
                }
            } catch(Exception e){
                System.out.print("\nI could not recognize your input, the program will finish. Thanks for playing.");
            }
        }

    }
    public static String generateScreen(String randWord,ArrayList<Character> missedLetters, HashMap<Character, Boolean> hits){
        String retVal = "";
        //setting up the image depending on how many missing letters the used has gotten
        retVal = retVal + "+---+\n\n";

        if(missedLetters.size() > 5){ retVal = retVal + "x";
        } else if (missedLetters.size() > 0){ retVal = retVal + "o"; //print an x when the user dies
        } else { retVal = retVal + " ";}
        retVal = retVal + "   |\n";

        if(missedLetters.size() > 4){ retVal = retVal + "x";
        } else if (missedLetters.size() > 1){ retVal = retVal + "|";
        } else { retVal = retVal + " ";}
        retVal = retVal + "   |\n";

        if(missedLetters.size() > 3){ retVal = retVal + "x";
        } else if (missedLetters.size() > 2){  retVal = retVal + "|";
        } else { retVal = retVal + " ";}
        retVal = retVal + "   |\n";

        retVal = retVal + "\nMissed letters: ";
        for(char c: missedLetters){ retVal = retVal + c;}

        //finished up setting the image
        retVal = retVal + "\n"; //moving to new line
        
        //char display
        for(char c: randWord.toCharArray()){
            if(hits.get(c)){ //we get true back from hashmap if it has been reassigned when guessed
                retVal = retVal + c + " ";
            } else {
                retVal = retVal + "_ ";
            }
        }
        return retVal;
    }
}
