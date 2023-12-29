package com.l03gr06.sagabi.controller;

import com.l03gr06.sagabi.Game;
import com.l03gr06.sagabi.factories.BasicMainMenuFactory;
import com.l03gr06.sagabi.gui.Action;
import com.l03gr06.sagabi.model.battlers.PlayerBattler;
import com.l03gr06.sagabi.model.game_over_state.GameOverStateMessage;
import com.l03gr06.sagabi.states.MainMenuState;
import com.l03gr06.sagabi.states.State;

import java.io.IOException;

import static com.l03gr06.sagabi.gui.Action.SELECT;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class GameOverController implements Controller<GameOverStateMessage> {
    @Override
    public void step(Game game, State<GameOverStateMessage> state, Action action, float delta) throws IOException {
        if (action == SELECT) {
            PlayerBattler.reset(game);
            game.setState(new MainMenuState(game.getMenuFactory().createMainMenu()));
        }

    }
}
