package com.l03gr06.sagabi.model.menu.battlemenucommand;

import com.l03gr06.sagabi.Game;
import com.l03gr06.sagabi.model.battlers.PlayerBattler;
import com.l03gr06.sagabi.model.map.Room;
import com.l03gr06.sagabi.states.BattleState;
import com.l03gr06.sagabi.states.MapState;

@SuppressWarnings({"Immutable","JavaLangClash"})

public class WinAndBackToRoomCommand extends BattleMenuCommand {
   private Game game;

    @Override
    public void onClick() //TODO: if player will win exp. then, it's going to be here...
    {
        state.getModel().getPlayer().onEnemyDefeated(state.getModel().getEnemy());
        Room room=state.getModel().getRoom();
        room.removeMonster(state.getModel().getEnemy());
        game.setState(new MapState(room));
    }
    public WinAndBackToRoomCommand(BattleState state,Game game)
    {
        super(state);this.game=game;
    }
}


