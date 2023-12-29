package com.l03gr06.sagabi.model.map.entities.interactables;

import com.l03gr06.sagabi.model.battlers.MonsterBattler;
import com.l03gr06.sagabi.model.map.entities.Entity;

@SuppressWarnings({"Immutable","JavaLangClash"})
public abstract class Interactable extends Entity {

    public Interactable(int x, int y) {
        super(x, y);
    }
    public abstract void onCollision();
    //returns true if thing should be erased
    public  boolean onMonsterDefeated(MonsterBattler battler, int monstersLeft)
    {
        return false;
    }
}
