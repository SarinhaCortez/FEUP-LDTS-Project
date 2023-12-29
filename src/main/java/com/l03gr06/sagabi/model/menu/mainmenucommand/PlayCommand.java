package com.l03gr06.sagabi.model.menu.mainmenucommand;

import com.l03gr06.sagabi.Game;
import com.l03gr06.sagabi.factories.BasicRoomFactory;
import com.l03gr06.sagabi.model.map.Room;
import com.l03gr06.sagabi.states.MapState;

@SuppressWarnings({"Immutable","JavaLangClash"})

public class PlayCommand extends MainMenuCommand{
    public PlayCommand(Game game)
    {
this.game=game;
    }
private Game game;
    @Override
    public void onClick() {
        game.setState(new MapState(game.getRoomFactory().createCorridor()));
    }
}
