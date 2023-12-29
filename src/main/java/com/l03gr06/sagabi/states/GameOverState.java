package com.l03gr06.sagabi.states;

import com.l03gr06.sagabi.controller.Controller;
import com.l03gr06.sagabi.controller.GameOverController;
import com.l03gr06.sagabi.model.game_over_state.GameOverStateMessage;
import com.l03gr06.sagabi.viewer.GameOverViewer;
import com.l03gr06.sagabi.viewer.Viewer;

@SuppressWarnings({"Immutable","JavaLangClash"})

public class GameOverState extends State<GameOverStateMessage>
{
    @Override
    protected Viewer<GameOverStateMessage> getViewer()
    {
        return new GameOverViewer();
    }
    @Override
    protected Controller<GameOverStateMessage> getController()
    {
        return new GameOverController();
    }
    public GameOverState(GameOverStateMessage model)
    {
        super(model);
    }
}
