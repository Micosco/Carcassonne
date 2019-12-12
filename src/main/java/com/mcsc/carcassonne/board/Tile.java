package com.mcsc.carcassonne.board;

import com.mcsc.carcassonne.game.GameState;

import java.net.URL;

/**
 * 游玩时所使用的板块
 * <p>
 * {@code identifier} 表示该板块的编号， GUI通过该编号决定要显示的卡图
 * {@code expansion} 表示该板块所属的扩展包
 */

public class Tile {
    private Meeple meeple;
    private EdgeDirectionEnum meeplePosition;
    private TileLayer layer;
    private int rotation;
    private String expansion;
    private int identifier;
    private String name;

    public Tile(String expansion, int identifier) {
        this.identifier = identifier;
        this.expansion = expansion;
        this.name = expansion + identifier;
        URL url = getClass().getResource("/cardInfo.json");
        String filePath = url.getPath();
        TileGenerator reader = new TileGenerator(filePath);
        layer = new TileLayer(reader.isChurch(name),
                reader.getEdgeTypeEnum(name),
                reader.getAdjacencyMatrix(name));
    }

    public void placeMeeple(EdgeDirectionEnum direction) {
        meeplePosition = direction;
        meeple = new Meeple(GameState.getCurrentGameState().getCurrentPlayer());
    }

    public void rotateClockWise() {
        layer.shiftEdges();
        layer.shiftMatrix();
        rotation += 2;
        rotation %= 8;
    }


    public void clearMeeple() {
        meeple = null;
    }

    public EdgeDirectionEnum getMeeplePosition() {
        return meeplePosition;
    }

    public Meeple getMeeple() {
        return meeple;
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

    public EdgeTypeEnum getEdge(EdgeDirectionEnum direction) {
        return layer.getEdges()[direction.ordinal()];
    }

    public int getRotation() {
        return rotation;
    }

    @Override
    public String toString() {
        return "Tile{" +
                ", layer=" + layer +
                ", rotation=" + rotation +
                ", expansion='" + expansion + '\'' +
                ", identifier=" + identifier +
                ", name='" + name + '\'' +
                '}';
    }
}


