package com.mcsc.carcassonne.board;

import com.mcsc.carcassonne.utility.AdjacencyMatrix;

import java.util.Arrays;


/**
 * {@code TileLayer} 用于存放板块各边缘信息
 * <p>
 * 以一个 9 * 9 的邻接矩阵 {@code unicom} 表示各边缘间的连通关系.
 * 当不考虑板块中心, 即{@code unicom[9]} 时,该邻接矩阵满足对称性和传递性
 * 其中, {@code unicom[x][9]} 表示 x 边缘的道路连接到道路尽头.
 */

public class TileLayer {
    private EdgeTypeEnum[] edges;
    private AdjacencyMatrix matrix;
    private boolean isChurch;
    /*
    public TileLayer(EdgeTypeEnum... edges) {
        if (edges.length != this.edges.length) {
            throw new IllegalArgumentException("传入的边缘数不匹配");
        }
    }*/
    public TileLayer(boolean isChurch, EdgeTypeEnum[] edges,AdjacencyMatrix matrix)
    {
        this.isChurch = isChurch;
        this.edges = edges;
        this.matrix = matrix;
    }

    public EdgeTypeEnum[] getEdges() {
        return edges;
    }

    public boolean isChurch() {
        return isChurch;
    }

    public AdjacencyMatrix getMatrix() {
        return matrix;
    }

    @Override
    public String toString() {
        return "TileLayer{" +
                "edges=" + Arrays.toString(edges) +
                ", unicom=" + matrix +
                ", isChurch=" + isChurch +
                '}';
    }
}
