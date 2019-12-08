package com.mcsc.carcassonne.board;

public enum DirectionEnum {
    //上
    UP(new int[]{0, 1}),
    //右
    RIGHT(new int[]{1, 0}),
    //下
    DOWN(new int[]{0, -1}),
    //左
    LEFT(new int[]{-1, 0});

    DirectionEnum(int[] ints) {

    }
}
