package com.mcsc.carcassonne.ui.gaming;

import com.mcsc.carcassonne.game.GameState;
import com.mcsc.carcassonne.game.RoundStagePointer;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * 游戏面板的子面板，用于显示玩家信息和游戏信息
 * <p>
 * 玩家信息：玩家昵称， 玩家得分， 剩余米宝， 标记进行回合的玩家
 * <p>
 * 游戏信息：显示要放置的板块
 */
public class GamingStatsPanel extends JPanel {
    public GamingStatsPanel() {
        setPreferredSize(new Dimension(240, 640));
        setLayout(new MigLayout("wrap 3"));
        for (var player : GameState.getCurrentGameState().getPlayersList()) {
            add(new PlayerInfo(player), "span 3 1");
        }

        TileComponent previewTile = new TileComponent();
        previewTile.setPreferredSize(new Dimension(80, 80));
        add(previewTile);

        JButton comp = new JButton("跳过放置米宝");
        comp.addActionListener(e -> {
            RoundStagePointer.getDefaultStagePointer().nextStage();
            GameState.getCurrentGameState().startSummaryScore();
        });
        add(comp, "cell 0 7 3 1");

        Runnable resetPreviewImage = () -> {
            while (true) {
                previewTile.replaceTile(GameState.getCurrentGameState().getBoard().getTileStack().top());
            }
        };
        Thread t = new Thread(resetPreviewImage);
        t.start();
    }
}