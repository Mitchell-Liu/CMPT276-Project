package com.group20;

/**
 * Class: Entity
 * Description: Class to be extended by all subsequent game entities
 * Entities all share position attribute
 */

public class Entity {
    
    private Position pos;

    public void setPosition(int x, int y){
        this.pos.setX(x);
        this.pos.setY(y);
    }

    public Position getPosition(){
        return this.pos;
    }

}
