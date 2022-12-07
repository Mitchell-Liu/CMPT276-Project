package com.group20;


import static org.junit.Assert.assertEquals;

import org.junit.*;

public class keyInputTest {
    eventManager event;
    
    @Before
    public void makeEventManager(){
         
        
        Map map=new Map();
        
        event=new eventManager(map, null,  null);
    }

    //Test when player only press one arrow key
    //expect the direction is the correspond direction
    @Test
    public void TestSingleKeyPress(){
       
        event.up=1;
        assertEquals(direction.up,event.Direction());
        event.up=0;
        event.down=1;
        assertEquals(direction.down,event.Direction());
        event.down=0;
        event.right=1;
        assertEquals(direction.right,event.Direction());
        event.right=0;
        event.left=1;
        assertEquals(direction.left,event.Direction());
        event.left=0;
    }

    //Test when player only press multiple arrow key at once
    //expect the direction is pause
    @Test
    public void TestMultipleKeyPress(){
       
        event.up=1;
        event.down=1;
        assertEquals(direction.pause,event.Direction());
        event.up=0;
        event.down=0;
    }

}
