package com.l03gr06.sagabi.viewer;

import com.l03gr06.sagabi.gui.GUI;

import com.l03gr06.sagabi.states.State;

@SuppressWarnings({"Immutable","JavaLangClash"})
public interface Viewer<T> {
    public void draw(GUI gui, State<T> state) throws Exception;
}
