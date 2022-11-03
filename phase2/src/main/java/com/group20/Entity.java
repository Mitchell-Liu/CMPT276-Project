package com.group20;

/**
 * Class: Entity
 * Description: Class to be extended by all subsequent game entities
 * Entities all share position attribute
 */

public class Entity {
    
    private Position pos;

    public void setPosition(Position position){
        this.pos = position;
    }

    public Position getPosition(){
        return this.pos;
    }

    public Boolean isCollectible(){
        if(this.getClass().getSuperclass().getSimpleName().equals("Collectible")){
            return true;
        }
        else{
            return false;
        }
    }

    public int getValue(){
        return 0;
    }

}
