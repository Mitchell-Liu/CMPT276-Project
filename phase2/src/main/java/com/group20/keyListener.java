package com.group20;

//import java.awt.event.KeyEvent;
import java.awt.event.*;


public class keyListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e){
        
    }

    @Override
    public void keyPressed(KeyEvent e){
        //keyPressed = Invoked when a physical key is pressed down. Uses KeyCode, int output
		switch(e.getKeyCode()) {
            case 37: 
                break;
            case 38: 
                break;
            case 39: 
                break;
            case 40:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e){
        
    }
}