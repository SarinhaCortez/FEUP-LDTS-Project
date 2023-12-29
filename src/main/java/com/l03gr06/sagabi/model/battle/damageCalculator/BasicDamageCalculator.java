package com.l03gr06.sagabi.model.battle.damageCalculator;

import com.l03gr06.sagabi.model.battlers.Attack;
import com.l03gr06.sagabi.model.battlers.Battler;

import java.util.Random;
@SuppressWarnings({"Immutable","JavaLangClash","ObjectToString"})

public class BasicDamageCalculator implements DamageCalculator {
    Random rand = new Random();
    @Override
    public String useAttack(Attack attack, Battler user, Battler target)
    {
        StringBuilder builder = new StringBuilder();
        if (attack.getHitChance()>rand.nextInt(100))
        {
            builder.append(user.getName());
            builder.append(" used ");
            builder.append(attack.getName());
            builder.append("!\n");
            int damage=attack.getDamage()*user.getAttackStat(attack.getElement())/target.getDefenceStat(attack.getElement());
            if (target.isDefending())
            {
                builder.append(target.getName());
                builder.append("defended!");
                damage/=2;
            }
            if (target.getElement().isWeakAgainst(attack.getElement()))
            {
                builder.append("It was very effective!\n");
                damage*=2;
            }
            if (target.getElement().isResistantAgainst(attack.getElement()))
            {
                builder.append(target.getName());
                builder.append(" resisted the attack!\n");
                damage/=2;
            }
            if (user.getElement().equals(attack.getElement()))
            {
                int half= damage/2;
                damage+=half;
            }
            if (damage<=0){damage=1;}
            user.heal(attack.getHeal()*damage/100);
            target.damage(damage);
            builder.append(target.getName());
            builder.append(" lost ");
            builder.append(damage);
            builder.append(" hp!\n");

            user.subtractEnergy(attack.getEnergyCost());
            builder.append("Lost ");
            builder.append(attack.getEnergyCost());
            builder.append(" energy!");

        }
        return builder.toString();
    }

    @Override
    public void onTurnBegin(Battler battler) {
        battler.stopDefending();
    }

    @Override
    public void onRest(Battler battler)
        {
            battler.addEnergy(battler.getEnergyRecovery());
        }


}
