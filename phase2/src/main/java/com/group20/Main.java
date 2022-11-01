 package com.group20;
 
 
 public class Main {
   public static void main(String[] argv) throws Exception {
    StartMenu menu=new StartMenu();
    eventManager event=new eventManager();
    menu.addKeyListener(event);
    Tick tick=new Tick(event);
    tick.run();
    //this.addKeyListener(new eventManager());
    
     /* 
    Timer t = new Timer();  
    TimerTask tt = new TimerTask() {  



   
    @Override  
    public void run() {  
      
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
        
         
    };  
  };  
  t.scheduleAtFixedRate(tt,500,1000); 








*/




 }










}

 