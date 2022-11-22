package com.group20;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.*;

public class MapTest {

    Map map;
    
    //Create initial map for testing
    @Before
    public void makeMap(){
        map = new Map();
        Position playerPos = new Position(10, 10);
        Diver player = new Diver(playerPos);
        Position exitPos = new Position(19, 19);
        Exit exit = new Exit(exitPos);
        map.setDiver(player);
        map.setExit(exit);
    }

    //Testing position validation function using edge/boundary cases
    @Test
    public void testValidPositions(){
        Position pos1 = new Position(0, 0);
        Position pos2 = new Position(19, 19);
        Position pos3 = new Position(0, 19);
        Position pos4 = new Position(19, 0);
        Position pos5 = new Position(10, 10);
        Position pos6 = new Position(20, 0);
        Position pos7 = new Position(0, 20);
        Position pos8 = new Position(20, 20);
        Position pos9 = new Position(-1, 0);
        Position pos10 = new Position(0, -1);
        Position pos11 = new Position(-1, -1);
        assertTrue(map.positionisValid(pos1));
        assertTrue(map.positionisValid(pos2));
        assertTrue(map.positionisValid(pos3));
        assertTrue(map.positionisValid(pos4));
        assertTrue(map.positionisValid(pos5));
        assertFalse(map.positionisValid(pos6));
        assertFalse(map.positionisValid(pos7));
        assertFalse(map.positionisValid(pos8));
        assertFalse(map.positionisValid(pos9));
        assertFalse(map.positionisValid(pos10));
        assertFalse(map.positionisValid(pos11));
    }

    //Tests that proper names are retrieved by getEntityNameAt function
    @Test
    public void testEntityNames(){
        Position pos1 = new Position(0, 0);
        Position pos2 = new Position(1, 0);
        Position pos3 = new Position(2, 0);
        Position pos4 = new Position(3, 0);
        Position pos5 = new Position(4, 0);
        map.placeCoin(pos1);
        map.placeSeaweed(pos2);
        map.placeTreasureChest(pos3);
        map.placeWall(pos4);
        map.setSharks(new Shark(pos5));
        map.openExit();
        assertEquals(map.getEntityNameAt(pos1), "Coin");
        assertEquals(map.getEntityNameAt(pos2), "Seaweed");
        assertEquals(map.getEntityNameAt(pos3), "TreasureChest");
        assertEquals(map.getEntityNameAt(pos4), "Wall");
        assertEquals(map.getEntityNameAt(pos5), "Shark");
        assertEquals(map.getEntityNameAt(map.getDiverPosition()), "Diver");
        assertEquals(map.getEntityNameAt(new Position(19, 19)), "Exit");
    }
    
    //Tests behaviour of map when diver moves into walls from all 4 directions
    //Expect diver position to not change if move into wall is attempted
    @Test
    public void diverMovesIntoWalls(){
        Position expected = new Position(10, 10);
        map.placeWall(new Position(9, 10));
        map.placeWall(new Position(11, 10));
        map.placeWall(new Position(10, 9));
        map.placeWall(new Position(10, 11));
        map.moveDiverUp();
        assertTrue(map.getDiverPosition().equals(expected));
        map.moveDiverDown();
        assertTrue(map.getDiverPosition().equals(expected));
        map.moveDiverRight();
        assertTrue(map.getDiverPosition().equals(expected));
        map.moveDiverLeft();
        assertTrue(map.getDiverPosition().equals(expected));
    }

    //Tests behaviour when diver moves into an empty space from any direction
    //Expect diver position to be updated on each move
    @Test
    public void diverMovesIntoEmptySpace(){
        Position expected = new Position(10, 10);
        map.moveDiverUp();
        expected.setY(9);
        assertTrue(map.getDiverPosition().equals(expected));
        map.moveDiverDown();
        expected.setY(10);
        assertTrue(map.getDiverPosition().equals(expected));
        map.moveDiverRight();
        expected.setX(11);
        assertTrue(map.getDiverPosition().equals(expected));
        expected.setX(10);
        map.moveDiverLeft();
        assertTrue(map.getDiverPosition().equals(expected));
    }

    //Checks that game end conditions are set when diver moves into shark
    @Test
    public void diverMovesIntoShark(){
        Shark shark1 = new Shark(new Position(10, 9));
        map.setEntityAt( shark1, shark1.getPosition());
        map.moveDiverUp();
        assertTrue(map.isGameLose()&&map.isGameOver());
    }

    //Tests proper behaviour of map attributes tied to coins
    //Checks game end and player score attributes
    @Test
    public void diverCollectsCoins(){
        Position position1 = new Position(11, 10);
        Position position2 = new Position(12, 10);
        map.placeCoin(position1);
        map.placeCoin(position2);
        map.setCoinsRemaining(2);
        map.moveDiverRight();
        assertEquals(map.getCoinsRemaining(), 1);
        assertEquals(map.getPlayerScore(), 5);
        assertFalse(map.allCoinsCollected());
        assertEquals(map.getEntityAt(position1), map.getDiver());
        map.moveDiverRight();
        assertEquals(map.getCoinsRemaining(), 0);
        assertEquals(map.getPlayerScore(), 10);
        assertTrue(map.allCoinsCollected());
        assertEquals(map.getEntityAt(position1), null);
        assertEquals(map.getEntityAt(position2), map.getDiver());
    }

    //Ensures player score and game end attributes are affected properly when seaweed is collected
    //Also ensures map is updated properly
    @Test
    public void diverCollectsSeaWeed(){
        Position position1 = new Position(11, 10);
        Position position2 = new Position(12, 10);
        Position position3 = new Position(13, 10);
        map.placeSeaweed(position1);
        map.placeSeaweed(position2);
        map.placeSeaweed(position3);
        map.setPlayerScore(20);
        //move into 1st seaweed, score>0
        map.moveDiverRight();
        assertEquals(map.getPlayerScore(), 10);
        assertFalse(map.isGameLose()||map.isGameOver());
        assertEquals(map.getEntityAt(position1), map.getDiver());
        //move into 2nd seaweed, score = 0
        map.moveDiverRight();
        assertEquals(map.getPlayerScore(), 0);
        assertFalse(map.isGameLose()||map.isGameOver());
        assertEquals(map.getEntityAt(position1), null);
        assertEquals(map.getEntityAt(position2), map.getDiver());
        //move into 3rd seaweed, score<0, game ends
        map.moveDiverRight();
        assertEquals(map.getPlayerScore(), -10);
        assertTrue(map.isGameLose()&&map.isGameOver());
        assertEquals(map.getEntityAt(position2), null);
        assertEquals(map.getEntityAt(position3), map.getDiver());
    }

    //Ensures player score and map are updated accordingly when treasure chest is collected
    @Test
    public void diverCollectsTreasureChest(){
        Position position1 = new Position(11, 10);
        map.placeTreasureChest(position1);
        map.setPlayerScore(0);
        map.moveDiverRight();
        assertEquals(map.getPlayerScore(), 20);
        assertEquals(map.getEntityAt(position1), map.getDiver());
    }

    //Same as diver into shark test but this time shark initiates movement
    @Test
    public void sharkMovesIntoDiver(){
        Shark shark1 = new Shark(new Position(10, 9));
        map.setSharks(shark1);
        map.moveSharkDown();
        assertTrue(map.isGameLose()&&map.isGameOver());
    }

    // Checks if the diver wins when they reach the exit
    @Test
    public void diverExits(){
        Position playerPos = new Position(18, 19);
        map.setDiverPosition(playerPos);
        map.openExit();
        map.moveDiverRight();
        assertTrue(map.isGameWin() && map.isGameOver());
        assertEquals(map.getEntityAt(playerPos), null);
    }

}
