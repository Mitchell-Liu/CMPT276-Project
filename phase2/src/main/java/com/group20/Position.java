package com.group20;

/**
 * Class: Position
 * Description: Object used as attribute for entities to track their
 * position on game map
 */

public class Position{
    
    private int xPos, yPos;

    Position(int x, int y){
        xPos = x;
        yPos = y;
    }

    
    /** 
     * @param x
     */
    public void setX(int x){
        xPos = x;
    }

    
    /** 
     * @param y
     */
    public void setY(int y){
        yPos = y;
    }

    
    /** 
     * @return int
     */
    public int getX(){
        return this.xPos;
    }

    
    /** 
     * @return int
     */
    public int getY(){
        return this.yPos;
    }

    @Override
    public boolean equals(Object object){
        if(object==this){
            return true;
        }
        if(!(object instanceof Position)){
            return false;
        }
        
        Position compare = (Position) object;

        if(this.getX()!=compare.getX()||this.getY()!=compare.getY()){
            return false;
        }
        else{
            return true;
        }
    }

}
