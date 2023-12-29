package com.l03gr06.sagabi.model.menu.battlemenucommand;

import com.l03gr06.sagabi.model.battle.substates.AttackSelectState;
import com.l03gr06.sagabi.states.BattleState;

@SuppressWarnings({"Immutable","JavaLangClash"})

public class GetOutOfWantToAttackMenuCommand extends BattleMenuCommand{
    AttackSelectState owner;
    public GetOutOfWantToAttackMenuCommand(BattleState state,AttackSelectState owner)
    {
        super(state);
        this.owner= owner;
    }
    @Override
    public void onClick() {
        owner.setAttack(null);
        state.moveToNextState();
    }
}
