package com.l03gr06.sagabi.controller;

import com.l03gr06.sagabi.Game;
import com.l03gr06.sagabi.gui.Action;
import com.l03gr06.sagabi.model.battle.Battle;
import com.l03gr06.sagabi.model.menu.MenuOption;
import com.l03gr06.sagabi.states.State;

import java.io.IOException;
@SuppressWarnings({"Immutable","JavaLangClash"})
public class BattleController implements  Controller<Battle>{
    @Override
    public void step(Game game, State<Battle> state, Action action, float delta) throws IOException {
        switch(action){
            case UP:
                state.getModel().getMenu().scrollUp();
                break;
            case DOWN:
                state.getModel().getMenu().scrollDown();
                break;
            case SELECT:
                MenuOption option=state.getModel().getMenu().getCurrentOption();
                if (option!=null){option.onClick();}
                break;
            default:
                break;
        }
    }
}
