package com.mcsc.carcassonne.game;

public enum RoundStage {
    //板块放置阶段
    PLACE_TILE,
    //米宝放置阶段
    PLACE_MEEPLE,
    //分数结算阶段
    SCORE_SUMMARY,
    //火龙移动阶段    ——龙与公主扩展包
    DRAGON_MOVE;


    public static RoundStage[] getDefaultRoundStages() {
        RoundStage[] stages = new RoundStage[3];
        stages[0] = PLACE_TILE;
        stages[1] = PLACE_MEEPLE;
        stages[2] = SCORE_SUMMARY;
        return stages;
    }
}
