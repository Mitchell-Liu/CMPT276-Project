package com.group20;

/*
 * Class: Map
 * Description: Stores all game entities 
 * 2D array is used for drawing game board in UI
 * Manages movement of entities after initialization
 */
public class Map {
    
    private Entity[][] entities;
    Diver diver;
    Shark shark1, shark2;
    int coinsRemaining, playerScore;

    Map(){
        entities = new Entity[20][20];
    }

    public void placeWall(Position position){
        Wall newWall = new Wall(position);
        entities[newWall.getPosition().getX()][newWall.getPosition().getY()] = newWall;
    }


    public void setDiver(Diver player){
        diver = player;
        this.setEntityAt(player, player.getPosition());

    }

    public Diver getDiver(){
        return diver;
    }

    public void setDiverPosition(Position position){
        diver.setPosition(position);
    }

    public Position getDiverPosition(){
        return diver.getPosition();
    }

    public boolean moveDiverUp(){
        Position currentPosition = diver.getPosition();
        Position newPosition = new Position(diver.getPosition().getX(),diver.getPosition().getY()+1);
        if(this.positionIsVacant(currentPosition)){
            entities[diver.getPosition().getX()][diver.getPosition().getY()] = null;
            entities[diver.getPosition().getX()][diver.getPosition().getY()+1] = diver;
            diver.setPosition(newPosition);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean moveDiverDown(){
        Position currentPosition = diver.getPosition();
        Position newPosition = new Position(diver.getPosition().getX(),diver.getPosition().getY()-1);
        if(this.positionIsVacant(currentPosition)){
            entities[diver.getPosition().getX()][diver.getPosition().getY()] = null;
            entities[diver.getPosition().getX()][diver.getPosition().getY()-1] = diver;
            diver.setPosition(newPosition);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean moveDiverLeft(){
        Position currentPosition = diver.getPosition();
        Position newPosition = new Position(diver.getPosition().getX()-1,diver.getPosition().getY());
        if(this.positionIsVacant(currentPosition)){
            entities[diver.getPosition().getX()][diver.getPosition().getY()] = null;
            entities[diver.getPosition().getX()-1][diver.getPosition().getY()] = diver;
            diver.setPosition(newPosition);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean moveDiverRight(){
        Position currentPosition = diver.getPosition();
        Position newPosition = new Position(diver.getPosition().getX()+1,diver.getPosition().getY());
        if(this.positionIsVacant(currentPosition)){
            entities[diver.getPosition().getX()][diver.getPosition().getY()] = null;
            entities[diver.getPosition().getX()+1][diver.getPosition().getY()] = diver;
            diver.setPosition(newPosition);
            return true;
        }
        else{
            return false;
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


    //Returns the entity at given position, returns null if position vacant
    public Entity getEntityAt(Position position){
        if(!this.positionIsVacant(position)){
            return entities[position.getX()][position.getY()];
        }
        else{
            return null;
        }
    }

    public String getEntityNameAt(Position position){
        if(!this.positionIsVacant(position)){
            return entities[position.getX()][position.getY()].getClass().getName();
        }
        else{
            return "Water";
        }
    }

    //Inserts given entity at given position. Entity cannot already be present on map
    public void setEntityAt(Entity entity, Position position){
        if(this.positionIsVacant(position)){
            entities[position.getX()][position.getY()] = entity;
        }
        else{

        }
    }

}
