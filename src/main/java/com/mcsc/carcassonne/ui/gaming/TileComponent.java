package com.mcsc.carcassonne.ui.gaming;

import com.mcsc.carcassonne.board.BoardPosition;
import com.mcsc.carcassonne.board.Tile;

import javax.swing.*;
import java.awt.*;

/**
 * @author White Wing
 */
public class TileComponent extends JLabel {
    private static double zoomRatio = 1;
    private static int referencePositionX = 520;
    private static int referencePositionY = 360;
    private Tile managedTile;
    private BoardPosition tilePosition;
    private Image image;
    public static final int DEFAULT_SIDE_LENGTH = 80;

    public TileComponent(BoardPosition position) {
        super();
        tilePosition = position;
        managedTile = position.getTile();
        image = new ImageIcon(getClass().getResource("/textures/tile/" + managedTile.getExpansion()
                + "/" + managedTile.getIdentifier() + ".jpg")).getImage();
        recalculatePosition();
    }

    public TileComponent() {}

    public void replaceTile(Tile tile) {
        managedTile = tile;
        image = new ImageIcon(getClass().getResource("/textures/tile/" + managedTile.getExpansion()
                + "/" + managedTile.getIdentifier() + ".jpg")).getImage();
        setIcon(new ImageIcon(image));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    /**
     * 移动镜头位置后重新计算元件位置
     */
    public void recalculatePosition() {
        int x = (int) (tilePosition.getX() * DEFAULT_SIDE_LENGTH * zoomRatio) + referencePositionX;
        int y = (int) (tilePosition.getY() * DEFAULT_SIDE_LENGTH * zoomRatio) + referencePositionY;
        int sideLength = (int) (DEFAULT_SIDE_LENGTH * zoomRatio);
        setBounds(x, y, sideLength, sideLength);
        setIcon(new ImageIcon(image));
    }

    public static void setReferencePosition(int x, int y) {
        referencePositionX = x;
        referencePositionY = y;
    }

    public static void setZoomRatio(double zoomRatio) {
        TileComponent.zoomRatio = zoomRatio;
    }

    public static double getZoomRatio() {
        return zoomRatio;
    }

    public static int getReferencePositionX() {
        return referencePositionX;
    }

    public static int getReferencePositionY() {
        return referencePositionY;
    }
}
