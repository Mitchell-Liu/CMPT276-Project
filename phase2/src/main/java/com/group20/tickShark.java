package com.group20;
import java.util.concurrent.TimeUnit;

public class tickShark extends Thread{
    
  tickShark(eventManager event){
      this.event=event;
  }
  // Moves the player based on the algorithm
  @Override
  public void run(){
    while(!event.map.isGameOver()){
      BFS shark=new BFS(event.map,event.map.shark1.getPosition());

      direction sharkDi=shark.Search();
      System.out.print("Ther return direction is:"+sharkDi.name());

      switch(sharkDi){
        case up:
          event.map.moveSharkUp();
          event.board.updateBoard();
          
        break;
        case down:
          event.map.moveSharkDown();
          event.board.updateBoard(); 
          
        break;
        case right:
          event.map.moveSharkRight();
          event.board.updateBoard();
          
        break;
        case left:
          event.map.moveSharkLeft();
          event.board.updateBoard();
          
        break;
        case pause:

        break;
      }
      shark=null;
      // Checks if the game has ended and if the player has lost
      if(event.map.isGameLose()){
        event.frame.dispose();
        new EndMenuLose(event.map.getPlayerScore());
      }
      try {
        TimeUnit.MILLISECONDS.sleep(500);
      } 
      catch (InterruptedException e) {
        throw new IllegalStateException(e);
      }
    } 
  }
  eventManager event;
}
