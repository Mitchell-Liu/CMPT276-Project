package com.group20;

/*
 * Class: Map
 * Description: Stores all game entities 
 * 2D array is used for drawing game board in UI
 * Manages movement of entities after initialization
 */
public class Map {
    
    private Entity[][] entities;

    //Updates to location of an enitity already on the map
    public void updateLocationOf(Entity entity, Position newPosition){
        
        if(this.hasEntity(entity)&&this.positionIsVacant(newPosition)){
            this.entities[entity.getPosition().getX()][entity.getPosition().getY()] = null;
            this.entities[newPosition.getX()][newPosition.getY()] = entity;
            entity.setPosition(newPosition.getX(), newPosition.getY());
        }
        else{

        }
    }

    //Checks if given position is occupied or not
    public boolean positionIsVacant(Position position){
        if(entities[position.getX()][position.getY()]==null){
            return true;
        }
        else{
            return false;
        }
    }

    //Checks if given entity is on the map 
    public boolean hasEntity(Entity entity){
        if(entities[entity.getPosition().getX()][entity.getPosition().getY()]==entity){
            return true;
        }
        else{
            return false;
        }
    }

    //Returns the entity at given position, returns null if position vacant
    public Entity getEntityAt(Position position){
        if(!this.positionIsVacant(position)){
            return entities[position.getX()][position.getY()];
        }
        else{
            return null;
        }
    }

    //Inserts given entity at given position. Entity cannot already be present on map
    public void setEntityAt(Entity entity, Position position){
        if(this.positionIsVacant(position)&&!this.hasEntity(entity)){
            entities[position.getX()][position.getY()] = entity;
        }
        else{

        }
    }

}
