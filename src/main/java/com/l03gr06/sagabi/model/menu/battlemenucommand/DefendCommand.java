package com.l03gr06.sagabi.model.menu.battlemenucommand;

import com.l03gr06.sagabi.Game;
import com.l03gr06.sagabi.model.battle.substates.HeroBaseState;
import com.l03gr06.sagabi.model.battle.substates.ShowPlayerDefenceMessageState;
import com.l03gr06.sagabi.states.BattleState;
@SuppressWarnings({"Immutable","JavaLangClash"})


public class DefendCommand extends BattleMenuCommand{
    private final HeroBaseState owner;

    public DefendCommand(BattleState state,HeroBaseState owner,Game game)
    {
        super(state);
        this.owner= owner;this.game=game;
    }
    private Game game;
    @Override
    public void onClick() {
        owner.setNextState(new ShowPlayerDefenceMessageState(game));
        state.moveToNextState();
    }
}
