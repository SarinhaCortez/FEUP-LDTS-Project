package com.l03gr06.sagabi.model.battle.substates;

import com.l03gr06.sagabi.Game;
import com.l03gr06.sagabi.model.battle.Battle;
import com.l03gr06.sagabi.model.menu.Menu;
import com.l03gr06.sagabi.model.menu.MenuOption;
import com.l03gr06.sagabi.model.menu.battlemenucommand.WaitForClickCommand;
import com.l03gr06.sagabi.states.BattleState;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class ShowPlayerRestMessageState implements BattleSubstate {
    
    @Override
    public void init(BattleState state) {
    Menu menu = state.getModel().getMenu();


        List<MenuOption> options= new ArrayList<>();
        options.add(new MenuOption("",new WaitForClickCommand(state)));
        menu.setOptions(options);
        menu.setText("Sagabi is resting!");
        state.getModel().getDamageCalculator().onRest(state.getModel().getPlayer());
    }
    private final Game game;
public ShowPlayerRestMessageState(Game game){this.game=game;}
    @Override
    public BattleSubstate getNextSubstate(Battle battle) {
        return new MonsterState(game);
    }
}