package com.l03gr06.sagabi.factories;

import com.l03gr06.sagabi.Game;
import com.l03gr06.sagabi.model.battlers.Attack;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class SimpleLevelUpAttackLearner implements  LevelUpAttackLearner{
    private Game game;
    public SimpleLevelUpAttackLearner (Game game)
    {
        this.game=game;
    }
    @Override
    public Attack getAttackForLevel(int i)
    {
        if (i%5==0)
        {
            return game.getAttackFactory().getRandomAttack();
        }
        return null;
    }

}
