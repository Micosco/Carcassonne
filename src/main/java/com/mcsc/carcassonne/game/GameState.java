package com.mcsc.carcassonne.game;


import com.mcsc.carcassonne.board.Board;

import java.util.Map;
import java.util.Queue;

/**
 * 记录游戏的各种状态信息
 * 用于获取游戏信息和初始化一局新游戏
 */

public class GameState {
    private Queue<Player> players;
    private RoundStagePointer roundStagePointer;
    private Board board;
    private Map<ExpansionEnum, Boolean> expansions;

    public GameState() {
        board = new Board();
//        if (!(isExpansionEnable(ExpansionEnum.RIVER_I) || isExpansionEnable(ExpansionEnum.RIVER_II)))
//            board.placeFirstTile();
    }

    public boolean isExpansionEnable(ExpansionEnum expansion) {
        return expansions.get(expansion);
    }
}
