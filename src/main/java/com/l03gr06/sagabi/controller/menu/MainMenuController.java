package com.l03gr06.sagabi.controller.menu;

import com.l03gr06.sagabi.Game;
import com.l03gr06.sagabi.controller.Controller;
import com.l03gr06.sagabi.gui.Action;
import com.l03gr06.sagabi.model.menu.Menu;
import com.l03gr06.sagabi.states.State;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class MainMenuController implements Controller<Menu> {
    @Override
    public void step(Game game, State<Menu> state, Action action, float delta){
        switch(action){
            case UP:
                state.getModel().scrollUp();
                break;
            case DOWN:
                state.getModel().scrollDown();
                break;
            case SELECT:
                state.getModel().getCurrentOption().onClick();
                break;
            default:
        break;
        }
    }
}
