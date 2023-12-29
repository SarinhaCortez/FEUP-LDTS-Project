package com.l03gr06.sagabi.model.battlers;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class Attack {
    private final int damage, heal, hitChance,energyCost;
    private final String name;
    private final MonsterElement element;
    public int getEnergyCost(){return energyCost;}
    public int getDamage()
    {
        return damage;
    }
    public int getHeal()
    {
        return heal;
    }
    public int getHitChance()
    {
        return hitChance;
    }
    public MonsterElement getElement()
    {
        return element;
    }
    public String getName()
    {
        return name;
    }
    public Attack(String name, MonsterElement element, int hitChance, int damage, int heal,int energyCost) {
        this.damage=damage;
        this.heal=heal;
        this.hitChance=hitChance;
        this.element=element;
        this.name=name;
        this.energyCost=energyCost;
    }
}
