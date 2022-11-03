package com.group20;

public class Collectible extends Entity{
    
    private int value;

    @Override
    public int getValue(){
        return value;
    }

    public void setValue(int val){
        value = val;
    }

}
