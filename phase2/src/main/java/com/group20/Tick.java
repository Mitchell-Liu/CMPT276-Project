package com.group20;
import java.util.concurrent.TimeUnit;

/**
 * tick class will call eventManager function every tick period
 */
public class Tick implements Runnable{
    
    Tick(eventManager event){
        this.event=event;
        Thread thread = new Thread(this);
            thread.start();
    }
    // Moves the player based on the keybord input every second
    public void run(){
        while(!event.map.isGameOver()){          
            direction di=event.Direction();
                       
            switch(di){
              case up:
                
              event.map.moveDiverUp();
                event.board.updateBoard();
               
              break;
              case down:
              event.map.moveDiverDown();
                event.board.updateBoard(); 
                
              break;
              case right:
              event.map.moveDiverRight();
                event.board.updateBoard();
                
              break;
              case left:
                event.map.moveDiverLeft();
                event.board.updateBoard();
                
              break;
              case pause:

                
              break;

              
            }
            event.up=0;
            event.down=0;
            event.right=0;
            event.left=0;

            // Checks if the game has ended and if the player has won or lost
            if(event.map.isGameLose()){
              event.frame.dispose();
              new EndMenuLose(event.map.getPlayerScore());
            }
            else if (event.map.isGameWin()){
              event.frame.dispose();
              new EndMenuWin(event.map.getPlayerScore());
            }
            try {
                TimeUnit.MILLISECONDS.sleep(400);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
          }
    }


    eventManager event;
}
