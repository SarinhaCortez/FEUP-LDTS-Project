package com.l03gr06.sagabi.model.map.entities.interactables;

import com.l03gr06.sagabi.Game;
import com.l03gr06.sagabi.model.battle.Battle;
import com.l03gr06.sagabi.model.battle.damageCalculator.BasicDamageCalculator;
import com.l03gr06.sagabi.model.battle.monsterAI.MonsterAI;
import com.l03gr06.sagabi.model.battle.monsterAI.SmartAI;
import com.l03gr06.sagabi.model.battlers.MonsterBattler;
import com.l03gr06.sagabi.model.map.Room;
import com.l03gr06.sagabi.states.BaseBattleState;
import com.l03gr06.sagabi.states.BattleState;


@SuppressWarnings({"Immutable","JavaLangClash"})
public class Monster extends Interactable{
    private final MonsterBattler battler;
    private String id;
    private Game game;
    public Monster(int x, int y, MonsterBattler mB,String id,Game game) {

        super(x, y);
        battler = mB;
        this.game=game;
        this.id=id;
    }
    @Override
    public  boolean onMonsterDefeated(MonsterBattler battler, int monstersLeft)
    {
        return this.battler==battler;
    }
    @Override
    public void onCollision() {
        game.setState(new BaseBattleState(new Battle(battler, new SmartAI(), new BasicDamageCalculator(),(Room) game.getState().getModel()),game));
    }
    public  String getId()
    {
        return id;
    }
    public MonsterBattler getMonsterBattler() {
        return battler;
    }

}
