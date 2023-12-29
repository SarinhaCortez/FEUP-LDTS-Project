package com.l03gr06.sagabi.factories;

import com.l03gr06.sagabi.Game;
import com.l03gr06.sagabi.model.battlers.Attack;
import com.l03gr06.sagabi.model.battlers.MonsterElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class BasicAttackFactory implements AttackFactory{
    private HashMap<String,Attack> attacks;
private Attack dummy;
    public BasicAttackFactory(String file,MonsterElementFactory elementF)
    {
        attacks= new HashMap<>();

        ReadFile reader= new ReadFile(file);
        List<String> lines=reader.splitInLines();
        int currentLine=0;
        while(currentLine<lines.size())
        {
            String name; MonsterElement element; int damage, heal, hitChance, energyCost;
            name=lines.get(currentLine);
            currentLine++;
            element= elementF.getElement(lines.get(currentLine));
            currentLine++;
            damage=Integer.parseInt(lines.get(currentLine));
            currentLine++;
            heal=Integer.parseInt(lines.get(currentLine));
            currentLine++;
            hitChance=Integer.parseInt(lines.get(currentLine));
            currentLine++;
            energyCost=Integer.parseInt(lines.get(currentLine));
            currentLine++;
            attacks.put(name,new Attack(name,element,hitChance,damage,heal,energyCost));
            if (currentLine>=lines.size())
            {
                break;
            }

            while(lines.get(currentLine).startsWith("//")||lines.get(currentLine).isEmpty()){

                currentLine++;
                if (currentLine>=lines.size())
                {
                    break;
                }
            }
        }

       dummy= new Attack("ERROR",elementF.getElement("player"),0,0,0,0);
    }

    @Override
    public Attack getAttack(String name){

        if (attacks.containsKey(name)){
        return attacks.getOrDefault(name,null);}else
        {
            return dummy;
        }
    }
    @Override
    public List<Attack> getXRandomAttacks(int x, MonsterElement bias) //Assumption made: there's enough attacks to fill x, and there's at least one attack of bias element
    {
        List<Attack> allAttacks=new ArrayList<>(attacks.values());
        List<Attack> attacksOfTheSameElement= new ArrayList<>();
        int i=0;
        try{
        while(i<allAttacks.size())
        {
            if (allAttacks.get(i).getElement().equals(bias))
            {
                attacksOfTheSameElement.add(allAttacks.get(i));
                allAttacks.remove(i);
            }
            else
            {
                i++;
            }

        }
        }catch(Exception e)
        {
            System.out.println("Error in attack factory:");
            System.out.println(e.toString());
        }

        List<Attack> toReturn= new ArrayList<>();
        Random random= new Random();

        if (attacks.size()<x)
        {
            x=attacks.size();
            //TODO: improve error checking. This can barely be called error checking

        }
try {
    i = 0;
    while (i < x&&(!allAttacks.isEmpty()||!attacksOfTheSameElement.isEmpty())) {
        if ((random.nextInt(0, 100) > 70 || attacksOfTheSameElement.isEmpty())&&!allAttacks.isEmpty()) {
            Attack attack = allAttacks.get(random.nextInt(0, allAttacks.size()));
            allAttacks.remove(attack);
            toReturn.add(attack);


        } else {
            Attack attack = attacksOfTheSameElement.get(random.nextInt(0, attacksOfTheSameElement.size()));
            attacksOfTheSameElement.remove(attack);

            toReturn.add(attack);


        }
        i++;

    }
}catch(Exception e)
{
    System.out.print("ERROR IN ATTACK FACTORY: ");
    System.out.println(e.toString());
}
        return toReturn;
    }
@Override
    public Attack getRandomAttack()
{
    List<Attack> allAttacks=new ArrayList<>(attacks.values());
    Random random = new Random();
    if (!allAttacks.isEmpty())
    {
        return allAttacks.get(random.nextInt(0,allAttacks.size()));
    }
    return null;
}


}
