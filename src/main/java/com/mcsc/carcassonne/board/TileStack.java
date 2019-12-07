package com.mcsc.carcassonne.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * 板块堆， 每次放置的板块将从一个板块堆中抽取
 */

public class TileStack {
    private Stack<Tile> tileStack;
    private ArrayList<Tile> tileArrayList;

    public boolean isEmpty() {
        return tileStack.empty();
    }

    public Tile draw() {
        return tileStack.pop();
    }

    public TileStack(String expansionName) throws IOException {
        int num = new TileGenerator(".\\src\\main\\resources\\cardInfo.json").getTotalTileNum(expansionName);
        ArrayList<Tile> tileArrayList = new ArrayList<>();
        tileStack = new Stack<>();
        for (int i = 0; i < num; i++) {
            Tile tile = new Tile("inn",i);
            tileArrayList.add(tile);
        }//test
        Collections.shuffle(tileArrayList);
        for (int i = 0; i < num; i++) {
            tileStack.push(tileArrayList.get(i));
        }//test
    }

    @Override
    public String toString() {
        return "TileStack{" +
                "tileStack=" + tileStack;
    }
}
