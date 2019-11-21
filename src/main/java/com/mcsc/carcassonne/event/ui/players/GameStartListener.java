package com.mcsc.carcassonne.event.ui.players;

import com.mcsc.carcassonne.game.GameState;
import com.mcsc.carcassonne.ui.MainFrame;
import com.mcsc.carcassonne.ui.gaming.GamingPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author WhiteWing
 */
public class GameStartListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO 补全游戏数据初始化
        GameState.initialNewGame();
        MainFrame.getMainWindow().switchPanel("Gaming");
        GamingPanel.getPanel().initial();
    }
}
