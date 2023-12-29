package com.l03gr06.sagabi.states;

import com.l03gr06.sagabi.Game;
import com.l03gr06.sagabi.model.battle.Battle;
import com.l03gr06.sagabi.model.battle.substates.BattleSubstate;
import com.l03gr06.sagabi.model.battle.substates.HeroBaseState;
import com.l03gr06.sagabi.model.battle.substates.MonsterState;


@SuppressWarnings({"Immutable","JavaLangClash"})
public class BaseBattleState extends BattleState{

    public BaseBattleState(Battle model,Game  game)
    {
        super(model,game);
    }
    @Override
    protected BattleSubstate getInitialSubstate()
    {
        Battle battle=getModel();
        if (battle.getEnemy().getSpeed()>battle.getPlayer().getSpeed())
        {
            return new MonsterState(game);
        }else
        {
            return new HeroBaseState(true,game);
        }
    }
}
