import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class GoblinTest {

    @Test
    void testConstructor1(){
        try{
            Goblin h1 = new Goblin(-1,-1);
            fail();
        } catch(IllegalArgumentException e){
            return;
        }
    }

    @Test
    void testConstructor2(){
        try{
            Goblin h1 = new Goblin(1,0);
        } catch(IllegalArgumentException e){
            fail();
        }
    }
    @Test
    void testConstructor3(){
        try{
            Goblin h1 = new Goblin(-1,0);
            fail();
        } catch(IllegalArgumentException e){
            return;
        }
    }
    @Test
    void testGetters(){
        Goblin g1 = new Goblin(3,6);
        assertEquals('G',g1.getUTFChar());
        assertEquals(3,g1.getX());
        assertEquals(6,g1.getY());
        assertEquals(3,g1.getHealth());
        assertEquals("Unknown Goblin",g1.getName());
        assertEquals(1,g1.getStrength());
    }

    @Test
    void testSetters() {
        Goblin g1 = new Goblin(0,0);
        g1.setX(15);
        assertEquals(15,g1.getX());
        g1.setY(5);
        assertEquals(5,g1.getY());
        g1.setName("special goblin");
        assertEquals("special goblin",g1.getName());
    }
    @Test
    void interactionTest(){
        Human h1 = new Human("test",0,0,3);
        Goblin g1 = new Goblin(1,0);
        assertEquals(1,h1.getStrength());
        Land l1 = new Land(10,10);
        h1.train();
        assertEquals(2,h1.getStrength()); //strength is now 2
        l1.fight(h1,g1,1); //randNum is one so goblin will lose fight
        assertEquals(1,g1.getHealth());
    }
}
