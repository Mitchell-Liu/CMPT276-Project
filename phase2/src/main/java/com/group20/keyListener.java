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
                eventManager.left=1;
                break;
            case 38: 
                eventManager.down=1;
                break;
            case 39: 
                eventManager.up=1;
                break;
            case 40:
                eventManager.right=1;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e){
        switch(e.getKeyCode()) {
            case 37: 
            System.out.print("up");
                eventManager.left=0;
                break;
            case 38: 
                eventManager.down=0;
                break;
            case 39: 
                eventManager.up=0;
                break;
            case 40:
                eventManager.right=0;
                break;
        }
    }
}