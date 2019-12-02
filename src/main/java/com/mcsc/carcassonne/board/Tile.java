package com.mcsc.carcassonne.board;

import com.mcsc.carcassonne.game.Player;

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
    private TileLayer layer;
    private int rotation;
    private String expansion;
    private int identifier;
    /**
     * 保存各个位置放置的米宝，null表示未放置
     */
    private Map<EdgeDirectionEnum, Meeple> meeples;

    public Tile() {
        meeples = new HashMap<>(9);
        for(var direction: EdgeDirectionEnum.values()) {
            meeples.put(direction, null);
        }
    }

    /**
     * 返回与指定边缘所在区域相连的板块
     * @param edge 指定边缘
     * @return 连通的板块
     */
    public Tile[] getAdjacencyTile(EdgeDirectionEnum edge) {

        return null;
    }

    public Map<EdgeDirectionEnum, Meeple> getMeepleCount() {
        return meeples;
    }


}


