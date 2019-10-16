package com.mcsc.carcassonne.board;

import com.mcsc.carcassonne.exception.NumberOfEdgesNotMatchException;
import com.mcsc.carcassonne.utility.AdjacencyMatrix;


/**
 *
 */

public class TileLayer {
    private Edge[] edges;
    private AdjacencyMatrix unicom;

    public TileLayer(EdgeTypeEnum... edges) throws NumberOfEdgesNotMatchException {
        if (edges.length != 8) {
            throw new NumberOfEdgesNotMatchException();
        }
    }
}
