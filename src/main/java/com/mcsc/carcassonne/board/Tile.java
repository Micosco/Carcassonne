package com.mcsc.carcassonne.board;

import com.mcsc.carcassonne.game.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tile {
    private TileLayer layer;
    private int rotation;
    ArrayList<Meeple> meeples;

    /** get the number of players' meeple at the specified region
     *
     * @return number of players' meeple at the specified region
     */
    public Map<Player, Integer> getMeepleCount() {
        Map<Player, Integer> meepleCount = new HashMap<Player, Integer>();

        return meepleCount;
    }
}


