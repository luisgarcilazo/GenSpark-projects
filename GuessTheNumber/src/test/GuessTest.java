import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuessTest {

    @Test
    void guessLow(){
        int[] flags = new int[2];
        flags[0] = 0;
        flags[1] = 0;
        flags = Main.guessNumber(1,20,5,7,flags,"luis");
        assertEquals(1,flags[0]); //1 correct try so count should be increased
        assertEquals(0, flags[1]); //not correct answer so it still is 0
    }
    @Test
    void guessHigh(){
        int[] flags = new int[2];
        flags[0] = 0;
        flags[1] = 0;
        flags = Main.guessNumber(1,20,15,7,flags,"luis");
        assertEquals(1,flags[0]); //1 correct try so count should be increased
        assertEquals(0, flags[1]); //not correct answer so it still is 0
    }
    @Test
    void guessOutOfBounds(){
        int[] flags = new int[2];
        flags[0] = 3; //count set to 3
        flags[1] = 0;
        flags = Main.guessNumber(1,20,21,15,flags,"luis");
        assertEquals(3,flags[0]); //incorrect try so count should be the same
        assertEquals(0, flags[1]); //not correct answer so it still is 0
    }
    @Test
    void correctGuess(){
        int[] flags = new int[2];
        flags[0] = 5; //count set to 3
        flags[1] = 0;
        flags = Main.guessNumber(1,20,4,4,flags,"luis");
        assertEquals(6,flags[0]); //incorrect try so count should be the same
        assertEquals(1, flags[1]); //not correct answer so it still is 0
    }
}
