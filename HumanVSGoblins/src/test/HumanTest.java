import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class HumanTest {

    @Test
    void testConstructor1(){
        try{
            Human h1 = new Human("",0,0,0);
            fail();
        } catch(IllegalArgumentException e){
            return;
        }
    }

    @Test
    void testConstructor2(){
        try{
            Human h1 = new Human("test",0,0,1);
        } catch(IllegalArgumentException e){
            fail();
        }
    }
    @Test
    void testConstructor3(){
        try{
            Human h1 = new Human("test",-1,0,1);
            fail();
        } catch(IllegalArgumentException e){
            return;
        }
    }
    @Test
    void testGetters(){
        Human h1 = new Human("test", 14, 3, 3);
        assertEquals('H',h1.getUTFChar());
        assertEquals(14,h1.getX());
        assertEquals(3,h1.getY());
        assertEquals(3,h1.getHealth());
        assertEquals("test",h1.getName());
        assertEquals(1,h1.getStrength());
    }

    @Test
    void testSetters(){
        Human h1 = new Human("test",14,3,3);
        h1.setName("not test");
        assertEquals("not test",h1.getName());
        h1.setX(5);
        assertEquals(5,h1.getX());
        h1.setY(12);
        assertEquals(12,h1.getY());
        h1.setHealth(4);
        assertEquals(4,h1.getHealth());
    }

    @Test
    void interactionTest(){
        Human h1 = new Human("test",0,0,3);
        Entity e1 = new Goblin(1,0);
        assertEquals(1,h1.getStrength());
        Land l1 = new Land(10,10);
        h1.train();
        assertEquals(2,h1.getStrength());
        l1.fight(h1,e1,2); //randnum is two so human will lose fight
        assertEquals(2,h1.getHealth());
    }
}
