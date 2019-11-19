package com.mcsc.carcassonne.game;


import com.mcsc.carcassonne.board.Board;
import com.mcsc.carcassonne.ui.players.PlayerInfo;
import com.mcsc.carcassonne.ui.players.PlayersPanel;

import java.util.ArrayList;
import java.util.Map;

/**
 * 记录游戏的各种状态信息
 * 用于获取游戏信息和初始化一局新游戏
 */

public class GameState {
    private ArrayList<Player> players;
    private RoundStagePointer roundStagePointer;
    private Board board;
    private Map<ExpansionEnum, Boolean> expansions;
    private static GameState currentGameState;

    public GameState() {
        // board = new Board();
        players = new ArrayList<>();
        currentGameState = this;
//        if (!(isExpansionEnable(ExpansionEnum.RIVER_I) || isExpansionEnable(ExpansionEnum.RIVER_II)))
//            board.placeFirstTile();
    }

    public static void initialNewGame() {
        GameState newGame = new GameState();
        newGame.initialPlayerList(PlayersPanel.getPanel().getPlayersInfo());
    }

    public static GameState getCurrentGameState() {
        return currentGameState == null ? new GameState() : currentGameState;
    }

    public boolean isExpansionEnable(ExpansionEnum expansion) {
        return expansions.get(expansion);
    }

    public void initialPlayerList(ArrayList<PlayerInfo> players) {
        for (var player : players) {
            this.players.add(new Player(player.getID(), player.getColorState().getColor()));
        }
    }

    public ArrayList<Player> getPlayersList() {
        return players;
    }
}
