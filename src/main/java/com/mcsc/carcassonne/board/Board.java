package com.mcsc.carcassonne.board;

import com.mcsc.carcassonne.game.Player;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private BoardPosition[][] board;
    private Tile lastPlaced;

    public Board() {
        board = new BoardPosition[201][201];

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
