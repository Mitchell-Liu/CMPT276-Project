package com.group20;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.*;
import java.util.concurrent.TimeUnit;

public class tickTest {

    

    @Test
    public void testGoesUp(){
        Map map=new Map();
        map.setBorderWalls();
        Position playerPos = new Position(5, 5);
        Diver player = new Diver(playerPos);
        map.setDiver(player);

        Position WallPos = new Position(5, 3);
        map.placeWall(WallPos);

        eventManager event=new eventManager(map, null, null, null);
        Tick tick=new Tick(event);

        event.up=1;


        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }

        Position expected=new Position(5,4);
        Position result=map.getDiverPosition();
       
        assertEquals(expected.getX(),result.getX());
        assertEquals(expected.getY(),result.getY());
        event.up=0;
    }

    @Test
    public void testDontGo(){
        Map map=new Map();
        map.setBorderWalls();
        Position playerPos = new Position(5, 5);
        Diver player = new Diver(playerPos);
        map.setDiver(player);

        Position WallPos = new Position(5, 3);
        map.placeWall(WallPos);

        eventManager event=new eventManager(map, null, null, null);
        Tick tick=new Tick(event);

        event.up=1;
        event.down=1;

        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }

        Position expected=new Position(5,5);
        Position result=map.getDiverPosition();
       
        assertEquals(expected.getX(),result.getX());
        assertEquals(expected.getY(),result.getY());
        event.up=0;
    }
}
