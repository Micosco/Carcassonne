package com.mcsc.carcassonne.ui.gaming;

import com.mcsc.carcassonne.board.Board;
import com.mcsc.carcassonne.board.BoardPosition;
import com.mcsc.carcassonne.board.Tile;
import com.mcsc.carcassonne.board.TileStack;
import com.mcsc.carcassonne.event.gaming.TilePlaceListener;
import com.mcsc.carcassonne.game.GameState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * @author White Wing
 */
public class BoardPanel extends JPanel {
    private ArrayList<TileComponent> placedTile = new ArrayList<>();

    public BoardPanel() {
        setPreferredSize(new Dimension(1040, 720));
        setLayout(null);
        MouseAdapter mouseListener = new BoardMouseActionHandler();
        addMouseListener(mouseListener);
        addMouseListener(new TilePlaceListener());
        addMouseMotionListener(mouseListener);
    }

    public void placeTile(int x, int y) {
        Board board = GameState.getCurrentGameState().getBoard();
        Tile newTile = board.getTileStack().draw();
        board.placeTile(x, y, newTile);

        TileComponent comp = new TileComponent(board.get(x, y));
        placedTile.add(comp);
        add(comp);
    }

    public void placeFirstTile() {
        TileComponent first = new TileComponent(GameState.getCurrentGameState().getBoard().get(100, 100));
        placedTile.add(first);
        add(first);
    }

    public int[] getPositionOnBoard(int x, int y) {
        return new int[]{(x - TileComponent.getReferencePositionX()) / TileComponent.DEFAULT_SIDE_LENGTH,
                (y - TileComponent.getReferencePositionY()) / TileComponent.DEFAULT_SIDE_LENGTH};
    }

    class BoardMouseActionHandler extends MouseAdapter {
        private int originX;
        private int originY;

        @Override
        public void mouseClicked(MouseEvent e) {
            //TODO 补全方法体
        }

        @Override
        public void mousePressed(MouseEvent e) {
            originX = e.getXOnScreen();
            originY = e.getYOnScreen();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            super.mouseDragged(e);
            //TODO 补全方法体

            //拖动时使板块跟随鼠标移动以实现镜头移动效果
            int x = TileComponent.getReferencePositionX();
            int y = TileComponent.getReferencePositionY();
            int xMoveLength = e.getXOnScreen() - originX;
            int yMoveLength = e.getYOnScreen() - originY;
            TileComponent.setReferencePosition(x + xMoveLength, y + yMoveLength);
            originX = e.getXOnScreen();
            originY = e.getYOnScreen();

            for (var tile : placedTile) {
                tile.recalculatePosition();
            }
        }
    }
}


