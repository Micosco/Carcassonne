package com.mcsc.carcassonne.board;

import com.mcsc.carcassonne.game.GameState;
import com.mcsc.carcassonne.game.Player;
import com.mcsc.carcassonne.game.RoundStagePointer;

import java.io.IOException;
import java.util.*;

/**
 * 游玩时所使用的板块
 *
 * {@code identifier} 表示该板块的编号， GUI通过该编号决定要显示的卡图
 * {@code expansion} 表示该板块所属的扩展包
 */

public class Tile {
    Meeple[] meeples;
    private TileLayer layer;
    private int rotation;
    private String expansion;
    private int identifier;
    private String name;
    private String texturePath;
    public Tile(String expansion,int identifier){
        this.identifier = identifier;
        this.expansion = expansion;
        this.name = expansion+identifier;
        TileGenerator reader = new TileGenerator(".\\src\\main\\resources\\cardInfo.json");
        this.texturePath = reader.getTexturePath(name);
        layer = new TileLayer(reader.isChurch(name),
                reader.getEdgeTypeEnum(name),
                reader.getAdjacencyMatrix(name));
        meeples = new Meeple[9];
    }

    public Meeple placeMeeple(EdgeDirectionEnum direction) {
        int realDirection = direction.ordinal() - rotation;
        if (realDirection < 0) realDirection += 8;
        Meeple newMeeple = new Meeple(GameState.getCurrentGameState().getCurrentPlayer());
        if (direction == EdgeDirectionEnum.END) meeples[8] = newMeeple;
        else meeples[realDirection % 8] = newMeeple;
        RoundStagePointer.getDefaultStagePointer().nextStage();

        return newMeeple;
    }


    public Meeple[] getMeeples() {
        return meeples;
    }

    public int getIdentifier() {
        return identifier;
    }

    public String getExpansion() {
        return expansion;
    }

    public String getName() {
        return name;
    }

    public TileLayer getLayer() {
        return layer;
    }

    public int getRotation() {
        return rotation;
    }

    @Override
    public String toString() {
        return "Tile{" +
                "meeples=" + meeples +
                ", layer=" + layer +
                ", rotation=" + rotation +
                ", expansion='" + expansion + '\'' +
                ", identifier=" + identifier +
                ", name='" + name + '\'' +
                ", texturePath='" + texturePath + '\'' +
                '}';
    }
}


