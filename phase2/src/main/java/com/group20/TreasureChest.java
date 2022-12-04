package com.group20;
/**
 * Collectible entity which gives the player points.
 */
public class TreasureChest extends Collectible{
    TreasureChest(Position pos){
        this.setValue(20);
        this.setPosition(pos);
    }
}
