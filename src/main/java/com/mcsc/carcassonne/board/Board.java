package com.mcsc.carcassonne.board;

import com.mcsc.carcassonne.game.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * 用于进行游戏的棋盘
 * 保存游戏主要数据
 *
 * @author WhiteWing
 */
public class Board {
    private BoardPosition[][] board;
    private int boardSize;
    private int tileCount;
    private Tile lastPlaced;

    public static final int DEFAULT_SIZE = 201;

    public Board() {
        this(DEFAULT_SIZE);
    }

    public Board(int boardSize) {
        this.boardSize = boardSize;
        board = new BoardPosition[boardSize][boardSize];
        tileCount = 0;

        int halfOfBoardSize = boardSize / 2;
        //在board上每个设置放置一个不包含板块的BoardPosition对象
        for (int i = 0, x = -halfOfBoardSize; i <= boardSize; i++, x++) {
            for (int j = 0, y = -halfOfBoardSize; j <= boardSize; j++, y++) {
                board[i][j] = new BoardPosition(x, y);
            }
        }
    }

    /**
     * 在指定位置放置米宝
     *
     * @param x    指定位置的横坐标
     * @param y    指定位置的纵坐标
     * @param tile 要放置的板块
     */
    public void placeTile(int x, int y, Tile tile) {
        board[x][y].placeTile(tile);
        // TODO 补全方法体：结算分数

        lastPlaced = tile;
    }

    /**
     * 在中心位置放置第一个板块
     * 在仅使用基础包时， 放置初始板块
     * TODO 在河流扩展包可用时， 放置由玩家选择的初始河流板块
     *
     * @param tile 要放置的板块
     */
    public void placeFirstTile(Tile tile) {

    }

    /**
     * 在指定区域放置米宝
     *
     * @param region 要放置米宝的区域
     */
    public void placeMeeple(EdgeDirectionEnum region) {
    }

    /**
     * 当放置最后一个板块后，结算分数
     *
     * @return 每位玩家的分数
     */
    public Map<Player, Integer> settleScore() {
        Map<Player, Integer> scores = new HashMap<Player, Integer>(0);
        return scores;
    }
}
