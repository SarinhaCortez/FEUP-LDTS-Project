package com.l03gr06.sagabi.model.battlers;

import java.util.HashSet;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class MonsterElement {
    String color;
    private String name;
    private HashSet<MonsterElement> resistantAgainst;
    private HashSet<MonsterElement> weakAgainst;
    public String getName()
    {
    return name;
    }
    public boolean isResistantAgainst(MonsterElement element)
    {
        return resistantAgainst.contains(element);
    }
    public boolean isWeakAgainst(MonsterElement element)
    {return weakAgainst.contains(element);

    }
    public String getColor(){return  color;}


    public MonsterElement(String nm, String color)  {
        name = nm.toLowerCase();
        resistantAgainst = new HashSet<>();
        weakAgainst= new HashSet<>();
        this.color=color;
    }

    //isto determina se, quando são atingidos por um ataque, monstros deste elemento resistem ou são fracos
    public void addResistance(MonsterElement element)
    {
resistantAgainst.add(element);
    }
    public void addWeakness(MonsterElement element)
    {
weakAgainst.add(element);
    }
    @Override
    public boolean equals(Object o)
    {
        if (o==null)
        {
            return false;
        }
        if (o instanceof MonsterElement)
        {
            return false;
        }
        MonsterElement e=(MonsterElement) o;
        return e.name.equals(name)&&e.resistantAgainst.equals(resistantAgainst);
    }
    @Override
    public int hashCode()
    {return super.hashCode();

    }

}
