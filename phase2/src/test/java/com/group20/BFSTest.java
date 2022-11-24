package com.group20;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.*;

import static org.junit.Assert.assertArrayEquals;;

 //This test will test BFS search algorithm
public class BFSTest {
    
    
     

   //Testing the target one block down the starting position
     @Test
     public void testPathTargetOneUp(){
        Map map = new Map();
        Position playerPos = new Position(2, 2);
        Position sharkPos = new Position(2, 3);
        Diver player = new Diver(playerPos);
        Shark shark = new Shark(sharkPos);
        map.setDiver(player);
        map.setSharks(shark);

        BFS bfs = new BFS(map);

        direction[] result = bfs.Search();
        direction[] expected = {direction.up};
        assertArrayEquals(expected, result);
     }

      //Testing the target one block above the starting position
     @Test
     public void testPathTargetOneDown(){ 
        Map map = new Map();
        Position playerPos = new Position(2, 2);
        Position sharkPos = new Position(2,1);
        
        Diver player = new Diver(playerPos);
        Shark shark = new Shark(sharkPos);
        map.setDiver(player);
        map.setSharks(shark);

        BFS bfs=new BFS(map);

        direction[] result=bfs.Search();
        direction[] expected={direction.down};
        assertArrayEquals(expected, result);
     }

      //Testing the target one block right the starting position
     @Test
     public void testPathTargetOneLeft(){
        Map map = new Map();
        Position playerPos = new Position(2, 2);
        Position sharkPos = new Position(3, 2);
        
        Diver player = new Diver(playerPos);
        Shark shark = new Shark(sharkPos);
        map.setDiver(player);
        map.setSharks(shark);

        BFS bfs=new BFS(map);

        direction[] result=bfs.Search();
        direction[] expected={direction.left};
        assertArrayEquals(expected, result);
     }

      //Testing the target one block left the starting position
     @Test
     public void testPathTargetOneRight(){
        Map map = new Map();
        Position playerPos = new Position(1, 1);
        Position sharkPos = new Position(0, 1);
        Diver player = new Diver(playerPos);
        Shark shark = new Shark(sharkPos);
        map.setDiver(player);
        map.setSharks(shark);

        BFS bfs=new BFS(map);

        direction[] result=bfs.Search();
        direction[] expected={direction.right};
        assertArrayEquals(expected, result);
     }

      //Testing the target multiple blocks down the starting position
     @Test
     public void testPathTargetMultiUp(){
         Map map = new Map();
        map.setBorderWalls();
        Position playerPos = new Position(3, 3);
        Position sharkPos = new Position(3, 6);
        
        Diver player = new Diver(playerPos);
        Shark shark = new Shark(sharkPos);
        map.setDiver(player);
        map.setSharks(shark);

        BFS bfs=new BFS(map);

        direction[] result=bfs.Search();
        direction[] expected={direction.up,direction.up,direction.up};
        assertArrayEquals(expected, result);
     }

      //Testing the target multiple blocks above the starting position
     @Test
     public void testPathTargetMultiDown(){
         Map map = new Map();
         map.setBorderWalls();
        Position playerPos = new Position(4, 4);
        Diver player = new Diver(playerPos);
        Position sharkPos = new Position(4, 1);
        Shark shark = new Shark(sharkPos);
        map.setDiver(player);
        map.setSharks(shark);
        BFS bfs=new BFS(map);

        direction[] result=bfs.Search();
        direction[] expected={direction.down,direction.down,direction.down};
        assertArrayEquals(expected, result);
     }

      //Testing the target multiple blocks left the starting position
     @Test
     public void testPathTargetMultiRight(){
        
        Map map = new Map();
        map.setBorderWalls();
        Position playerPos = new Position(4, 4);
        Diver player = new Diver(playerPos);
        Position sharkPos = new Position(1, 4);
        Shark shark = new Shark(sharkPos);
        map.setDiver(player);
        map.setSharks(shark);
        BFS bfs=new BFS(map);

        direction[] result=bfs.Search();
        direction[] expected={direction.right,direction.right,direction.right};
        assertArrayEquals(expected, result);
     }

     //Testing the target multiple block right the starting position
     @Test
     public void testPathTargetMultiLeft(){
        Map map = new Map();
        map.setBorderWalls();
        Position playerPos = new Position(4, 4);
        Diver player = new Diver(playerPos);
        Position sharkPos = new Position(7, 4);
        Shark shark = new Shark(sharkPos);
        map.setDiver(player);
        map.setSharks(shark);
        BFS bfs=new BFS(map);

        direction[] result=bfs.Search();
        direction[] expected={direction.left,direction.left,direction.left};
        assertArrayEquals(expected, result);
     }
     

}
