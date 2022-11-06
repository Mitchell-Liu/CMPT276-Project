package com.group20;
import java.util.concurrent.TimeUnit;

public class tickShark extends Thread{
    
    tickShark(eventManager event){
        this.event=event;
        
    }

    @Override
    public void run(){
        while(!event.map.isGameOver()){
            

          BFS shark=new BFS(event.map,event.map.shark1.getPosition());
           

            

              direction sharkDi=shark.Search();
            System.out.print("Ther return direction is:"+sharkDi.name());
              switch(sharkDi){
                case up:
                  
                //System.out.println("up"); 
                event.map.moveSharkUp();
                  event.board.updateBoard();
                 
                break;
                case down:
                //System.out.println("down");
                event.map.moveSharkDown();
                  event.board.updateBoard(); 
                  
                break;
                case right:
                //System.out.println("right"); 
                event.map.moveSharkRight();
                  event.board.updateBoard();
                  
                break;
                case left:
                //System.out.println("left"); 
                  event.map.moveSharkLeft();
                  event.board.updateBoard();
                  
                break;
                case pause:
                //System.out.println("pause"); 
                
                  
                break;
  
  
              }


              shark=null;

              if(event.map.isGameLose()){
                event.frame.dispose();
                new EndMenuLose();
              }
              
            try {
                TimeUnit.MILLISECONDS.sleep(500);
                //Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
          }
    }


    eventManager event;
}
