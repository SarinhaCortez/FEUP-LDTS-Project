package com.l03gr06.sagabi.model.battlers;

import java.util.List;
import com.l03gr06.sagabi.model.battlers.MonsterElement;

@SuppressWarnings({"Immutable","JavaLangClash"})
public abstract class Battler {
    private String name;
    public String getName(){return name;}
    private int health;
    private int energy;
    protected int level;
    private boolean defending;
    protected Stats stats;
    private List<Attack> attacks;
    protected MonsterElement element;
    public boolean isDefending()
    {
        return defending;
    }
    public int getCurrentEnergy()
    {
        return energy;
    }
    public int getCurrentHealth()
    {
        return health;
    }

    public int getLevel()
    {
        return level;
    }

    public int getMaxHealth()
    {
        return stats.getMaxHealth()+ (stats.getMaxHealth()/2)*level;
    }

    public int getMaxEnergy()
    {
        return stats.getMaxEnergy() + (stats.getMaxEnergy()/2)*level;
    }

    public int getSpeed()
    {
        return stats.getSpeed() + (stats.getSpeed()*level)/4;
    }

    public int getEnergyRecovery()
    {
        return stats.getEnergyRecovery() + (stats.getEnergyRecovery()*level)/4;

    }
    public void subtractEnergy(int amount)
    {
        if(energy - amount <= 0){
            energy = 0;
        }
        else{
            energy -= amount;
        }
    }
    public boolean isDead()
    {
        return health==0;
    }
    public void healFull()
    {
        health=getMaxHealth();
        energy=getMaxEnergy();
    }

    public void stopDefending()
    {
        defending=false;
    }

    public void startDefending()
    {
        defending=true;
    }

    public List<Attack> getAttacks()
    {
        return attacks;
    }

    public int getDefenceStat(MonsterElement element)
    {
        return stats.getDefenceStat(element)+ (stats.getDefenceStat(element)/2)*level;
    }

    public int getAttackStat(MonsterElement element)
    {
        return stats.getAttackStat(element)+ (stats.getAttackStat(element)/2)*level;
    }
    public MonsterElement getElement()
    {
        return element;
    }
    public  void removeAttack(Attack attack)
    {
        attacks.remove(attack);
    }
    public void addAttack(Attack attack)
    {
        attacks.add(attack);
    }

    public void heal(int amount)
    {
        health+=amount;
        if (health>getMaxHealth())
        {
            health=getMaxHealth();
        }
    }
    public void damage(int amount)
    {
        health-=amount;
        if (health<0)
        {
            health=0;
        }
    }

    public void addEnergy(int amount){
        if (energy + amount > getMaxEnergy()){
            energy = getMaxEnergy();
        }
        else{
            energy += amount;
        }
    }

    public Battler(Stats stats, MonsterElement element, List<Attack> attacks, int level, String name)
    {
        this.stats=stats;
        defending=false;
        this.level=level;
        this.element=element;
        this.attacks=attacks;
        health=getMaxHealth();
        energy=getMaxEnergy();
        this.name=name;
    }

    public boolean isTired()
    {
        for (Attack atck:attacks)
        {
            if (atck.getEnergyCost()<energy)
            {
                return false;
            }
        }
        return true;
    }

}
