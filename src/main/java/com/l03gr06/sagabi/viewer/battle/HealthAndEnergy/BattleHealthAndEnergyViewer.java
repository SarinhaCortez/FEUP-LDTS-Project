package com.l03gr06.sagabi.viewer.battle.HealthAndEnergy;

import com.l03gr06.sagabi.gui.GUI;
import com.l03gr06.sagabi.model.battle.Battle;
import com.l03gr06.sagabi.viewer.battle.BattleViewer;
import com.l03gr06.sagabi.viewer.Viewer;
import com.l03gr06.sagabi.states.State;

@SuppressWarnings({"Immutable","JavaLangClash"})
public abstract class BattleHealthAndEnergyViewer extends BattleViewer {
    @Override
    public void draw(GUI gui, State<Battle> state){}
}
