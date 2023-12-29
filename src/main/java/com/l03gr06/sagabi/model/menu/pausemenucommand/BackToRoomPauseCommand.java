package com.l03gr06.sagabi.model.menu.pausemenucommand;

import com.l03gr06.sagabi.Game;
import com.l03gr06.sagabi.model.map.Room;
import com.l03gr06.sagabi.model.menu.MenuOptionCommand;
import com.l03gr06.sagabi.states.MapState;

@SuppressWarnings({"Immutable","JavaLangClash"})

public class BackToRoomPauseCommand implements MenuOptionCommand {
    Room room;
    private Game game;
    public BackToRoomPauseCommand(Room room,Game game)
    {
        this.room=room;this.game=game;
    }

    @Override
    public void onClick()
    {
        game.setState(new MapState(room));
    }
}
