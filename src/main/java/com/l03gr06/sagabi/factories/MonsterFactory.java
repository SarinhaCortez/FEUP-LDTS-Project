package com.l03gr06.sagabi.factories;
import com.l03gr06.sagabi.model.battlers.MonsterBattler;
import com.l03gr06.sagabi.model.battlers.MonsterElement;

@SuppressWarnings({"Immutable","JavaLangClash"})
public interface MonsterFactory {

    public MonsterBattler createMonsterBattler(int level, MonsterElement element);
}