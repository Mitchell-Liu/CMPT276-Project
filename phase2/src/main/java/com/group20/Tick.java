package com.group20;
import java.util.concurrent.TimeUnit;

public class Tick implements Runnable{
    
    Tick(eventManager event){
        this.event=event;
        Thread thread = new Thread(this);
            thread.start();
    }

    public void run(){
        while(true){
            
          
            
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
            try {
                TimeUnit.MILLISECONDS.sleep(200);
                //Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
          }
    }


    eventManager event;
}
