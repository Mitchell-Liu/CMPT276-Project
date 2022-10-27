package com.group20;

//import java.awt.event.KeyEvent;
import java.awt.event.*;


public class keyListener implements KeyListener {

    int up,down,right,left=0;
    
   
    public direction Direction(){
        int add=(up+down+right+left);
        if(add>1 || add==0 ){
            return direction.pause;
        }
        else if(up==1){
            return direction.up;
        }
        else if(down==1){
            return direction.down;
        }
        else if(left==1){
            return direction.left;
        }
        else {
            return direction.right;
        }
        
    }

    @Override
    public void keyTyped(KeyEvent e){
        
    }

    @Override
    public void keyPressed(KeyEvent e){
        
		switch(e.getKeyCode()) {
            case 37: 
                left=1;
                break;
            case 38: 
                down=1;
                break;
            case 39: 
                up=1;
                break;
            case 40:
                right=1;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e){
        switch(e.getKeyCode()) {
            case 37: 
                left=1;
                break;
            case 38: 
                down=1;
                break;
            case 39: 
                up=1;
                break;
            case 40:
                right=1;
                break;
        }
    }
}