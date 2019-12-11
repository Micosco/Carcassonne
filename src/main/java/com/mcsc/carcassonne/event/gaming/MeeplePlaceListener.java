package com.mcsc.carcassonne.event.gaming;


import com.mcsc.carcassonne.board.Board;
import com.mcsc.carcassonne.board.EdgeDirectionEnum;
import com.mcsc.carcassonne.board.Meeple;
import com.mcsc.carcassonne.game.GameState;
import com.mcsc.carcassonne.game.Player;
import com.mcsc.carcassonne.game.RoundStage;
import com.mcsc.carcassonne.game.RoundStagePointer;
import com.mcsc.carcassonne.ui.gaming.MeepleInfo;
import com.mcsc.carcassonne.ui.gaming.TileComponent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

public class MeeplePlaceListener extends MouseAdapter {

    /**
     * 在鼠标点击区域放置米宝
     *
     * @param e 要处理的事件
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (RoundStagePointer.getDefaultStagePointer().getCurrentStage() == RoundStage.PLACE_MEEPLE) {
            TileComponent source = (TileComponent) e.getSource();
            Board board = GameState.getCurrentGameState().getBoard();
            int x = e.getX();
            int y = e.getY();
            board.getLastPlaced().getTile().placeMeeple(getDirection(x, y));
            GameState.getCurrentGameState().startSummaryScore();
        }
    }

    /**
     * 根据在板块上点击的位置计算出对应区域
     *
     * @param x 横坐标
     * @param y 纵坐标
     * @return 点击的区域
     */
    private EdgeDirectionEnum getDirection(int x, int y) {
        if (x >= y && x < -y + 80 && y <= 20) {
            return EdgeDirectionEnum.N;
        } else if (x >= y && x >= -y + 80 && x >= 60) {
            return EdgeDirectionEnum.E;
        } else if (x < y && x >= -y + 80 && y >= 60) {
            return EdgeDirectionEnum.S;
        } else if (x < y && x < -y + 80 && x <= 20) {
            return EdgeDirectionEnum.W;
        } else {
            return EdgeDirectionEnum.END;
        }
    }
}
