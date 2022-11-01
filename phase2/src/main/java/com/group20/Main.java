 package com.group20;
 
 
 public class Main {
   public static void main(String[] argv) throws Exception {
    StartMenu menu=new StartMenu();
    eventManager event=new eventManager();
    menu.addKeyListener(event);
    Tick tick=new Tick(event);
    tick.run();
   












 }










}

 