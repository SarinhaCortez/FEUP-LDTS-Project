package com.l03gr06.sagabi.model.menu.battlemenucommand;

import com.l03gr06.sagabi.Game;
import com.l03gr06.sagabi.model.battle.substates.HeroBaseState;
import com.l03gr06.sagabi.model.battle.substates.ShowPlayerRestMessageState;
import com.l03gr06.sagabi.states.BattleState;
@SuppressWarnings({"Immutable","JavaLangClash"})


public class RestOptionCommand extends BattleMenuCommand{
    private Game game;

    @Override
    public void onClick() {
        owner.setNextState(new ShowPlayerRestMessageState(game));
        state.moveToNextState();
    }
    private final HeroBaseState owner;
    public RestOptionCommand(BattleState state, HeroBaseState owner, Game game)
    {
        super(state);
        this.owner=owner;
        this.game=game;
    }
}
