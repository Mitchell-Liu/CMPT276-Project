package com.group20;

public class Collectible extends Entity{
    
    private int value;

    
    /** 
     * @return int
     */
    @Override
    public int getValue(){
        return value;
    }

    
    /** 
     * @param val
     */
    public void setValue(int val){
        value = val;
    }

}
