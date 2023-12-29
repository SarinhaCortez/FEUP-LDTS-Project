package com.l03gr06.sagabi.factories;

import com.l03gr06.sagabi.Game;
import com.l03gr06.sagabi.model.battlers.Attack;
import com.l03gr06.sagabi.model.battlers.MonsterBattler;
import com.l03gr06.sagabi.model.battlers.MonsterElement;
import com.l03gr06.sagabi.model.battlers.Stats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@SuppressWarnings({"Immutable","JavaLangClash"})
class NameStatsPair
{
    final private String name;
    final private Stats stats;
    public String getName()
    {
        return name;
    }
    public Stats getStats()
    {
        return stats;
    }
    public NameStatsPair(String name, Stats stats)
    {
        this.name=name;
        this.stats=stats;
    }
}
@SuppressWarnings({"Immutable","JavaLangClash"})
public class BasicMonsterFactory implements MonsterFactory {
    public BasicMonsterFactory(String pathToFile,MonsterElementFactory elementF,Game game)
    {
        this.game=game;
        monsterBaseInfo= new ArrayList<>();
        ReadFile file = new ReadFile(pathToFile);
        List<String> lines= file.splitInLines();
        int currentLine=0;
        while(currentLine<lines.size())
        {
            String name;
            HashMap<MonsterElement, Integer>  attack=new HashMap<>();
            HashMap<MonsterElement, Integer>  defence=new HashMap<>();

            int maxHealth, maxEnergy,speed, energyRecovery;
            name=lines.get(currentLine);
            currentLine++;
            maxHealth=Integer.parseInt(lines.get(currentLine));
            currentLine++;
            maxEnergy=Integer.parseInt(lines.get(currentLine));
            currentLine++;
            speed=Integer.parseInt(lines.get(currentLine));
            currentLine++;
            energyRecovery=Integer.parseInt(lines.get(currentLine));
            currentLine++;


            if (currentLine<lines.size()) {

                while (!lines.get(currentLine).startsWith("//")) {
                    String[] split = lines.get(currentLine).split(" ");

                    MonsterElement element = elementF.getElement(split[0]);
                    attack.put(element, Integer.parseInt(split[1]));
                    defence.put(element, Integer.parseInt(split[2]));
                    //detect element
                    currentLine++;

                    if (currentLine >= lines.size()) {
                        break;
                    }
                }
            }

            monsterBaseInfo.add(new NameStatsPair( name, new Stats(maxHealth,maxEnergy,speed,energyRecovery,attack,defence)));
            currentLine++;
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

    }
    private Game game;

    private final List<NameStatsPair> monsterBaseInfo;

    @Override
    public MonsterBattler createMonsterBattler(int level, MonsterElement element)
    {
        Random random= new Random();
        NameStatsPair info= monsterBaseInfo.get(random.nextInt(0,monsterBaseInfo.size()));
        return new MonsterBattler(info.getName(),info.getStats(),element,
                game.getAttackFactory().getXRandomAttacks(3 +random.nextInt(0,3),element),level );
    }
}
