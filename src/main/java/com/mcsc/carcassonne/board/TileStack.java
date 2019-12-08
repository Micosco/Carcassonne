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
    private static Tile OriginTile;
    public boolean isEmpty() {
        return tileStack.empty();
    }

    public Tile draw() {
        return tileStack.pop();
    }

    public TileStack(String expansionName){
        int num = new TileGenerator(".\\src\\main\\resources\\cardInfo.json").getTotalTileNum(expansionName);
        ArrayList<Tile> tileArrayList = new ArrayList<>();
        tileStack = new Stack<>();
        OriginTile = new Tile("base",0);
        for (int i = 1; i < num; i++) {
            Tile tile = new Tile(expansionName,i);
            tileArrayList.add(tile);
        }
        Collections.shuffle(tileArrayList);
        for (Tile tile : tileArrayList) {
            tileStack.push(tile);
        }
    }

    public static Tile getOriginTile() {
        return OriginTile;
    }

    @Override
    public String toString() {
        return "TileStack{" +
                "tileStack=" + tileStack;
    }

    @Override
    public String toString() {
        return "TileStack{" +
                "tileStack=" + tileStack;
    }
}
