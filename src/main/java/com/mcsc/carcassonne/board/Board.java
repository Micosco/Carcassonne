package com.mcsc.carcassonne.board;

public class Board {
    private BoardPosition[][] board;

    public Board() {
        board = new BoardPosition[201][201];

        for (int i = 0, x = -100; i <= 201; i++, x++) {
            for (int j = 0, y = -100; j <= 201; j++, y++) {
                board[i][j] = new BoardPosition(x, y);
            }
        }
    }

    public void placeTile(int x, int y, Tile tile) {
        board[x][y].placeTile(tile);
    }
}
