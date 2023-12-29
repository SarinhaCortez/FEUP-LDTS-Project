package com.l03gr06.sagabi.model.battle.damageCalculator;

import com.l03gr06.sagabi.model.battlers.Attack;
import com.l03gr06.sagabi.model.battlers.Battler;

@SuppressWarnings({"Immutable","JavaLangClash"})
public interface DamageCalculator {
    //returns a string with what happened
    public String useAttack(Attack attack, Battler user, Battler target);

    public void onTurnBegin(Battler battler);

    public void onRest(Battler battler);
}
