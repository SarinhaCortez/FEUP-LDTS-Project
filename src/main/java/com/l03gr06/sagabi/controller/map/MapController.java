package com.l03gr06.sagabi.controller.map;

import com.l03gr06.sagabi.Game;
import com.l03gr06.sagabi.gui.Action;
import com.l03gr06.sagabi.model.map.Room;
import com.l03gr06.sagabi.states.State;
import com.l03gr06.sagabi.controller.Controller;


@SuppressWarnings({"Immutable","JavaLangClash"})
public abstract class MapController implements Controller<Room> {
@Override
    public abstract void step(Game game, State<Room> state, Action action, float delta);
}
