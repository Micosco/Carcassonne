package com.mcsc.carcassonne.utility;

import java.util.ArrayList;
import java.util.Arrays;
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

    public boolean[] getRowArray(int row) {
        return matrix[row];
    }

    public boolean[] getColumnArray(int column) {
        boolean[] columnArray = new boolean[this.row];
        for (int i = 0; i < this.row; i++) {
            columnArray[i] = matrix[i][column];
        }
        return columnArray;
    }

    public void setRow(int row, boolean[] array) {
        matrix[row] = array;
    }

    public void setColumn(int column, boolean[] array) {
        for (int i = 0; i < this.row; i++) {
            matrix[i][column] = array[i];
        }
    }

    public Set<Integer> getRow(int row) {
        Set<Integer> result = new HashSet<Integer>();
        // 将(row, row)元素添加进结果，保证自反性
        // 原因：保存的矩阵信息中不包含自反
        result.add(row);
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

    public boolean get(int row, int column) {
        return matrix[row][column];
    }

    @Override
    public String toString() {
        return "AdjacencyMatrix{" +
                "matrix=" + Arrays.deepToString(matrix);
    }
}
