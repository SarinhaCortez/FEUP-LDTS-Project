package com.l03gr06.sagabi.viewer.battle;

import com.l03gr06.sagabi.gui.GUI;
import com.l03gr06.sagabi.model.battle.Battle;
import com.l03gr06.sagabi.viewer.Viewer;
import com.l03gr06.sagabi.states.State;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class BattleEnemyViewer extends BattleViewer{
    @Override
    public void draw(GUI gui, State<Battle> state)
    {
        gui.drawEnemyInBattle(10,1,state.getModel().getEnemy().getId());
    }
}
