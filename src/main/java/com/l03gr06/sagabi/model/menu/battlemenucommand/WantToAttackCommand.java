package com.l03gr06.sagabi.model.menu.battlemenucommand;

import com.l03gr06.sagabi.Game;
import com.l03gr06.sagabi.model.battle.substates.AttackSelectState;
import com.l03gr06.sagabi.model.battle.substates.HeroBaseState;
import com.l03gr06.sagabi.states.BattleState;

@SuppressWarnings({"Immutable","JavaLangClash"})

public class WantToAttackCommand extends BattleMenuCommand{
    private Game game;

    @Override
    public void onClick() {
        owner.setNextState(new AttackSelectState(game));
        state.moveToNextState();

    }
    HeroBaseState owner;

    public WantToAttackCommand(BattleState state, HeroBaseState owner,Game game){
        super(state);
        this.owner=owner;
        this.game=game;
    }
}
