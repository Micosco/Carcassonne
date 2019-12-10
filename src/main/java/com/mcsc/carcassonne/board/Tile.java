package com.mcsc.carcassonne.board;

import com.mcsc.carcassonne.game.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 游玩时所使用的板块
 *
 * {@code identifier} 表示该板块的编号， GUI通过该编号决定要显示的卡图
 * {@code expansion} 表示该板块所属的扩展包
 */

public class Tile {
    ArrayList<Meeple> meeples;
    /** get the number of players' meeple at the specified region
     *
     * @return number of players' meeple at the specified region
     */
    public Map<Player, Integer> getMeepleCount() {
        Map<Player, Integer> meepleCount = new HashMap<>(6);

        return meepleCount;
    }

    private TileLayer layer;
    private int rotation;
    private String expansion;
    private int identifier;
    private String name;
    //private String texturePath;
    public Tile(String expansion,int identifier){
        this.identifier = identifier;
        this.expansion = expansion;
        this.name = expansion+identifier;
        TileGenerator reader = new TileGenerator(".\\src\\main\\resources\\cardInfo.json");
        //this.texturePath = reader.getTexturePath(name);
        layer = new TileLayer(reader.isChurch(name),
                reader.getEdgeTypeEnum(name),
                reader.getAdjacencyMatrix(name));
    }

    //public String getTexturePath() {
    //    return texturePath;
    //}

    @Override
    public String toString() {
        return "Tile{" +
                "meeples=" + meeples +
                ", layer=" + layer +
                ", rotation=" + rotation +
                ", expansion='" + expansion + '\'' +
                ", identifier=" + identifier +
                ", name='" + name + '\'' +
                '}';
    }
}


