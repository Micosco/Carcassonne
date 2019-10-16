package com.mcsc.carcassonne.utility;

public class AdjacencyMatrix {
    private boolean[][] matrix;
    private boolean isSquare;

    public AdjacencyMatrix(int row, int column) {
        this.matrix = new boolean[row][column];
        this.isSquare = row == column;
    }

    public AdjacencyMatrix(int size) {
        this.matrix = new boolean[size][size];
        this.isSquare = true;
    }

    public void setAdjacent(int row, int column, boolean isAdjacent) {
        this.matrix[row][column] = isAdjacent;
    }

    public void setSymmetricAdjacent(int row, int column, boolean isAdjacent) {
        if (!isSquare) {
            throw new UnsupportedOperationException();
        }

        this.matrix[row][column] = isAdjacent;
        this.matrix[column][row] = isAdjacent;
    }

    public boolean isAdjacent(int row, int column) {
        return matrix[row][column];
    }

    public boolean isSymmetricAdjacent(int row, int column) {
        return isSquare && (matrix[row][column] == matrix[row][column]);
    }
}
