package com.mcsc.carcassonne.board;

import com.mcsc.carcassonne.game.Player;

/**
 *
 */

public class Meeple {
    private int weight;
    private Player belongTo;

    public Meeple(Player belongTo) {
        this.belongTo = belongTo;
        this.weight = 1;
    }

    public int getWeight() {
        return weight;
    }

    public Player getBelongTo() {
        return belongTo;
    }
}
