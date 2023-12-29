package com.l03gr06.sagabi.viewer.battle;

import com.l03gr06.sagabi.gui.GUI;
import com.l03gr06.sagabi.model.battle.Battle;
import com.l03gr06.sagabi.viewer.Viewer;
import com.l03gr06.sagabi.states.State;

@SuppressWarnings({"Immutable","JavaLangClash"})
public abstract class BattleViewer implements Viewer<Battle> {
@Override
    public abstract void draw(GUI gui, State<Battle> state);
}
