package com.l03gr06.sagabi.model.battle.monsterai

import com.l03gr06.sagabi.model.battle.monsterAI.MonsterAI
import com.l03gr06.sagabi.model.battle.monsterAI.SmartAI
import com.l03gr06.sagabi.model.battlers.Attack
import com.l03gr06.sagabi.model.battlers.Battler
import com.l03gr06.sagabi.model.battlers.MonsterBattler
import com.l03gr06.sagabi.model.map.entities.interactables.Monster
import spock.lang.Specification

class MonsterAITest extends Specification{

    def "MonsterAI should choose an attack"()
    {
        given:
        MonsterAI ai= new SmartAI()
        Battler user=  Mock(Battler)
        Attack atck= Mock(Attack);
        user.getAttacks()>>[atck];
        Battler target=Mock(Battler)
        when:
        Attack at= ai.chooseAttack(user,target)
        then:
        at ==atck
    }

}
