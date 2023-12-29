package com.l03gr06.sagabi.factories;

import com.l03gr06.sagabi.model.battlers.MonsterElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class BasicMonsterElementFactory implements MonsterElementFactory {

    public BasicMonsterElementFactory(String pathToInfoFile)
    {

        types= new HashMap<>();
        ReadFile file= new ReadFile(pathToInfoFile);
        List<String> lines =file.splitInLines();
        for (int i=0;i<lines.size();i+=3)
        {
            String[] splt= lines.get(i).split(" ");
            types.put(splt[0], new MonsterElement(splt[0],splt[1]));
        }
        for (int i=0;i<lines.size();i+=3)
        {
            String[] splt= lines.get(i).split(" ");

            String[] splt2= lines.get(i+1).split(" ");
            for(int x=1;x<splt2.length;x++)
            {
                types.get(splt[0]).addResistance(types.get(splt2[x]));
            }

            String[] splt3= lines.get(i+2).split(" ");
            for(int x=1;x<splt3.length;x++)
            {
                types.get(splt[0]).addWeakness(types.get(splt3[x]));
            }
        }
    }

    private Map<String, MonsterElement> types;
@Override
    public MonsterElement getElement(String element)
    {

        if (types.containsKey(element)) {
            return types.get(element);
        }else
        {
            return types.get("player");
        }
    }

    @Override
    public List<MonsterElement> getAllElements()
    {
        return new ArrayList<>(types.values());
    }
}
