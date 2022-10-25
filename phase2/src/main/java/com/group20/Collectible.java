package com.group20;

public class Collectible {
    
    private boolean collected;

    public boolean getCollectStatus(){
        return this.collected;
    }

    public void setCollectStatus(boolean newStatus){
        this.collected = newStatus;
    }

}
