package com.l03gr06.sagabi.viewer.map;

import com.l03gr06.sagabi.gui.GUI;

import java.util.Map;

import com.l03gr06.sagabi.model.map.Room;
import com.l03gr06.sagabi.states.State;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class PlayerViewer extends MapViewer {
    @Override
    public void draw(GUI gui, State<Room> room) {
        gui.drawPlayer(room.getModel().getPlayer().getPosition().getX(), room.getModel().getPlayer().getPosition().getY());
    }
}
