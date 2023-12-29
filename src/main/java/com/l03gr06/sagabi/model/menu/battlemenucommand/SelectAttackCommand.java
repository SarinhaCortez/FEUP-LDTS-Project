package com.l03gr06.sagabi.model.menu.battlemenucommand;

import com.l03gr06.sagabi.factories.MainMenuFactory;
import com.l03gr06.sagabi.model.battle.substates.AttackSelectState;
import com.l03gr06.sagabi.model.battlers.Attack;
import com.l03gr06.sagabi.states.BattleState;

@SuppressWarnings({"Immutable","JavaLangClash"})

public class SelectAttackCommand extends BattleMenuCommand{
    @Override
    public void onClick() {
        owner.setAttack(attack);
        state.moveToNextState();
    }
    private Attack attack;
    private  AttackSelectState owner;
    public SelectAttackCommand(Attack attack, AttackSelectState owner, BattleState state)
    {
        super(state);
        this.attack= attack;
        this.owner=owner;
    }
}
