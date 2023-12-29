package com.l03gr06.sagabi.model.battle;

import com.l03gr06.sagabi.model.battle.damageCalculator.DamageCalculator;
import com.l03gr06.sagabi.model.battle.monsterAI.MonsterAI;
import com.l03gr06.sagabi.model.battlers.MonsterBattler;
import com.l03gr06.sagabi.model.battlers.PlayerBattler;
import com.l03gr06.sagabi.model.map.Room;
import com.l03gr06.sagabi.model.menu.Menu;


@SuppressWarnings({"Immutable","JavaLangClash"})
public class Battle {
    private PlayerBattler player;
    private MonsterBattler monster;
    private MonsterAI ai;
    private DamageCalculator damageCalculator;
private Room room;
    private Menu menu;
    public PlayerBattler getPlayer()
    {
        return player;
    }
    public MonsterBattler getEnemy()
    {
        return monster;
    }
    public MonsterAI getMonsterAI()
    {
        return ai;
    }
    public DamageCalculator getDamageCalculator()
    {
        return damageCalculator;
    }
    public Menu getMenu()
    {
        return menu;
    }

    public Battle(MonsterBattler monster, MonsterAI ai, DamageCalculator damageCalculator,Room room)
    {
    player= PlayerBattler.getInstance(null);
    this.monster=monster;
    this.ai=ai;
    this.damageCalculator=damageCalculator;
    menu = new Menu();
    this.room=room;
    }
    public Battle(MonsterBattler monster,PlayerBattler player, MonsterAI ai, DamageCalculator damageCalculator,Room room)
    {
        this.player=player;
        this.monster=monster;
        this.ai=ai;
        this.damageCalculator=damageCalculator;
        menu = new Menu();
        this.room=room;
    }

    public Room getRoom() {return room;
    }
}
