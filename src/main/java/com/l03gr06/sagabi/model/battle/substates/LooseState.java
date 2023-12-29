package com.l03gr06.sagabi.model.battle.substates;

import com.l03gr06.sagabi.Game;
import com.l03gr06.sagabi.model.battle.Battle;
import com.l03gr06.sagabi.model.menu.Menu;
import com.l03gr06.sagabi.model.menu.MenuOption;
import com.l03gr06.sagabi.model.menu.battlemenucommand.LooseAndGoToGameOverCommand;
import com.l03gr06.sagabi.states.BattleState;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class LooseState implements  BattleSubstate{
    private Game game;
    public LooseState(Game game)
{
    this.game=game;
}
    @Override
    public void init(BattleState state) {
        state.getModel().getMenu().setText("Sagabi lost!");
        List<MenuOption> options= new ArrayList<>();
        options.add(new MenuOption("",new LooseAndGoToGameOverCommand(state,game)));
        state.getModel().getMenu().setOptions(options);
    }

    @Override
    public BattleSubstate getNextSubstate(Battle battle)
    {

        return this;
    }
}
