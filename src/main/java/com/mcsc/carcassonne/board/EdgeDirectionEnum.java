package com.mcsc.carcassonne.board;

public enum EdgeDirectionEnum {
    //上边缘
    N(0),
    //右上角
    NE(1),
    //右边缘
    E(2),
    //右下角
    SE(3),
    //下边缘
    S(4),
    //左下角
    SW(5),
    //左边缘
    W(6),
    //左上角
    NW(7),
    //道路尽头
    END(8);

    EdgeDirectionEnum(int i) {
    }

    public EdgeDirectionEnum getOpposite() {
        return valueOf((ordinal() + 4) % 8);
    }

    public static EdgeDirectionEnum valueOf(int direction) {
        switch (direction) {
            case 0:
                return N;
            case 1:
                return NE;
            case 2:
                return E;
            case 3:
                return SE;
            case 4:
                return S;
            case 5:
                return SW;
            case 6:
                return W;
            case 7:
                return NW;
            default:
                return END;
        }
    }
}
