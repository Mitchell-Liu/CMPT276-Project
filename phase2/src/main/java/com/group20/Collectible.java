package com.group20;

/**
 * A type of entity that the player collects to gain points and open the level exit.
 */
public class Collectible extends Entity{
    
    private int value;

    
    /** Returns the score value of the given collectible.
     * @return int: the value of a collectible.
     */
    @Override
    public int getValue(){
        return value;
    }

    
    /** Sets the score value of a collectible.
     * @param val: The value given to a collectible.
     */
    public void setValue(int val){
        value = val;
    }

}
