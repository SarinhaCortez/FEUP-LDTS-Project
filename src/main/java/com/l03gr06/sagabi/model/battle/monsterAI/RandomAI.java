package com.l03gr06.sagabi.model.battle.monsterAI;

import com.l03gr06.sagabi.model.battlers.Attack;
import com.l03gr06.sagabi.model.battlers.Battler;

import java.util.Random;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class RandomAI implements MonsterAI {
    Random rand = new Random();

    @Override
    public Attack chooseAttack(Battler user, Battler target) {
        if (getRandomFloat() < 100.0 / (user.getAttacks().size() + 1.0)) {
            return null; // means it will defend
        }
        return user.getAttacks().get(getRandomInt(user.getAttacks().size()));
    }

    // These methods are protected so they can be overridden in tests
    protected float getRandomFloat() {
        return rand.nextFloat() % 100.0f;
    }

    protected int getRandomInt(int bound) {
        return rand.nextInt(bound);
    }
}