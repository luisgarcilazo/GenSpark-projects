import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.io.*;

class MainTest {
    private final ByteArrayOutputStream outcontent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp(){
        System.setOut(new PrintStream(outcontent));
    }
    @Test
    void mainChoice1() throws UnsupportedEncodingException {
        //inspired by https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
        PrintStream out = System.out;
        String data = "1";
        InputStream testInput = new ByteArrayInputStream(data.getBytes("UTF-8"));
        System.setIn(testInput);
        System.setOut(new PrintStream(outcontent));
        Main.main(new String[]{""});
        String result =   """
                           You are in a land full of dragons. In front of you,
                           you see two caves. In one cave, the dragon is friendly
                           and wil share his treasure with you. The other dragon
                           is greedy and hungry and will eat you on sight.
                           Which cave will you go into? (1 or 2)\r
                           """;

        String result2 =   """
                           
                           
                           
                           You approach the cave...
                           It is dark and spooky
                           A large dragon jumps out in front of you! He opens his jaws and...
                           Gobbles you down in one bite!
                           """;
        //remove whitespaces from strings as they got buggy with the triple strings
        assertEquals(result.replaceAll("\\n","").replaceAll("\\r","") + result2.replaceAll("\\n","").replaceAll("\\r",""), outcontent.toString().replaceAll("\\n","").replaceAll("\\r",""));
    }
    @Test
    void mainChoice2() throws UnsupportedEncodingException {
        //inspired by https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
        PrintStream out = System.out;
        String data = "2";
        InputStream testInput = new ByteArrayInputStream(data.getBytes("UTF-8"));
        System.setIn(testInput);
        System.setOut(new PrintStream(outcontent));
        Main.main(new String[]{""});
        String result =   """
                           You are in a land full of dragons. In front of you,
                           you see two caves. In one cave, the dragon is friendly
                           and wil share his treasure with you. The other dragon
                           is greedy and hungry and will eat you on sight.
                           Which cave will you go into? (1 or 2)\r
                           """;

        String result2 =   """
                           
                           
                           
                           You approach the cave...
                           It is adorned with many human toys and is illumined by natural light
                           A small dragon jumps out in front of you! He opens his jaws and...
                           Gives you the biggest and happiest smile a dragon could make!
                           """;
        //remove whitespaces from strings as they got with triple strings
        assertEquals(result.replaceAll("\\n","").replaceAll("\\r","") + result2.replaceAll("\\n","").replaceAll("\\r",""), outcontent.toString().replaceAll("\\n","").replaceAll("\\r",""));
    }
    @Test
    void mainChoice3() throws UnsupportedEncodingException {
        //inspired by https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
        PrintStream out = System.out;
        String data = "3";
        InputStream testInput = new ByteArrayInputStream(data.getBytes("UTF-8"));
        System.setIn(testInput);
        System.setOut(new PrintStream(outcontent));
        Main.main(new String[]{""});
        String result =   """
                           You are in a land full of dragons. In front of you,
                           you see two caves. In one cave, the dragon is friendly
                           and wil share his treasure with you. The other dragon
                           is greedy and hungry and will eat you on sight.
                           Which cave will you go into? (1 or 2)\r
                           """;

        String result2 =   """
                           
                           Incorrect number. Please enter either '1' or '2'
                           """;
        //remove whitespaces from strings as they got with triple strings
        assertEquals(result.replaceAll("\\n","").replaceAll("\\r","") + result2.replaceAll("\\n","").replaceAll("\\r",""), outcontent.toString().replaceAll("\\n","").replaceAll("\\r",""));
    }
    @AfterEach
    public void restore(){
        System.setOut(originalOut);
    }
}