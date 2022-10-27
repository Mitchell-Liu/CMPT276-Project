package com.group20;

//import java.awt.event.KeyEvent;
import java.awt.event.*;


public class keyListener implements KeyListener {

   private eventManager event;

   public keyListener(eventManager event){
    this.event=event;
   }
    @Override
    public void keyTyped(KeyEvent e){
        
    }

    @Override
    public void keyPressed(KeyEvent e){
        
		switch(e.getKeyCode()) {
            case 37: 
            System.out.print("up");
                event.left=1;
                break;
            case 38: 
                event.down=1;
                break;
            case 39: 
                event.up=1;
                break;
            case 40:
                event.right=1;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e){
        switch(e.getKeyCode()) {
            case 37: 
                event.left=0;
                break;
            case 38: 
                event.down=0;
                break;
            case 39: 
                event.up=0;
                break;
            case 40:
                event.right=0;
                break;
        }
    }
}