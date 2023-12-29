package com.l03gr06.sagabi.model.battlers;

import com.l03gr06.sagabi.model.Position;
import com.l03gr06.sagabi.model.map.entities.interactables.Monster;
import java.util.List;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class MonsterBattler extends Battler {
    private String id;
    public String getId()
    {
        return id;
    }

    public MonsterBattler(String id, Stats stats, MonsterElement element, List<Attack> attacks, int  level)
    {
        super(stats,element,attacks,level,id);
        this.id=id;
    }

}
