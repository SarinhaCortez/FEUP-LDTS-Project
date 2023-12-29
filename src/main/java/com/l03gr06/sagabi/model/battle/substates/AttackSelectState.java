package com.l03gr06.sagabi.model.battle.substates;

import com.l03gr06.sagabi.Game;
import com.l03gr06.sagabi.model.battle.Battle;
import com.l03gr06.sagabi.model.battlers.Attack;
import com.l03gr06.sagabi.model.battlers.PlayerBattler;
import com.l03gr06.sagabi.model.menu.Menu;
import com.l03gr06.sagabi.model.menu.MenuOption;
import com.l03gr06.sagabi.model.menu.battlemenucommand.GetOutOfWantToAttackMenuCommand;
import com.l03gr06.sagabi.model.menu.battlemenucommand.SelectAttackCommand;
import com.l03gr06.sagabi.states.BattleState;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"Immutable","JavaLangClash","ObjectToString"})

public class AttackSelectState implements BattleSubstate {
    public AttackSelectState(Game game)
    {
        this.game=game;
    }
    private Attack attack;
    @Override
    public void init(BattleState state)
    {
        PlayerBattler player=PlayerBattler.getInstance(null);
        List<Attack> attacks=player.getAttacks();
        List<MenuOption> options= new ArrayList<>();
        for(Attack at : attacks)
        {
            if(at.getEnergyCost()<=player.getCurrentEnergy())
            {
                options.add(new MenuOption(" - " + at.getName(), new SelectAttackCommand(at, this, state)));
            }
        }
        options.add(new MenuOption(" - Quit",new GetOutOfWantToAttackMenuCommand(state,this)));
        state.getModel().getMenu().setText("Which attack: ");
        state.getModel().getMenu().setOptions(options);
    }
    public void setAttack(Attack attack) {
        this.attack=attack;
    }
    private Game game;
    @Override
    public BattleSubstate getNextSubstate(Battle battle)
    {
        if (attack==null){

            return new HeroBaseState(false,game);

        }else{

            return new ShowPlayerAttackMessageState(attack,game);
            
        }
    }
}
