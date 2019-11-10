package com.mcsc.carcassonne.board;

import com.mcsc.carcassonne.utility.AdjacencyMatrix;


/**
 *  {@code TileLayer} 用于存放板块各边缘信息
 *
 *  以一个 9 * 9 的邻接矩阵 {@code unicom} 表示各边缘间的连通关系.
 *  该邻接矩阵满足对称性和传递性, 当不考虑板块中心, 即{@code unicom[4]} 时,
 *  该矩阵满足反自反性.
 *  其中, {@code unicom[x][4]} 表示 x 边缘的道路连接到道路尽头.
 */

public class TileLayer {
    private Edge[] edges;
    private AdjacencyMatrix unicom;

    public TileLayer(EdgeTypeEnum... edges) {
        if (edges.length != 8) {
            throw new IllegalArgumentException("传入的边缘数不匹配");
        }
    }
}
