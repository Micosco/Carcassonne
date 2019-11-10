package com.mcsc.carcassonne.board;

import com.mcsc.carcassonne.game.Player;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private BoardPosition[][] board;
    private int tileCount;
    private Tile lastPlaced;

    public Board() {
        board = new BoardPosition[201][201];
        tileCount = 0;

        for (int i = 0, x = -100; i <= 201; i++, x++) {
            for (int j = 0, y = -100; j <= 201; j++, y++) {
                board[i][j] = new BoardPosition(x, y);
            }
        }
    }

    /**
     * place a tile at specified place
     *
     * @param x    Abscissa of specified place
     * @param y    Ordinate of specified place
     * @param tile the tile to place
     */
    public void placeTile(int x, int y, Tile tile) {
        // TODO 补全方法体

        lastPlaced = tile;
    }

    /**
     * 在中心位置放置第一个板块
     * 在仅使用基础包时， 放置初始板块
     * TODO 在河流扩展包可用时， 放置由玩家选择的初始河流板块
     * @param tile 要放置的板块
     */
    public void placeFirstTile(Tile tile) {

    }

    /**
     * place meeple at specified region
     * this method will return
     *
     * @param region the region to place meeple
     */
    public void placeMeeple(EdgeDirectionEnum region) {
    }

    /** start to settle score at last placed tile
     *
     * @return each player scores
     */
    public Map<Player, Integer> settleScore() {
        Map<Player, Integer> scores = new HashMap<Player, Integer>(0);
        return scores;
    }
}
