package com.l03gr06.sagabi.states;
/*
import com.l03gr06.sagabi.Game;
import com.l03gr06.sagabi.controller.Controller;
import com.l03gr06.sagabi.GUI;
import com.l03gr06.sagabi.Viewer;
*/
import com.l03gr06.sagabi.controller.Controller;
import com.l03gr06.sagabi.gui.Action;
import com.l03gr06.sagabi.gui.GUI;
import com.l03gr06.sagabi.viewer.Viewer;
import com.l03gr06.sagabi.Game;

import java.io.IOException;

@SuppressWarnings({"Immutable","JavaLangClash"})
public abstract class State<T>
{
    private T model;
    private Viewer<T> viewer;
    private Controller<T> controller;
    public void step(Game game, GUI gui, float time) throws IOException, Exception
    {
        Action action=gui.getNextAction();
        if(action==Action.QUIT)
        {
            game.stop();
            return;
        }
        controller.step(game,this,action,time);
        gui.clear();
        viewer.draw(gui,this);
        gui.refresh();
    }
    protected abstract Viewer<T> getViewer();
    protected abstract Controller<T> getController();

    public T getModel()
    {
        return model;
    }
    public State(T model)
    {
        this.model=model;
        viewer= getViewer();
        controller=getController();
    }


}