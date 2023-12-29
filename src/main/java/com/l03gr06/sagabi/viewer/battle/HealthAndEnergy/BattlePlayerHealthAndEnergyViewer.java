package com.l03gr06.sagabi.viewer.battle.HealthAndEnergy;

import com.l03gr06.sagabi.gui.GUI;
import com.l03gr06.sagabi.model.battle.Battle;
import com.l03gr06.sagabi.viewer.Viewer;
import com.l03gr06.sagabi.states.State;

@SuppressWarnings({"Immutable","JavaLangClash","ObjectToString"})
public class BattlePlayerHealthAndEnergyViewer extends BattleHealthAndEnergyViewer{
    @Override
    public void draw(GUI gui, State<Battle> state){
        gui.drawStringNormal(10,14,"H:" + state.getModel().getPlayer().getCurrentHealth()+"/"+state.getModel().getPlayer().getMaxHealth(),"learn_menu_purple");
        gui.drawStringNormal(0,14,"E:"+state.getModel().getPlayer().getCurrentEnergy()+ "/" +state.getModel().getPlayer().getMaxEnergy(),"learn_menu_purple");
    }
}
