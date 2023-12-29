package com.l03gr06.sagabi.controller;

import com.l03gr06.sagabi.Game;
import com.l03gr06.sagabi.gui.Action;
import com.l03gr06.sagabi.states.State;

import java.io.IOException;

@SuppressWarnings({"Immutable","JavaLangClash"})
public interface Controller<T> {
    public abstract void step(Game game, State<T> state, Action action, float delta) throws IOException;
}
