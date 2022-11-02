package com.group20;

/**
 * Class: Entity
 * Description: Class to be extended by all subsequent game entities
 * Entities all share position attribute
 */

public class Entity implements Drawable{
    
    private Position pos;

    public void setPosition(Position position){
        this.pos = position;
    }

    public Position getPosition(){
        return this.pos;
    }

    public void draw(){
        //Implement later
    }

    public void erase(){
        //Implement later
    }

}
