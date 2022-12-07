package com.group20;

/**
 * A type of entity that hinders the player's progress.
 */
public class Seaweed extends Collectible{

    /**
     * Constructor for Seaweed objects
     * @param pos position of seaweed instance
     */
    Seaweed(Position pos){
        this.setValue(-10);
        this.setPosition(pos);
    }
}
