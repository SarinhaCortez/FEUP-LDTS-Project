package com.l03gr06.sagabi.viewer.battle;

import com.l03gr06.sagabi.gui.GUI;
import com.l03gr06.sagabi.model.battle.Battle;
import com.l03gr06.sagabi.viewer.Viewer;
import com.l03gr06.sagabi.states.State;
import com.l03gr06.sagabi.viewer.battle.HealthAndEnergy.BattleEnemyHealthAndEnergyViewer;
import com.l03gr06.sagabi.viewer.battle.HealthAndEnergy.BattlePlayerHealthAndEnergyViewer;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class MainBattleViewer extends BattleViewer{

    
    private final BattlePlayerViewer player;
    private final BattleMenuViewer viewer;
    private final BattleEnemyViewer enemy;

    public MainBattleViewer(){
         player= new BattlePlayerViewer();
         viewer= new BattleMenuViewer();
        enemy= new BattleEnemyViewer();
    }
    public MainBattleViewer(BattlePlayerViewer player,BattleMenuViewer viewer,BattleEnemyViewer enemy){
        this.player= player;
        this.viewer= viewer;
        this.enemy= enemy;
    }

    private BattlePlayerHealthAndEnergyViewer player_energy = new BattlePlayerHealthAndEnergyViewer();
    private BattleEnemyHealthAndEnergyViewer enemy_energy = new BattleEnemyHealthAndEnergyViewer();
    @Override
    public void draw(GUI gui, State<Battle> state)
    {
        player.draw(gui,state);
        enemy.draw(gui, state);
        viewer.draw(gui,state);
        player_energy.draw(gui,state);
        enemy_energy.draw(gui,state);
    }
}
