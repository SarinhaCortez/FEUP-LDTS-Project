package com.l03gr06.sagabi.model.battle.monsterAI;

import com.l03gr06.sagabi.model.battlers.Attack;
import com.l03gr06.sagabi.model.battlers.Battler;

@SuppressWarnings({"Immutable","JavaLangClash"})
public interface MonsterAI {
    public Attack chooseAttack(Battler user, Battler target);
}
