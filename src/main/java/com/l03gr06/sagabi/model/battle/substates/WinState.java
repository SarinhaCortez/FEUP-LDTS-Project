package com.l03gr06.sagabi.model.battle.substates;

import com.l03gr06.sagabi.Game;
import com.l03gr06.sagabi.model.battle.Battle;
import com.l03gr06.sagabi.model.menu.MenuOption;
import com.l03gr06.sagabi.model.menu.battlemenucommand.LooseAndGoToGameOverCommand;
import com.l03gr06.sagabi.model.menu.battlemenucommand.WinAndBackToRoomCommand;
import com.l03gr06.sagabi.states.BattleState;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class WinState implements  BattleSubstate{
 private Game game;
public WinState(Game game){this.game=game;}
    @Override
    public void init(BattleState state) {
        state.getModel().getMenu().setText("Sagabi won!");
        List<MenuOption> options= new ArrayList<>();
        options.add(new MenuOption("",new WinAndBackToRoomCommand(state,game)));
        state.getModel().getMenu().setOptions(options);

    }

    @Override
    public BattleSubstate getNextSubstate(Battle battle)
    {

        return this;
    }
}