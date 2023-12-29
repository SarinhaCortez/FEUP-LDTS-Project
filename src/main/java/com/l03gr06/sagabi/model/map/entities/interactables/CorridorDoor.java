package com.l03gr06.sagabi.model.map.entities.interactables;

import com.l03gr06.sagabi.Game;
import com.l03gr06.sagabi.states.MapState;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class CorridorDoor extends Door{

    public CorridorDoor(int x, int y, boolean doorIsOpen,Game game){super(x,y,null,doorIsOpen,game);}
    
    @Override
    public void onCollision()
    {
        if (isOpen()) {
            game.setState(new MapState(game.getRoomFactory().createCorridor()));
        }
    }
}
