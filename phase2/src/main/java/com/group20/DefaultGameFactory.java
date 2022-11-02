package com.group20;

public class DefaultGameFactory extends GameFactory{
    public Map makeMap(){
        Map map = new Map();
        Diver diver = new Diver(new Position(1, 9));
        map.setDiver(diver);
        map.setBorderWalls();
        return map;
    }



    public Board makeBoard(Map map){
        Board board = new Board(map);
        board.updateBoard();
        return board;
    }
}
