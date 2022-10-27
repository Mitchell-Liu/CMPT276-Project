 package com.group20;
 
 import java.util.Timer;
 import java.util.TimerTask;

 public class Main {
   public static void main(String[] argv) throws Exception {
    new Frame();
    
    Timer t = new Timer();  
    TimerTask tt = new TimerTask() {  
    @Override  
    public void run() {  
        System.out.println("Task Timer on Fixed Rate");  
    };  
  };  
  t.scheduleAtFixedRate(tt,500,1000); 




 }}

 