package com.mcsc.carcassonne.game;

public class RoundStagePointer {
    private RoundStage[] roundStages;
    private RoundStage currentStage;
    private static RoundStagePointer sharedPointer = new RoundStagePointer();

    private RoundStagePointer() {
        this.roundStages = RoundStage.getDefaultRoundStages();
        this.currentStage = this.roundStages[0];
    }

    public static RoundStagePointer getDefaultStagePointer() {
        return sharedPointer;
    }

    public void nextStage() {
        currentStage = roundStages[(currentStage.ordinal() + 1) % roundStages.length];
        if (currentStage == RoundStage.PLACE_TILE) {
            //当一个回合结束时进入下一个玩家回合
            GameState.getCurrentGameState().nextPlayer();
        }
        System.out.println("Stage:" + currentStage);
    }

    public void nextRound() {
        currentStage = roundStages[0];
        GameState.getCurrentGameState().nextPlayer();
    }

    public void reset() {
        currentStage = RoundStage.PLACE_TILE;
    }

    public RoundStage getCurrentStage() {
        return currentStage;
    }
}
