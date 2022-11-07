package com.group20;
/**
 * TreasureChest for the player to collect
 */
public class TreasureChest extends Collectible{
    TreasureChest(Position pos){
        this.setValue(20);
        this.setPosition(pos);
    }
}
