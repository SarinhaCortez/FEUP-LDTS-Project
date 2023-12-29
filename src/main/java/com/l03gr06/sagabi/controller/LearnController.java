package com.l03gr06.sagabi.controller;

import com.l03gr06.sagabi.Game;
import com.l03gr06.sagabi.factories.BasicMainMenuFactory;
import com.l03gr06.sagabi.gui.Action;
import com.l03gr06.sagabi.model.learn_state.LearnStateMenu;
import com.l03gr06.sagabi.states.MainMenuState;
import com.l03gr06.sagabi.states.State;

import java.io.IOException;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class LearnController implements Controller<LearnStateMenu>{
    @Override
    public void step(Game game, State<LearnStateMenu> state, Action action, float delta) throws IOException {
        switch(action){
            case RIGHT:
                state.getModel().moveToNextPage();
                break;
            case LEFT:
                state.getModel().moveToPreviousPage();
                break;
            case DOWN:
                game.setState(new MainMenuState(new BasicMainMenuFactory(game).createMainMenu()));
                break;
            default:
                break;
        }
    }
}
