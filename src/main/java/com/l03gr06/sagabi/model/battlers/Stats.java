package com.l03gr06.sagabi.model.battlers;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class Stats {

    private int maxHealth, maxEnergy, speed, energyRecovery;
    private Map<MonsterElement, Integer> attackStats;
    private Map<MonsterElement, Integer> defenceStats;
    public int getMaxHealth()
    {
        return maxHealth;
    }
    public int getMaxEnergy()
    {
        return maxEnergy;
    }
    public int getSpeed()
    {
        return speed;
    }
    public int getEnergyRecovery()
    {
        return energyRecovery;
    }
    public int getDefenceStat(MonsterElement element)
    {
        if (!defenceStats.containsKey(element))
        {
            return 1;
        }
        return defenceStats.get(element);
    }
    public int getAttackStat(MonsterElement element)
    {

        if (!attackStats.containsKey(element))
        {
            return 1;
        }
        return attackStats.get(element);
    }
    public Stats(int maxHealth, int maxEnergy, int speed, int energyRecovery, Map<MonsterElement, Integer> attackStats, Map<MonsterElement, Integer> defenceStats){
        this.maxHealth = maxHealth;
        this.maxEnergy = maxEnergy;
        this.speed = speed;
        this.energyRecovery = energyRecovery;
        this.attackStats = attackStats;
        this.defenceStats = defenceStats;
    }

}
