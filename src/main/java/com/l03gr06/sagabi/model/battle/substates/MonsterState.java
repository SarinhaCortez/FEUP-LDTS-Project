package com.l03gr06.sagabi.model.battle.substates;

import com.l03gr06.sagabi.Game;
import com.l03gr06.sagabi.model.battle.Battle;
import com.l03gr06.sagabi.model.battle.damageCalculator.DamageCalculator;
import com.l03gr06.sagabi.model.battlers.Attack;
import com.l03gr06.sagabi.model.menu.Menu;
import com.l03gr06.sagabi.model.menu.MenuOption;
import com.l03gr06.sagabi.model.menu.battlemenucommand.WaitForClickCommand;
import com.l03gr06.sagabi.states.BattleState;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"Immutable","JavaLangClash","ObjectToString"})
public class MonsterState implements BattleSubstate {
    private Game game;
    public MonsterState(Game game)
    {
this.game=game;
    }
    @Override
    public void init(BattleState state)
    {
        DamageCalculator dc=state.getModel().getDamageCalculator();
        dc.onTurnBegin(state.getModel().getEnemy());
        Attack attack= state.getModel().getMonsterAI().chooseAttack(state.getModel().getEnemy(),state.getModel().getPlayer());
        Menu menu=state.getModel().getMenu();

        List<MenuOption> options= new ArrayList<>();
        options.add(new MenuOption("",new WaitForClickCommand(state)));
        menu.setOptions(options);
        if (attack!=null){
        menu.setText(dc.useAttack(attack,state.getModel().getEnemy(),state.getModel().getPlayer()));
        }else
        {
            state.getModel().getEnemy().startDefending();
            menu.setText(state.getModel().getEnemy().getName()+" is defending!");
        }
    }
    @Override
    public BattleSubstate getNextSubstate(Battle battle)
    {
        if (battle.getPlayer().isDead())
        {
            return new LooseState(game);
        }
        else if(battle.getEnemy().isTired())
        {
            return new WinState(game);
        }
        return new HeroBaseState(true,game);
    }
}
