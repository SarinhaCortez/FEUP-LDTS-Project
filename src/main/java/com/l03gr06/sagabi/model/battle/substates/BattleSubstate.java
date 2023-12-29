package com.l03gr06.sagabi.model.battle.substates;

import com.l03gr06.sagabi.model.battle.Battle;
import com.l03gr06.sagabi.states.BattleState;

@SuppressWarnings({"Immutable","JavaLangClash"})
public interface BattleSubstate {
    public void init(BattleState state);
    public BattleSubstate getNextSubstate(Battle battle);
}
