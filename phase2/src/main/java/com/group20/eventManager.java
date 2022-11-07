package com.group20;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * event manager: it will listen to the keyboard input, and manage the tick of the game
 */
public class eventManager implements KeyListener{

     int up,down,right,left;
     JTextArea ta;
     Board board;
     Map map;
     Diver diver;
     JFrame frame;
     tickShark ts=new tickShark(this);

    //private eventManager event=new eventManager();    
    public eventManager(Map gameMap, Board playarea, JFrame frame){
        
        this.frame = frame;
        map = gameMap;
        board = playarea;
        up=0;
        down=0;
        right=0;
        left=0;
        ts.start();
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
            
                up=1;
                break;
            case 39: 
            
                right=1;
                break;
            case 40:
           
                down=1;
                break;
        }
    }

    
    @Override
    public void keyReleased(KeyEvent e){
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

    //each tick, event manager will call this function to get the direction
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
     

     Tick tick=new Tick(this);

}
