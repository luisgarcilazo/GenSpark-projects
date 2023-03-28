import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LandTests {

    @Test
    void addAndMoveTest1(){
        Entity e1 = new Human("test",0,0,3);
        Entity e2 = new Goblin(1,0);
        Land l1 = new Land(10,10);
        assertEquals(0,l1.addToGrid(e1));
        assertEquals(0, l1.addToGrid(e2));
        assertEquals(-1, l1.addToGrid(e1)); //fails as it has already been added
        assertEquals(-1, l1.addToGrid(e2)); //fails as it has already been added
        //nothing should happen as both are weak
        assertEquals(0, l1.move(e1,Direction.EAST)); //move shouldn't be succesful
        assertEquals(1, l1.move(e1,Direction.NORTH)); //move should be succesful as it isn't occupied
        assertEquals(1, l1.move(e1,Direction.EAST)); ///move should be succesful as it isn't occupied
        assertEquals(0, l1.move(e1,Direction.SOUTH)); //move shouldn't be succesful
    }
    @Test
    void addAndMoveTest2(){
        //check lower bounds of grid
        Entity e1 = new Human("test",0,0,3);
        Land l1 = new Land(10,10);
        //nothing should happen as both are weak
        assertEquals(-1, l1.move(e1,Direction.SOUTH)); //move shouldn't be succesful, out of bounds
        assertEquals(-1, l1.move(e1,Direction.WEST)); //move shouldm't be succesful, out of bounds
        assertEquals(1, l1.move(e1,Direction.NORTH)); ///move should be succesful as it isn't occupied
        assertEquals(1, l1.move(e1,Direction.EAST)); //move should be succesful,as it isnt't occupied
    }
    @Test
    void addAndMoveTest3(){
        //check upper bounds of grid
        Entity e1 = new Human("test",9,9,3);
        Land l1 = new Land(10,10);
        //nothing should happen as both are weak
        assertEquals(-1, l1.move(e1,Direction.NORTH)); //move shouldn't be succesful, out of bounds
        assertEquals(-1, l1.move(e1,Direction.EAST)); //move shouldm't be succesful, out of bounds
        assertEquals(1, l1.move(e1,Direction.SOUTH)); ///move should be succesful as it isn't occupied
        assertEquals(1, l1.move(e1,Direction.WEST)); //move should be succesful,as it isn't occupied
    }

    @Test
    void fightTest1(){
        Entity e1 = new Human("test",9,9,3);
        Entity e2 = new Goblin(0,0);
        Land l1 = new Land(10,10);
        ((Human) e1).train(); //train twice so it kills instantly
        ((Human) e1).train();
        assertEquals(0,l1.fight(e1,e2,0)); //nothing will happen as it is given a 0
        //check if healths of entity1/entity2 are zero as they didn't attack each other
        assertEquals(3,e2.getHealth());
        assertEquals(3,e2.getHealth());
    }
    @Test
    void fightTest2(){
        Entity e1 = new Human("test",9,9,3);
        Entity e2 = new Goblin(0,0);
        Land l1 = new Land(10,10);
        ((Human) e1).train(); //train twice so it kills instantly
        ((Human) e1).train();
        assertEquals(1,l1.fight(e1,e2,1)); //returns a 1 since entity 1 will attack entity 2
        assertEquals(0,e2.getHealth()); //check if health of entity 2 is zero as it was attacked with a power of 3
    }
    @Test
    void fightTest3(){
        Entity e1 = new Human("test",9,9,3);
        Entity e2 = new Goblin(0,0);
        Land l1 = new Land(10,10);
        ((Human) e1).train(); //train twice so it kills instantly
        ((Human) e1).train();
        assertEquals(-1,l1.fight(e1,e2,2)); //returns a 1 since entity 1 will attack entity 2
        assertEquals(2,e1.getHealth()); //check if health of entity 1 is 2  as it was attacked with a power of 3
    }
    @Test
    void getEntityTest(){
        Entity e1 = new Human("test", 0, 4, 10);
        Land l1 = new Land(10,10);
        ((Human) e1).train();
        l1.addToGrid(e1);
        assertNotEquals(null,l1.getEntityAt(0,4));
        assertEquals(e1.getStrength(),l1.getEntityAt(0,4).getStrength());
        l1.move(e1,Direction.NORTH);
        assertEquals("test",l1.getEntityAt(0,5).getName());
    }
    @Test
    void toStringTest(){
        Entity e1 = new Human("test", 0, 4, 10);
        Entity e2 = new Goblin(0,0);
        Entity e3 = new Goblin(5,6);
        Entity e4 = new Goblin(7,8);
        Land l1 = new Land(10,10);
        l1.addToGrid(e1);
        l1.addToGrid(e2);
        l1.addToGrid(e3);
        l1.addToGrid(e4);
        assertEquals(" G _ _ _ H _ _ _ _ |\n" +
                             " | _ _ _ _ _ _ _ _ |\n" +
                             " | _ _ _ _ _ _ _ _ |\n" +
                             " | _ _ _ _ _ _ _ _ |\n" +
                             " | _ _ _ _ _ _ _ _ |\n" +
                             " | _ _ _ _ _ G _ _ |\n" +
                             " | _ _ _ _ _ _ _ _ |\n" +
                             " | _ _ _ _ _ _ _ G |\n" +
                             " | _ _ _ _ _ _ _ _ |\n" +
                             " | _ _ _ _ _ _ _ _ |\n", l1.toString());
    }

}
