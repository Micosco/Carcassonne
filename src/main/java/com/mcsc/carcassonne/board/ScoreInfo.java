package com.mcsc.carcassonne.board;

import com.mcsc.carcassonne.game.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * 对一次分数结算结果的包装，包含得分，各玩家米宝数
 */
public class ScoreInfo {
    private int score;
    private boolean noScore;
    private Map<Player, Integer> meeplesCount = new HashMap<>();

    public ScoreInfo() {
        this.score = 0;
    }

    public ScoreInfo(int score) {
        this.score = score;
    }

    public void addScore(int score) {
        this.score += score;
    }

    /**
     * 将该次结算标记为无分数
     */
    public void setNoScore(boolean flag) {
        this.noScore = flag;
    }

    public boolean isNoScore() {
        return noScore;
    }

    public void addMeepleCount(Player player) {
        meeplesCount.put(player, meeplesCount.getOrDefault(player, 0) + 1);
    }

    public int getScore() {
        return noScore ? 0 : score;
    }

    public Map<Player, Integer> getMeeplesCount() {
        return meeplesCount;
    }
}
