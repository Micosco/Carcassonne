package com.mcsc.carcassonne.game;


import com.mcsc.carcassonne.board.Board;
import com.mcsc.carcassonne.board.TileStack;
import com.mcsc.carcassonne.ui.gaming.GamingPanel;
import com.mcsc.carcassonne.ui.players.PlayerInfo;
import com.mcsc.carcassonne.ui.players.PlayerSettingPanel;

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
    private GamingPanel gamingPanel;
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
        newGame.initialPlayerList(PlayerSettingPanel.getPanel().getEnabledPlayersInfo());
        return newGame;
    }

    public void initialPlayerList(ArrayList<PlayerInfo> players) {
        for (var player : players) {
            this.players.add(new Player(player.getID(), player.getColorState().getColor()));
        }
        currentPlayer = this.players.get(0);
    }

    /**
     * 在分数结算阶段进行分数结算
     */
    public void startSummaryScore() {
        if (RoundStagePointer.getDefaultStagePointer().getCurrentStage() == RoundStage.SCORE_SUMMARY) {
            Board board = GameState.getCurrentGameState().getBoard();
            Map<Player, Integer> scores = board.settleScore();
            for (var player : GameState.getCurrentGameState().getPlayersList()) {
                player.addScore(scores.getOrDefault(player, 0));
            }
            gamingPanel.repaint();
        }

    }

    public GamingPanel getGamingPanel() {
        return gamingPanel;
    }

    public void setGamingPanel(GamingPanel gamingPanel) {
        this.gamingPanel = gamingPanel;
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
