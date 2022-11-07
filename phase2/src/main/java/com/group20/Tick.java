package com.group20;
import java.util.concurrent.TimeUnit;

public class Tick implements Runnable{
    
    Tick(eventManager event){
        this.event=event;
        Thread thread = new Thread(this);
            thread.start();
    }

    public void run(){
        while(!event.map.isGameOver()){

            
            direction di=event.Direction();
            
           
            switch(di){
              case up:
                
              //System.out.println("up"); 
              event.map.moveDiverUp();
                event.board.updateBoard();
               
              break;
              case down:
              //System.out.println("down");
              event.map.moveDiverDown();
                event.board.updateBoard(); 
                
              break;
              case right:
              //System.out.println("right"); 
              event.map.moveDiverRight();
                event.board.updateBoard();
                
              break;
              case left:
              //System.out.println("left"); 
                event.map.moveDiverLeft();
                event.board.updateBoard();
                
              break;
              case pause:
              //System.out.println("pause"); 
              
                
              break;

              
            }
            event.up=0;
            event.down=0;
            event.right=0;
            event.left=0;

            if(event.map.isGameLose()){
              event.frame.dispose();
              new EndMenuLose();
            }
            else if (event.map.isGameWin()){
              event.frame.dispose();
              new EndMenuWin(event.map.getPlayerScore(),event.map.timePassed.time);
            }
            try {
                TimeUnit.MILLISECONDS.sleep(400);
                //Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
          }
    }


    eventManager event;
}
