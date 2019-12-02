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
     * 在指定位置放置板块
     * 将{@code Tile}对象保存至{@code board}
     * 使{@code lastPlaced} 指向最后放置的板块, {@code tileCount} + 1
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
     * 在板块指定区域(以区域的一个板块边缘表示)放置米宝
     *
     * 调用该方法时需同时调用{@code game.Player.placeMeeple()} 以确保玩家米宝计数正确
     *
     * @param region 要放置米宝的区域
     */
    public void placeMeeple(EdgeDirectionEnum region) {

    }

    /**
     * 放置一个板块后，结算分数并调用{@code game.Player.retrieveMeeple()}更新玩家米宝计数
     * 放置最后一个板块时，需要结算田野，未完成城镇、道路、修道院分数
     *
     * @return 每位玩家的分数
     */
    public Map<Player, Integer> settleScore() {
        Map<Player, Integer> scores = new HashMap<Player, Integer>(0);

        return scores;
    }
}
