package com.l03gr06.sagabi.factories;

import com.l03gr06.sagabi.model.battlers.Attack;

@SuppressWarnings({"Immutable","JavaLangClash"})
public interface LevelUpAttackLearner {
    public Attack getAttackForLevel(int i);
}
