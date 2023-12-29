package com.l03gr06.sagabi.model.battle

import com.l03gr06.sagabi.model.battle.damageCalculator.DamageCalculator
import com.l03gr06.sagabi.model.battle.monsterAI.MonsterAI
import com.l03gr06.sagabi.model.battlers.MonsterBattler
import com.l03gr06.sagabi.model.battlers.PlayerBattler
import com.l03gr06.sagabi.model.map.Room
import spock.lang.Specification

class BattleTest extends Specification{
    def "Getters should work as expected"(){
        given: "MonsterBattler, MonsterAI, DamageCalculator and Room Mocks"
        MonsterBattler monsterBattler = Mock(MonsterBattler)
        MonsterAI monsterAI = Mock(MonsterAI)
        DamageCalculator damageCalculator = Mock(DamageCalculator)
        Room room = Mock(Room)
PlayerBattler battler=Mock(PlayerBattler)
        and: "A Battle object made from the mocks above"
        Battle battle = new Battle(monsterBattler,battler,monsterAI,damageCalculator,room)

        expect:
        battle.getPlayer()==battler
        battle.getEnemy() == monsterBattler
        battle.getMonsterAI() == monsterAI
        battle.getDamageCalculator() == damageCalculator
        battle.getRoom() == room
    }
}
