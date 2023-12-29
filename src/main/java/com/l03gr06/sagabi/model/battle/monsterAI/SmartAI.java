package com.l03gr06.sagabi.model.battle.monsterAI;

import com.l03gr06.sagabi.model.battlers.Attack;
import com.l03gr06.sagabi.model.battlers.Battler;

import java.util.*;
@SuppressWarnings({"Immutable","JavaLangClash","RestrictedApiChecker"})

public class SmartAI implements MonsterAI {
    private static class AttackPriorityPair
    {
        public final Attack attack;
        private  int priority;
        public AttackPriorityPair(Attack attack,int priority)
        {
            this.attack=attack;
            this.priority=priority;
        }

        public int getPriority() {
            return priority;
        }
        public void setPriority(int value) {
            priority=value;
        }
    }

    @Override
    public Attack chooseAttack(Battler user, Battler target)
    {
        List<AttackPriorityPair> attacks= new ArrayList<>();
        int maxAttack=0;
        int minAccuracy=100;
        int maxEnergyCost=0;
        for(Attack attack : user.getAttacks())
        {
                int priority=0;
                maxAttack=Math.max(maxAttack,attack.getDamage());
                maxEnergyCost=Math.max(maxEnergyCost,attack.getEnergyCost());
                minAccuracy=Math.min(minAccuracy,attack.getHitChance());
                attacks.add(new AttackPriorityPair(attack,priority));
        }
        for(AttackPriorityPair pair : attacks)
        {
            if (pair.attack.getHitChance()==minAccuracy)
            {
                pair.setPriority(pair.getPriority()-1);
            }
            if (pair.attack.getDamage()==maxAttack)
            {
                pair.setPriority(pair.getPriority()+2);
            }

            if (pair.attack.getEnergyCost()==maxEnergyCost)
            {
                pair.setPriority(pair.getPriority()-1);
            }
        }
        attacks.add(new AttackPriorityPair(null,0));

        attacks.sort(new Comparator<AttackPriorityPair>() {
    @Override
    public int compare(AttackPriorityPair o1, AttackPriorityPair o2) {
        return Integer.compare(o2.priority, o1.priority);
    }
});


        return attacks.get(0).attack;
    }
}
