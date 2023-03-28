import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HangmanTest {
    @Test
    void generateScreenTest1(){
        String randWord = "cat";
        ArrayList<Character> missedLetters = new ArrayList<>();
        missedLetters.add('d');
        missedLetters.add('g');
        HashMap<Character, Boolean> hits = new HashMap<>();
        for(char c: randWord.toCharArray()){
            hits.put(c,false);
        }
        hits.put('c', true);
        assertEquals("+---+\n" +
                             "\n" +
                             "o   |\n" +
                             "|   |\n" +
                             "    |\n" +
                             "\n" +
                             "Missed letters: dg\n" +
                             "c _ _ ",Main.generateScreen(randWord,missedLetters,hits));
    }
    @Test
    void generateScreenTest2(){
        String randWord = "goat";
        ArrayList<Character> missedLetters = new ArrayList<>();
        missedLetters.add('e');
        missedLetters.add('j');
        missedLetters.add('p');
        HashMap<Character, Boolean> hits = new HashMap<>();
        for(char c: randWord.toCharArray()){
            hits.put(c,false);
        }
        hits.put('g', true);
        hits.put('t', true);
        assertEquals("+---+\n" +
                "\n" +
                "o   |\n" +
                "|   |\n" +
                "|   |\n" +
                "\n" +
                "Missed letters: ejp\n" +
                "g _ _ t ",Main.generateScreen(randWord,missedLetters,hits));
    }
    @Test
    void generateScreenTest3(){
        String randWord = "fish";
        ArrayList<Character> missedLetters = new ArrayList<>();
        missedLetters.add('e');
        missedLetters.add('j');
        missedLetters.add('p');
        missedLetters.add('m');
        HashMap<Character, Boolean> hits = new HashMap<>();
        for(char c: randWord.toCharArray()){
            hits.put(c,false);
        }
        hits.put('f', true);
        hits.put('i', true);
        hits.put('h', true);
        assertEquals("+---+\n" +
                "\n" +
                "o   |\n" +
                "|   |\n" +
                "x   |\n" +
                "\n" +
                "Missed letters: ejpm\n" +
                "f i _ h ",Main.generateScreen(randWord,missedLetters,hits));
    }
}
