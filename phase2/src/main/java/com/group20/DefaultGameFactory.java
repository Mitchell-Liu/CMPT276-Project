package com.group20;

public class DefaultGameFactory extends GameFactory{
    public Map makeMap(){

        Map map = new Map();
        Diver diver = new Diver(new Position(1, 9));
        map.setDiver(diver);
        Shark s1 = new Shark(new Position(3, 3));
        
        map.setSharks(s1);
        
        //Placing all walls in default map
        map.setBorderWalls();
        for(int i = 5; i<17; i++){
            Position pos = new Position(i, 2);
            map.placeWall(pos);
        }
        map.placeWall(new Position(16, 3));
        map.placeWall(new Position(16, 4));
        for(int i = 2; i<13; i++){
            Position pos = new Position(i, 5);
            map.placeWall(pos);
        }
        map.placeWall(new Position(2, 2));
        map.placeWall(new Position(2, 3));
        map.placeWall(new Position(2, 4));
        for(int i = 4; i<11; i++){
            Position pos = new Position(i, 7);
            map.placeWall(pos);
        }
        for(int i = 7; i<15; i++){
            Position pos = new Position(4, i);
            map.placeWall(pos);
        }
        for(int i = 5; i<11; i++){
            Position pos = new Position(i, 14);
            map.placeWall(pos);
        }
        for(int i = 4; i<17; i++){
            Position pos = new Position(14, i);
            map.placeWall(pos);
        }
        for(int i = 6; i<15; i++){
            Position pos = new Position(i, 10);
            map.placeWall(pos);
        }
        for(int i = 3; i<12; i++){
            Position pos = new Position(i, 17);
            map.placeWall(pos);
        }
        map.placeWall(new Position(18,8));
        map.placeWall(new Position(17,8));
        map.placeWall(new Position(15,14));
        map.placeWall(new Position(16,14));

        map.placeCoin(new Position(9,9));
        map.placeCoin(new Position(18, 1));
        map.placeCoin(new Position(7, 16));
        map.placeCoin(new Position(3, 4));
        map.placeCoin(new Position(18, 18));
        map.setCoinsRemaining(5);

        map.placeSeaweed(new Position(7, 4));
        map.placeSeaweed(new Position(17, 7));
        map.placeSeaweed(new Position(16, 13));
        map.placeSeaweed(new Position(4, 16));
        map.placeSeaweed(new Position(8, 15));
        map.placeSeaweed(new Position(7, 9));
        map.placeSeaweed(new Position(13, 9));
        map.placeSeaweed(new Position(10, 13));
        map.placeSeaweed(new Position(15, 18));

        map.placeTreasureChest(new Position(15, 3));
        map.placeTreasureChest(new Position(5, 13));

        Exit gameExit = new Exit(new Position(19, 14));
        map.setExit(gameExit);
        

        return map;
    }



    public Board makeBoard(Map map){
        Board board = new Board(map);
        board.updateBoard();
        return board;
    }
}
