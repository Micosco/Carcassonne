package com.mcsc.carcassonne.game;


import com.mcsc.carcassonne.board.Board;
import com.mcsc.carcassonne.board.TileStack;
import com.mcsc.carcassonne.ui.players.PlayerInfo;
import com.mcsc.carcassonne.ui.players.PlayerSettingPanel;
import com.mcsc.carcassonne.ui.players.PlayersPanel;

import java.util.ArrayList;
import java.util.Map;

/**
 * 记录游戏的各种状态信息
 * 用于获取游戏信息和初始化一局新游戏
 */

public class GameState {
    private ArrayList<Player> players;
    private int roundCount;
    private Player currentPlayer;
    private Board board;
    private Map<ExpansionEnum, Boolean> expansions;
    private static GameState currentGameState;

    public GameState() {
        board = new Board();
        board.placeFirstTile(TileStack.getOriginTile());
        players = new ArrayList<>();
        currentGameState = this;
//        if (!(isExpansionEnable(ExpansionEnum.RIVER_I) || isExpansionEnable(ExpansionEnum.RIVER_II)))
//            board.placeFirstTile();
    }

    public static GameState initialNewGame() {
        GameState newGame = new GameState();

        //获取玩家列表
        newGame.initialPlayerList(PlayerSettingPanel.getPanel().getPlayersInfo());
        return newGame;
    }

    public void initialPlayerList(ArrayList<PlayerInfo> players) {
        for (var player : players) {
            this.players.add(new Player(player.getID(), player.getColorState().getColor()));
        }
    }

    public static GameState getCurrentGameState() {
        return currentGameState == null ? new GameState() : currentGameState;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void nextPlayer() {
        currentPlayer = players.get(++roundCount % players.size());
    }

    public boolean isExpansionEnable(ExpansionEnum expansion) {
        return expansions.get(expansion);
    }


    public Board getBoard() {
        return board;
    }

    public ArrayList<Player> getPlayersList() {
        return players;
    }
}
