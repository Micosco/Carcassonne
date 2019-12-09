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
    private boolean modifying;

    public BoardPanel() {
        setPreferredSize(new Dimension(1040, 720));
        setLayout(null);
        MouseAdapter mouseListener = new BoardMouseActionHandler();
        addMouseListener(mouseListener);
        addMouseListener(new TilePlaceListener());
        addMouseMotionListener(mouseListener);
        realTimeRefresh();
    }

    public void placeTile(int x, int y) {
        Board board = GameState.getCurrentGameState().getBoard();
        Tile newTile = board.getTileStack().draw();
        board.placeTile(x, y, newTile);

        TileComponent comp = new TileComponent(board.getLastPlaced());
        placedTile.add(comp);
        add(comp);
        comp.recalculatePosition();
    }

    private void realTimeRefresh() {
        Runnable refresh = () -> {
            while (true) {
                if (!modifying) {
                    for (var tile : placedTile) {
                        tile.repaint();
                    }
                    try {
                        Thread.sleep(15);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t = new Thread(refresh);
        t.start();
    }

    public void placeFirstTile() {
        TileComponent first = new TileComponent(GameState.getCurrentGameState().getBoard().get(0, 0));
        modifying = true;
        placedTile.add(first);
        modifying = false;
        add(first);
    }

    public int[] getPositionOnBoard(int x, int y) {
        double boardX = ((double) x - TileComponent.getReferencePositionX()) / TileComponent.DEFAULT_SIDE_LENGTH;
        double boardY = ((double) y - TileComponent.getReferencePositionY()) / TileComponent.DEFAULT_SIDE_LENGTH;
        int[] ints = {(int) Math.floor(boardX),
                (int) Math.floor(boardY)};
        return ints;
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


