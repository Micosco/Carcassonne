package com.mcsc.carcassonne.game;


import java.awt.*;
import java.util.Map;
import java.util.Objects;

public class Player {
    private String id;
    private int score;
    private Color color;
    private int meepleCount;

    public Player(String id, Color color) {
        this.id = id;
        this.color = color;
        meepleCount = 8;
    }

    public String getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Player player = (Player) o;

        if (score != player.score) {
            return false;
        }
        return Objects.equals(id, player.id);
    }

    public int getMeepleCount() {
        return meepleCount;
    }

    public void placeMeeple() {
        meepleCount--;
    }

    public void retrieveMeeple() {
        meepleCount++;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + score;
        return result;
    }
}