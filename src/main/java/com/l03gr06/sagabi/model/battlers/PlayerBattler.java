package com.l03gr06.sagabi.model.battlers;

import com.l03gr06.sagabi.Game;
import com.l03gr06.sagabi.factories.AttackFactory;
import com.l03gr06.sagabi.factories.LevelUpAttackLearner;

import java.util.ArrayList;
import java.util.HashMap;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class PlayerBattler extends Battler {
    public static void reset(Game game)
    {
        instance= new PlayerBattler(game);
    }
    private static PlayerBattler instance;


    private static Stats createStats(Game game)
    {
        HashMap<MonsterElement, Integer > attack= new HashMap<>();
        HashMap<MonsterElement, Integer > defence= new HashMap<>();
        for(MonsterElement element: game.getMonsterElementFactory().getAllElements())
        {
                    attack.put(element,15);
                    defence.put(element,15);
        }
        return new Stats(15,15,15,15, attack,defence);
    }
private Game game;

    private PlayerBattler(Game game)
    {
        super(createStats(game),
game                        .getMonsterElementFactory()
                        .getElement("player"),
               game
                        .getAttackFactory()
                        .getXRandomAttacks(2,
                                game
                                        .getMonsterElementFactory()
                                        .getElement("player")),1,"Sagabi");

 this.game =game;
    }

    private PlayerBattler(Game game,boolean empty)
    {
        super(createStats(game),
               null,
     new ArrayList<>(),1,"Sagabi");

        this.game =game;
    }

    public static PlayerBattler getInstance(Game game)
    {
        if(instance==null)
        {
            instance= new PlayerBattler(game);
        }
        return instance;
    }
    public static PlayerBattler getEmptyInstance(Game game)
    {
        if(instance==null)
        {
            instance= new PlayerBattler(game,true);
        }
        return instance;
    }




    public void onEnemyDefeated(MonsterBattler monster)
    {
       level++;
       Attack atck= game.getAttackLearner().getAttackForLevel(level);
        if (atck!=null&&!getAttacks().contains(atck))
        {

            addAttack(atck);
        }
    }


}
