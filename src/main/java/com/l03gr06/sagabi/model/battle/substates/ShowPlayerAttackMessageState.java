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

@SuppressWarnings({"Immutable","JavaLangClash"})

public class ShowPlayerAttackMessageState implements BattleSubstate {
    public ShowPlayerAttackMessageState(Attack attack,Game game)
    {

        this.game=game;
        this.attack=attack;
    }
    private final Attack attack;
    public Attack getAttack() {
        return attack;
    }
    private final Game game;

    @Override
    public void init(BattleState state)
    {
        DamageCalculator dc=state.getModel().getDamageCalculator();
        Menu menu=state.getModel().getMenu();

        List<MenuOption> options= new ArrayList<>();
        options.add(new MenuOption("",new WaitForClickCommand(state)));
        menu.setOptions(options);
        menu.setText(dc.useAttack(attack,state.getModel().getPlayer(),state.getModel().getEnemy()));

    }
    @Override
    public BattleSubstate getNextSubstate(Battle battle)
    {
        if (battle.getEnemy().isDead())
        {
            return new WinState(game);
        }

        return new MonsterState(game);
    }
}