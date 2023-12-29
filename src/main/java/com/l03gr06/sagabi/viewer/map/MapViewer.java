package com.l03gr06.sagabi.viewer.map;
import com.l03gr06.sagabi.gui.GUI;
import com.l03gr06.sagabi.model.map.Room;
import com.l03gr06.sagabi.viewer.Viewer;
import com.l03gr06.sagabi.states.State;

@SuppressWarnings({"Immutable","JavaLangClash"})
public abstract class MapViewer implements Viewer<Room> {
    @Override
    public abstract void draw(GUI gui, State<Room> room);
}
