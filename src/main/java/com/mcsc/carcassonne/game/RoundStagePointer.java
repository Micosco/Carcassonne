package com.mcsc.carcassonne.game;

public class RoundStagePointer {
    private RoundStage[] roundStages;
    private RoundStage  currentStage;
    public static RoundStagePointer sharedPointer;

    private RoundStagePointer(){}

    public static RoundStagePointer getDefaultStagePointer() {
        if (sharedPointer != null) {
            return sharedPointer;
        }
        sharedPointer = new RoundStagePointer();
        sharedPointer.roundStages = RoundStage.getDefaultRoundStages();
        sharedPointer.currentStage = sharedPointer.roundStages[0];
        return sharedPointer;
    }

    public void nextStage() {
        currentStage = roundStages[(currentStage.ordinal() + 1) % roundStages.length];
    }

    public RoundStage getCurrentStage() {
        return currentStage;
    }
}
