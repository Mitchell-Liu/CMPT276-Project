package com.group20;

/**
 * The main enemy which chases the player. If the player is touched by a shark, the game ends.
 */
public class Shark extends Entity{
    
    Shark(Position position){
        this.setPosition(position);
    }

}
