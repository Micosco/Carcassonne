package com.mcsc.carcassonne.ui.gaming;

import com.mcsc.carcassonne.board.BoardPosition;
import com.mcsc.carcassonne.board.EdgeDirectionEnum;
import com.mcsc.carcassonne.board.Meeple;
import com.mcsc.carcassonne.board.Tile;
import com.mcsc.carcassonne.event.gaming.MeeplePlaceListener;

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
                + "/" + managedTile.getIdentifier() + "/" + "r0.jpg")).getImage();
        recalculatePosition();
        addMouseListener(new MeeplePlaceListener());
    }

    public TileComponent() {
    }

    public void replaceTile(Tile tile) {
        managedTile = tile;
        // image = new ImageIcon(getClass().getResource("/textures/tile/" + managedTile.getExpansion()
        //        + "/" + managedTile.getIdentifier() + "/r0.jpg")).getImage();
        setIcon(new ImageIcon(getClass().getResource(getImagePath())));
    }

    private int getXOnTile(EdgeDirectionEnum position) {
        switch (position) {
            case E:
                return 65;
            case W:
                return 0;
            default:
                return 33;
        }
    }

    private int getYOnTile(EdgeDirectionEnum position) {
        switch (position) {
            case N:
                return 0;
            case S:
                return 65;
            default:
                return 33;
        }
    }

    private MeepleInfo getMeepleIcon() {
        Meeple meeple = managedTile.getMeeple();
        if (meeple != null)
           return new MeepleInfo(meeple.getBelongTo().getColor(), managedTile.getMeeplePosition());
        else
            return new MeepleInfo();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        MeepleInfo meeple = getMeepleIcon();
        if (meeple.isEffective())
            g2.drawImage(meeple.getImage().getImage(), getXOnTile(meeple.getPosition()),
                    getYOnTile(meeple.getPosition()), null);
    }

    private String getImagePath() {
        return "/textures/tile/" + managedTile.getExpansion() + "/" + managedTile.getIdentifier() + "/r" + managedTile.getRotation() % 8 / 2 + ".jpg";
    }

    /**
     * 移动镜头位置后重新计算元件位置
     */
    public void recalculatePosition() {
        int x = (int) (tilePosition.getX() * DEFAULT_SIDE_LENGTH * zoomRatio) + referencePositionX;
        int y = (int) (tilePosition.getY() * DEFAULT_SIDE_LENGTH * zoomRatio) + referencePositionY;
        int sideLength = (int) (DEFAULT_SIDE_LENGTH * zoomRatio);
        setBounds(x, y, sideLength, sideLength);
        setIcon(new ImageIcon(getClass().getResource(getImagePath())));
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
