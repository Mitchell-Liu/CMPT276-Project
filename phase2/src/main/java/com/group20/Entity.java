package com.group20;

/**
 * Class: Entity
 * Description: Class to be extended by all subsequent game entities
 * Entities all share position attribute
 */

public class Entity {
    
    private Position pos;

    
    /** 
     * @param position
     */
    public void setPosition(Position position){
        this.pos = position;
    }

    
    /** 
     * @return Position
     */
    public Position getPosition(){
        return this.pos;
    }

    
    /** 
     * @return Boolean
     */
    public Boolean isCollectible(){
        if(this.getClass().getSuperclass().getSimpleName().equals("Collectible")){
            return true;
        }
        else{
            return false;
        }
    }

    
    /** 
     * @return int
     */
    public int getValue(){
        return 0;
    }

}
