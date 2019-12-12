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

    /**
     * 获取矩阵中某一行从{@code start} 开始的 {@code length}个元素
     *
     * @param row    要获取元素的行
     * @param start  开始位置
     * @param length 元素个数
     * @return 包含{@code length}个元素的数组
     */
    public boolean[] getRowArray(int row, int start, int length) {
        boolean[] array = new boolean[length];
        System.arraycopy(matrix[row], start, array, 0, length);
        return array;
    }

    public boolean[] getRowArray(int row) {
        return getRowArray(row, 0, this.column);
    }

    public boolean[] getColumnArray(int column, int start, int length) {
        boolean[] array = new boolean[length];
        for (int i = 0; i < length; i++) {
            array[i] = matrix[start + i][column];
        }
        return array;
    }

    public boolean[] getColumnArray(int column) {
        return getRowArray(column, 0, this.row);
    }

    public void setRow(int row, boolean[] array) {
        if (Math.min(array.length, this.column) >= 0)
            System.arraycopy(array, 0, matrix[row], 0, Math.min(array.length, this.column));
    }

    public void setColumn(int column, boolean[] array) {
        for (int i = 0; i < Math.min(array.length, this.row); i++) {
            boolean b = array[i];
            matrix[i][column] = b;
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

    public AdjacencyMatrix copy() {
        AdjacencyMatrix clone = new AdjacencyMatrix(row, column);
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, clone.matrix[i], 0, matrix[i].length);
        }
        return clone;
    }

    @Override
    public String toString() {
        return "AdjacencyMatrix{" + "matrix=\n"
                + Arrays.deepToString(matrix);
    }
}
