package com.mcsc.carcassonne.board;

import com.mcsc.carcassonne.utility.AdjacencyMatrix;


/**
 *
 */

public class TileLayer {
    private Edge[] edges;
    private AdjacencyMatrix unicom;

    public TileLayer(EdgeTypeEnum... edges) {
        if (edges.length != 8) {
            throw new IllegalArgumentException("Number of edges don't match");
        }
    }
}
