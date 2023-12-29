package com.l03gr06.sagabi.model.battle.substates;

import com.l03gr06.sagabi.Game;
import com.l03gr06.sagabi.model.battle.Battle;
import com.l03gr06.sagabi.model.menu.Menu;
import com.l03gr06.sagabi.model.menu.MenuOption;
import com.l03gr06.sagabi.model.menu.battlemenucommand.DefendCommand;
import com.l03gr06.sagabi.model.menu.battlemenucommand.RestOptionCommand;
import com.l03gr06.sagabi.model.menu.battlemenucommand.WantToAttackCommand;
import com.l03gr06.sagabi.states.BattleState;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class HeroBaseState implements BattleSubstate {
    BattleSubstate nextState=null;

    boolean callOnTurnStart=true;

    public HeroBaseState(boolean callOnTurnStart,Game game)
    {
        this.callOnTurnStart=callOnTurnStart;
        this.game=game;
    }

    private Game game;
    @Override
    public void init(BattleState state)
    {
        if (callOnTurnStart)
        {
             state.getModel().getDamageCalculator().onTurnBegin(  state.getModel().getPlayer());
        }

        Menu menu=state.getModel().getMenu();
        List<MenuOption> options= new ArrayList<>();
        options.add(new MenuOption("- Attack",new WantToAttackCommand(state,this,game)));
        options.add(new MenuOption("- Defend",new DefendCommand(state,this,game)));
        options.add(new MenuOption("- Rest",new RestOptionCommand(state,this,game)));
        menu.setOptions(options);
        menu.setText("What will Sagabi do?");
    }
    @Override
    public BattleSubstate getNextSubstate(Battle battle)
    {
        return nextState;
    }
    public void setNextState(BattleSubstate state)

    {
        nextState=state;
    }
}