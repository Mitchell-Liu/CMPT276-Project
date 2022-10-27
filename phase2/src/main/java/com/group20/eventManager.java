package com.group20;


public class eventManager {
    int up,down,right,left=0;
    eventManager(){
        new keyListener(this);

        

    }


    //each tick, event manager will call this function to get the direction
     public direction Direction(){
         int add=(up+down+right+left);
         if(add>1 || add==0 ){
             
             return direction.pause;
         }
         else if(up==1){
             return direction.up;
         }
         else if(down==1){
             return direction.down;
         }
         else if(left==1){
             return direction.left;
         }
         else {
             return direction.right;
         }
         
     }


}
