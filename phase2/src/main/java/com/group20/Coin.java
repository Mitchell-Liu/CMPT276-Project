package com.group20;

/**
 * A type of collectible the player collects to gain points.
 */
public class Coin extends Collectible{
    Coin(Position pos){
        this.setValue(5);
        this.setPosition(pos);
    }
}
