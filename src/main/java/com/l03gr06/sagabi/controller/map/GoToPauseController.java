package com.l03gr06.sagabi.controller.map;

import com.l03gr06.sagabi.Game;
import com.l03gr06.sagabi.gui.Action;
import com.l03gr06.sagabi.model.map.Room;
import com.l03gr06.sagabi.states.PauseMenuState;
import com.l03gr06.sagabi.states.State;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class GoToPauseController extends MapController{
    @Override
    public  void step(Game game, State<Room> state, Action action, float delta)
    {
        if (action==Action.SELECT)
        {
            game.setState(new PauseMenuState(state.getModel(),game));
        }
    }
}
