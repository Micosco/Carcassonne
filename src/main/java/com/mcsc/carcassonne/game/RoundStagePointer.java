package com.mcsc.carcassonne.game;

public class RoundStagePointer {
    private RoundStage[] roundStages;
    private RoundStage  currentStage;
    private static RoundStagePointer sharedPointer = new RoundStagePointer();

    private RoundStagePointer(){
        this.roundStages = RoundStage.getDefaultRoundStages();
        this.currentStage = this.roundStages[0];
    }

    public static RoundStagePointer getDefaultStagePointer() {
        return sharedPointer;
    }

    public void nextStage() {
        currentStage = roundStages[(currentStage.ordinal() + 1) % roundStages.length];
        if (currentStage == RoundStage.PLACE_TILE) GameState.getCurrentGameState().nextPlayer();
        System.out.println("Stage:" + currentStage);
    }

    public void nextRound() {
        currentStage = roundStages[0];
        GameState.getCurrentGameState().nextPlayer();
    }

    public RoundStage getCurrentStage() {
        return currentStage;
    }
}
