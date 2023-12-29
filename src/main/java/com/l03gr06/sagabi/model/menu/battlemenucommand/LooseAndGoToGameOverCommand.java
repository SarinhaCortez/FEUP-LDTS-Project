package com.l03gr06.sagabi.model.menu.battlemenucommand;

import com.l03gr06.sagabi.Game;
import com.l03gr06.sagabi.states.BattleState;
import com.l03gr06.sagabi.states.GameOverState;
import com.l03gr06.sagabi.states.MapState;

@SuppressWarnings({"Immutable","JavaLangClash"})

public class LooseAndGoToGameOverCommand extends BattleMenuCommand {
    @Override
    public void onClick()
    {
       game.setState(new GameOverState(Game.getInstance().getMenuFactory().createGameOverMessage()));
    }
    private Game game ;
    public LooseAndGoToGameOverCommand(BattleState state,Game game)
    {
        super(state);this.game=game;
    }
}

