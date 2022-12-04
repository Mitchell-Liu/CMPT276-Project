package com.group20;
/**
 * Used to make the game map and board.
 */
public abstract class GameFactory {
    public abstract Map makeMap();
    public abstract Board makeBoard(Map map);
}
