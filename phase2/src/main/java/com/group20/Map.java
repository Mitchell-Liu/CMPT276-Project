package com.group20;

import javax.swing.JFrame;

/*
 * Class: Map
 * Description: Stores all game entities 
 * 2D array is used for drawing game board in UI
 * Manages movement of entities after initialization
 */
public class Map {
    
    private Entity[][] entities;
    Diver diver;
    Shark shark1;
    Exit exit;
    int coinsRemaining, playerScore;
    Timer timePassed = new Timer();
    Boolean gameOver, gameWin, gameLose;
    
    Map(){
        entities = new Entity[20][20];
        playerScore = 0;
        // timePassed.run();
        System.out.println("Time:" + timePassed.time);
        gameWin = false;
        gameLose = false;
        gameOver = false;
    }

    public Boolean isGameOver(){
        return this.gameOver;
    }

    public Boolean isGameLose(){
        return this.gameLose;
    }

    public Boolean isGameWin(){
        return this.gameWin;
    }


    public void setPlayerScore(int num){
        this.playerScore = num;
    }

    public int getPlayerScore(){
        return this.playerScore;
    }

    public void setCoinsRemaining(int num){
        this.coinsRemaining = num;
    }

    public int getCoinsRemaining(){
        return this.coinsRemaining;
    }

    public Boolean allCoinsCollected(){
        if(coinsRemaining==0){
            return true;
        }
        else{
            return false;
        }
    }

    public void placeCoin(Position pos){
        Coin coin = new Coin(pos);
        entities[coin.getPosition().getX()][coin.getPosition().getY()] = coin;
    }

    public void placeTreasureChest(Position pos){
        TreasureChest treasure = new TreasureChest(pos);
        entities[treasure.getPosition().getX()][treasure.getPosition().getY()] = treasure;
    }

    public void placeSeaweed(Position pos){
        Seaweed seaweed = new Seaweed(pos);
        entities[seaweed.getPosition().getX()][seaweed.getPosition().getY()] = seaweed;
    }

    public void placeWall(Position position){
        Wall newWall = new Wall(position);
        entities[newWall.getPosition().getX()][newWall.getPosition().getY()] = newWall;
    }

    public void setSharks(Shark shark1){
        this.shark1 = shark1;
        //this.shark2 = shark2;
        this.setEntityAt(shark1, shark1.getPosition());
        //this.setEntityAt(shark2, shark2.getPosition());
    }
    public Shark getShark1(){
        return shark1;
    }
    //public Shark getShark2(){
       // return shark2;
   // }
    public void setSharkPosition(Position position1, Position position2){
        shark1.setPosition(position1);
        //shark2.setPosition(position2);
    }

    public Position getShark1Position(){
        return shark1.getPosition();
    }
    //public Position getShark2Position(){
       // return shark2.getPosition();
    //}
    
    public void setDiver(Diver player){
        this.diver = player;
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

    public void setExit(Exit gameExit){
        this.exit = gameExit;
    }

    public void openExit(){
        this.removeEntityAt(exit.getPosition());
        this.setEntityAt(exit, exit.getPosition());
    }

    public void manageCollisionAt(Position newPosition){
        String name = getEntityNameAt(newPosition);
        Position currentPosition = this.getDiverPosition();
        int value;
        switch(name){
            case "Coin":
                value = this.getEntityAt(newPosition).getValue();
                this.removeEntityAt(newPosition);
                this.setPlayerScore(this.getPlayerScore()+value);
                this.removeEntityAt(currentPosition);
                this.setEntityAt(diver, newPosition);
                this.setDiverPosition(newPosition);
                System.out.println("Player Score: "+playerScore);
                this.setCoinsRemaining(this.getCoinsRemaining()-1);
                System.out.println("Remaining Coins: "+coinsRemaining);
                if(this.allCoinsCollected()){
                    this.openExit();
                    System.out.println(this.getEntityNameAt(new Position(19, 14)));
                    System.out.println(this.positionIsVacant(new Position(19, 14)));
                }
                break;
            case "TreasureChest":
                value = this.getEntityAt(newPosition).getValue();
                this.removeEntityAt(newPosition);
                this.setPlayerScore(this.getPlayerScore()+value);
                this.removeEntityAt(currentPosition);
                this.setEntityAt(diver, newPosition);
                this.setDiverPosition(newPosition);
                System.out.println("Player Score: "+playerScore);
                break;
            case "Seaweed":
                value = this.getEntityAt(newPosition).getValue();
                this.removeEntityAt(newPosition);
                this.setPlayerScore(this.getPlayerScore()+value);
                this.removeEntityAt(currentPosition);
                this.setEntityAt(diver, newPosition);
                this.setDiverPosition(newPosition);
                System.out.println("Player Score: "+playerScore);
                break;
            case "Exit":
                this.removeEntityAt(newPosition);
                this.removeEntityAt(currentPosition);
                this.setEntityAt(diver, newPosition);
                this.setDiverPosition(newPosition);
                gameWin = true;
                gameOver = true;
                
                
                break; 
            case "Shark":
                gameLose = true;
                gameOver = true;
                
                break;
            case "Diver":
                gameLose = true;
                gameOver = true;
               
                break;
            default:           

            
        }
    }
    
    public Boolean positionisValid(Position pos){
        if(pos.getX()>-1&&pos.getX()<20&&pos.getY()>-1&&pos.getY()<20){
            return true;
        }
        else{
            return false;
        }
    }
    



    public boolean moveSharkUp(){
        Position currentPosition = shark1.getPosition();
        Position newPosition = new Position(shark1.getPosition().getX(),shark1.getPosition().getY()-1);
        if(this.positionIsVacant(newPosition)){
            entities[currentPosition.getX()][currentPosition.getY()] = null;
            entities[newPosition.getX()][newPosition.getY()] = shark1;
            shark1.setPosition(newPosition);
            return true;
        }
        else if(!this.positionIsVacant(newPosition)){
            manageCollisionAt(newPosition);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean moveSharkDown(){
        Position currentPosition = shark1.getPosition();
        Position newPosition = new Position(shark1.getPosition().getX(),shark1.getPosition().getY()+1);
        if(this.positionIsVacant(newPosition)&&positionisValid(newPosition)){
            entities[currentPosition.getX()][currentPosition.getY()] = null;
            entities[newPosition.getX()][newPosition.getY()] = shark1;
            shark1.setPosition(newPosition);
            return true;
        }
        else if(!this.positionIsVacant(newPosition)&&positionisValid(newPosition)){
            manageCollisionAt(newPosition);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean moveSharkLeft(){
        Position currentPosition = shark1.getPosition();
        Position newPosition = new Position(shark1.getPosition().getX()-1,shark1.getPosition().getY());
        if(this.positionIsVacant(newPosition)&&positionisValid(newPosition)){
            entities[currentPosition.getX()][currentPosition.getY()] = null;
            entities[newPosition.getX()][newPosition.getY()] = shark1;
            shark1.setPosition(newPosition);
            return true;
        }
        else if(!this.positionIsVacant(newPosition)&&positionisValid(newPosition)){
            manageCollisionAt(newPosition);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean moveSharkRight(){
        Position currentPosition = shark1.getPosition();
        Position newPosition = new Position(shark1.getPosition().getX()+1,shark1.getPosition().getY());
        if(this.positionIsVacant(newPosition)&&positionisValid(newPosition)){
            entities[currentPosition.getX()][currentPosition.getY()] = null;
            entities[newPosition.getX()][newPosition.getY()] = shark1;
            shark1.setPosition(newPosition);
            return true;
        }
        else if(!this.positionIsVacant(newPosition)&&positionisValid(newPosition)){
            manageCollisionAt(newPosition);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean moveDiverUp(){
        Position currentPosition = diver.getPosition();
        Position newPosition = new Position(diver.getPosition().getX(),diver.getPosition().getY()-1);
        if(this.positionIsVacant(newPosition)){
            entities[currentPosition.getX()][currentPosition.getY()] = null;
            entities[newPosition.getX()][newPosition.getY()] = diver;
            diver.setPosition(newPosition);
            return true;
        }
        else if(!this.positionIsVacant(newPosition)){
            manageCollisionAt(newPosition);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean moveDiverDown(){
        Position currentPosition = diver.getPosition();
        Position newPosition = new Position(diver.getPosition().getX(),diver.getPosition().getY()+1);
        if(this.positionIsVacant(newPosition)&&positionisValid(newPosition)){
            entities[currentPosition.getX()][currentPosition.getY()] = null;
            entities[newPosition.getX()][newPosition.getY()] = diver;
            diver.setPosition(newPosition);
            return true;
        }
        else if(!this.positionIsVacant(newPosition)&&positionisValid(newPosition)){
            manageCollisionAt(newPosition);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean moveDiverLeft(){
        Position currentPosition = diver.getPosition();
        Position newPosition = new Position(diver.getPosition().getX()-1,diver.getPosition().getY());
        if(this.positionIsVacant(newPosition)&&positionisValid(newPosition)){
            entities[currentPosition.getX()][currentPosition.getY()] = null;
            entities[newPosition.getX()][newPosition.getY()] = diver;
            diver.setPosition(newPosition);
            return true;
        }
        else if(!this.positionIsVacant(newPosition)&&positionisValid(newPosition)){
            manageCollisionAt(newPosition);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean moveDiverRight(){
        Position currentPosition = diver.getPosition();
        Position newPosition = new Position(diver.getPosition().getX()+1,diver.getPosition().getY());
        if(this.positionIsVacant(newPosition)&&positionisValid(newPosition)){
            entities[currentPosition.getX()][currentPosition.getY()] = null;
            entities[newPosition.getX()][newPosition.getY()] = diver;
            diver.setPosition(newPosition);
            return true;
        }
        else if(!this.positionIsVacant(newPosition)&&positionisValid(newPosition)){
            manageCollisionAt(newPosition);
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
            return entities[position.getX()][position.getY()].getClass().getSimpleName();
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

    public void removeEntityAt(Position pos){
        entities[pos.getX()][pos.getY()] = null;
    }

    public void setBorderWalls(){
        for(int i = 0; i<20; i++){
            Position pos = new Position(i, 0);
            this.placeWall(pos);
        }

        for(int i = 0; i<20; i++){
            Position pos = new Position(i, 19);
            this.placeWall(pos);
        }

        for(int i = 0; i<20; i++){
            Position pos = new Position(0, i);
            this.placeWall(pos);
        }

        for(int i = 0; i<20; i++){
            Position pos = new Position(19, i);
            this.placeWall(pos);
        }
    }

}
