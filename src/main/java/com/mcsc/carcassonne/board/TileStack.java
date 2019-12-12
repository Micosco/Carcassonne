package com.mcsc.carcassonne.board;

import java.io.IOException;
import java.net.URL;
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
    private String filePath;
    public boolean isEmpty() {
        return tileStack.empty();
    }

    public Tile draw() {
        return tileStack.pop();
    }

    public Tile top() {
        return tileStack.peek();
    }

    public TileStack(String expansionName){
        URL url = getClass().getResource("/cardInfo.json");
        this.filePath = url.getPath();
        int num = new TileGenerator(filePath).getTotalTileNum(expansionName);
        ArrayList<Tile> tileArrayList = new ArrayList<>();
        tileStack = new Stack<>();
        OriginTile = new Tile("base",0);
        for (int i = 0; i < num; i++) {
            String TileName = expansionName + String.valueOf(i);
            for (int j = 0; j < (new TileGenerator(filePath).getQuantity(TileName)); j++) {
                Tile tile = new Tile(expansionName,i);
                tileArrayList.add(tile);
            }
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
        return getStackDepth() + "TileStack{" +
                "tileStack=" + tileStack;
    }
    public int getStackDepth()
    {
        return tileStack.size();
    }
}
