package com.group20;

public abstract class GameFactory {
    public abstract Map makeMap();
    public abstract Board makeBoard(Map map);
}
