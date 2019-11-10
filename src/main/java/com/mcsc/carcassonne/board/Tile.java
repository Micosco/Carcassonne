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
    ArrayList<Meeple> meeples;

    /** get the number of players' meeple at the specified region
     *
     * @return number of players' meeple at the specified region
     */
    public Map<Player, Integer> getMeepleCount() {
        Map<Player, Integer> meepleCount = new HashMap<>();

        return meepleCount;
    }
}


