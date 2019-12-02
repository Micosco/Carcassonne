package com.mcsc.carcassonne.board;

import com.mcsc.carcassonne.game.Player;

/**
 *
 */

public class Meeple {
    private Player owner;
    private int scoreMagnification;

    public Meeple(Player owner) {
        this.owner = owner;
        scoreMagnification = 1;
    }

    public Player getOwner() {
        return owner;
    }

    public int getScoreMagnification() {
        return scoreMagnification;
    }
}
