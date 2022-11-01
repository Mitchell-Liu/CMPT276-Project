package com.group20;
import java.util.concurrent.TimeUnit;

public class Tick implements Runnable{
    
    Tick(eventManager event){
        this.event=event;
    }

    public void run(){
        while(true){
            try {
                TimeUnit.SECONDS.sleep(1);
                //Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            
            direction di=event.Direction();
            
           
            switch(di){
              case up:
              System.out.println("up"); 
              break;
              case down:
              System.out.println("down"); 
              break;
              case right:
              System.out.println("right"); 
              break;
              case left:
              System.out.println("left"); 
              break;
              case pause:
              System.out.println("pause"); 
              break;
              
            }
          }
    }


    eventManager event;
}
