package com.group20;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class eventManager implements KeyListener{
    
	

     int up,down,right,left;
     JTextArea ta;
     Board board;
     Map map;
     Diver diver;
     JFrame frame;
    //private eventManager event=new eventManager();
    public eventManager(Map gameMap, Board playarea){
       
        map = gameMap;
        board = playarea;
         up=0;
         down=0;
         right=0;
         left=0;


    }

    
    @Override
    public void keyTyped(KeyEvent e){
        
    }

    @Override
    public void keyPressed(KeyEvent e){
       
		switch(e.getKeyCode()) {
            case 37: 
           
                left=1;
                map.moveDiverLeft();
                board.updateBoard();
                break;
            case 38: 
            
                up=1;
                map.moveDiverUp();
                board.updateBoard();
                break;
            case 39: 
            
                right=1;
                map.moveDiverRight();
                board.updateBoard();
                break;
            case 40:
           
                down=1;
                map.moveDiverDown();
                board.updateBoard();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e){
        switch(e.getKeyCode()) {
            case 37: 
           
                left=0;
                //System.out.print("left");
                break;
            case 38: 
            
                up=0;
                //System.out.print("up");
                break;
            case 39: 
            
                right=0;
                //System.out.print("right");
                break;
            case 40:
           
                down=0;
                //System.out.print("down");
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
     


}
