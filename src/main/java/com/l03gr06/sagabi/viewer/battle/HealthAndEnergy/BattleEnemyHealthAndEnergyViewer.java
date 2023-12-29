package com.l03gr06.sagabi.viewer.battle.HealthAndEnergy;

import com.l03gr06.sagabi.gui.GUI;
import com.l03gr06.sagabi.model.battle.Battle;
import com.l03gr06.sagabi.viewer.Viewer;
import com.l03gr06.sagabi.states.State;

@SuppressWarnings({"Immutable","JavaLangClash","ObjectToString"})
public class BattleEnemyHealthAndEnergyViewer extends BattleHealthAndEnergyViewer{
    @Override
    public void draw(GUI gui, State<Battle> state)
    {
        gui.drawStringNormal(20,0,"H:" + state.getModel().getEnemy().getCurrentHealth()+"/"+state.getModel().getEnemy().getMaxHealth(),state.getModel().getEnemy().getElement().getColor());
        gui.drawStringNormal(10,0,"E:"+state.getModel().getEnemy().getCurrentEnergy()+ "/" +state.getModel().getEnemy().getMaxEnergy(),state.getModel().getEnemy().getElement().getColor());
    }
}
