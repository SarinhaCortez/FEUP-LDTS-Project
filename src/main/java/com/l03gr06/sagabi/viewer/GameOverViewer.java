package com.l03gr06.sagabi.viewer;

import com.l03gr06.sagabi.gui.GUI;
import com.l03gr06.sagabi.model.game_over_state.GameOverStateMessage;
import com.l03gr06.sagabi.states.State;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class GameOverViewer implements Viewer<GameOverStateMessage> {
    @Override
    public void draw(GUI gui, State<GameOverStateMessage> state) throws Exception {
        gui.drawStringBig(5, 3, state.getModel().getTitle());
        gui.drawStringNormal(2, 6, state.getModel().getMainText(), "white");

    }
}
