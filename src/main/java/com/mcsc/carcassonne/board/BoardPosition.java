package com.mcsc.carcassonne.board;

/**
 * 游玩区中用于放置板块的一个方格
 */

public class BoardPosition {
    private int x, y;
    private Tile tile;

    public static final BoardPosition ORIGIN_POSITION = new BoardPosition(0,0);

    public BoardPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isEmpty() {
        return tile == null;
    }

    public void placeTile(Tile tile) {
        if (isEmpty()) {
            this.tile = tile;
        }
    }
}
