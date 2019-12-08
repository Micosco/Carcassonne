package com.mcsc.carcassonne.event.gaming;

import com.mcsc.carcassonne.board.Board;
import com.mcsc.carcassonne.game.GameState;
import com.mcsc.carcassonne.game.RoundStage;
import com.mcsc.carcassonne.game.RoundStagePointer;
import com.mcsc.carcassonne.ui.gaming.BoardPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TilePlaceListener extends MouseAdapter {

    /**
     * 在鼠标点击区域放置板块
     *
     * @param e 要处理的事件
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (RoundStagePointer.getDefaultStagePointer().getCurrentStage() == RoundStage.PLACE_TILE) {
            BoardPanel source = (BoardPanel) e.getSource();
            int x = source.getPositionOnBoard(e.getX(), e.getY())[0];
            int y = source.getPositionOnBoard(e.getX(), e.getY())[1];
            source.placeTile(x, y);
        }
    }
}
