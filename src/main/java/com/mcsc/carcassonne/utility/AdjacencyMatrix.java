package com.mcsc.carcassonne.utility;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class AdjacencyMatrix {
    private boolean[][] matrix;
    private int row, column;
    private boolean isSquare;

    public AdjacencyMatrix(int row, int column) {
        this.matrix = new boolean[row][column];
        this.row = row;
        this.column = column;
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

    public Set<Integer> getRow(int row) {
        Set<Integer> result = new HashSet<Integer>();
        for (int i = 0; i < column; i++) {
            if (matrix[row][i]) {
                result.add(i);
            }
        }
        return result;
    }

    public Set<Integer> getColumn(int column) {
        Set<Integer> result = new HashSet<Integer>();
        for (int i = 0; i < row; i++) {
            if (matrix[i][row]) {
                result.add(i);
            }
        }
        return result;
    }
}
