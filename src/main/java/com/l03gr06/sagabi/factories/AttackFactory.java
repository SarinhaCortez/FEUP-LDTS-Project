package com.l03gr06.sagabi.factories;

import com.l03gr06.sagabi.model.battlers.Attack;
import com.l03gr06.sagabi.model.battlers.MonsterElement;

import java.util.List;

@SuppressWarnings({"Immutable","JavaLangClash"})
public interface AttackFactory {
    public Attack getAttack(String name);
    public List<Attack> getXRandomAttacks(int x, MonsterElement bias);
    public Attack getRandomAttack();

}
