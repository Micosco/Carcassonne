package com.mcsc.carcassonne.event.ui.players;

import com.mcsc.carcassonne.ui.players.PlayerInfo;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 玩家设置面板用于检测玩家启用复选框状态
 * @author WhiteWing
 */
public class PlayerEnableListener implements ChangeListener {

    @Override
    public void stateChanged(ChangeEvent e) {
        JCheckBox source = (JCheckBox) e.getSource();
        PlayerInfo info =(PlayerInfo) source.getParent();
        info.getColorState().setEnable(source.isSelected());
    }
}
