 package com.group20;
 import java.util.Timer;
 import java.util.TimerTask;
 import java.util.concurrent.TimeUnit;
 import java.io.File;
 
 /**
  * Main class of the program where the game code is executed.
  */
 public class Main {
   
   /** Main method of the program. Executes the game by generating a StartMenu.
    * @param argv
    * @throws Exception
    */
   public static void main(String[] argv) throws Exception {
      new StartMenu();
   } 
}

 