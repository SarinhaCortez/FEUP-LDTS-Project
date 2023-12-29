package com.l03gr06.sagabi.model.map.entities.interactables;

import com.l03gr06.sagabi.Game;
import com.l03gr06.sagabi.states.MapState;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class HealRoomDoor extends Door {
    public HealRoomDoor(int x, int y,Game game){super(x,y,null,true,game);}
    public HealRoomDoor(int x, int y, boolean isOpen,Game game){super(x,y,null,isOpen,game);}
    @Override
    public void onCollision()
    {
        if (isOpen()) {
            game.setState(new MapState(game.getRoomFactory().createHealRoom()));
        }
    }
}
