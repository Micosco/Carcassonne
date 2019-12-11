package com.mcsc.carcassonne.board;

import java.util.HashMap;
import java.util.Map;

/**
 * 游玩区中用于放置板块的一个方格
 */

public class BoardPosition {
    private int x, y;
    private Tile tile;
    private Board parent;

    public static final BoardPosition ORIGIN_POSITION = new BoardPosition(0, 0);

    public BoardPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setParent(Board parent) {
        this.parent = parent;
    }

    public boolean isEmpty() {
        return tile == null;
    }

    public void placeTile(Tile tile) {
        if (isEmpty()) {
            this.tile = tile;
        }
    }

    /**
     * 获取与某一边缘相连通的边缘
     * @param direction 要进行查找的边缘
     * @return 连通的边缘
     */
    public Map<EdgeDirectionEnum, BoardPosition> getAdjacentTiles(EdgeDirectionEnum direction) {
        Map<EdgeDirectionEnum, BoardPosition> adjacentPosition = new HashMap<>();
        for (int direct : tile.getLayer().getMatrix().getRow(direction.ordinal())) {
            if (direct == 8) continue;
                EdgeDirectionEnum realDirection = EdgeDirectionEnum.valueOf((direct + tile.getRotation()) % 8);
                adjacentPosition.put(realDirection, parent.getPositionByDirection(this, realDirection));
        }
        return adjacentPosition;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Tile getTile() {
        return tile;
    }

    @Override
    public String toString() {
        return "BoardPosition{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
