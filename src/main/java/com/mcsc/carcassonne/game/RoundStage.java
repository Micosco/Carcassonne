package com.mcsc.carcassonne.game;

public enum RoundStage {
    PLACE_TILE,
    PLACE_MEEPLE,
    SCORE_SUMMARY,
    DRAGON_MOVE;


    public static RoundStage[] getDefaultRoundStages() {
        RoundStage[] stages = new RoundStage[3];
        stages[0] = PLACE_TILE;
        stages[1] = PLACE_MEEPLE;
        stages[2] = SCORE_SUMMARY;
        return stages;
    }
}
