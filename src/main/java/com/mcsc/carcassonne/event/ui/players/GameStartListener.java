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
        GameState.initialNewGame();
        MainFrame.getMainWindow().switchPanel("Gaming");
        GamingPanel panel = GamingPanel.getPanel().initial();
        GameState.getCurrentGameState().setGamingPanel(panel);
    }
}
