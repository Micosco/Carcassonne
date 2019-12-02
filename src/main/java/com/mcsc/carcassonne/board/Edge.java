package com.mcsc.carcassonne.board;

public class Edge {
    private EdgeTypeEnum edgeType;

    public Edge(EdgeTypeEnum edgeType) {
        this.edgeType = edgeType;
    }

    public EdgeTypeEnum getEdgeType() {
        return edgeType;
    }
}
