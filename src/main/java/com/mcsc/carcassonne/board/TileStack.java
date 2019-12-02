package com.mcsc.carcassonne.board;

import java.util.Stack;

/**
 * 板块堆， 每次放置的板块将从一个板块堆中抽取
 */

public class TileStack {
    private Stack<Tile> tileStack;

    public boolean isEmpty() {
        return tileStack.empty();
    }

    public Tile draw() {
        return tileStack.pop();
    }
}
