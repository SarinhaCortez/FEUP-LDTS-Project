package com.l03gr06.sagabi.states

import com.l03gr06.sagabi.Game
import com.l03gr06.sagabi.model.battle.Battle
import com.l03gr06.sagabi.model.battle.damageCalculator.DamageCalculator
import com.l03gr06.sagabi.model.battle.monsterAI.MonsterAI
import com.l03gr06.sagabi.model.battle.substates.BattleSubstate
import com.l03gr06.sagabi.model.battle.substates.HeroBaseState
import com.l03gr06.sagabi.model.battle.substates.MonsterState
import com.l03gr06.sagabi.model.battlers.Attack
import com.l03gr06.sagabi.model.battlers.MonsterBattler
import com.l03gr06.sagabi.model.battlers.PlayerBattler
import com.l03gr06.sagabi.model.map.entities.Player
import com.l03gr06.sagabi.model.menu.Menu
import org.mockito.Mockito
import spock.lang.Specification

import spock.lang.Specification

class BaseBattleStateTest extends Specification {

    def "getInitialSubstate should return MonsterState when enemy speed is greater than player speed"() {
        given: "A BaseBattleState instance with a Battle model where the enemy speed is greater than the player speed"

        Game game=Mock(Game)
        Battle battle = Mock(Battle)
        PlayerBattler player = Mock(PlayerBattler)
        MonsterBattler enemy = Mock(MonsterBattler)
        DamageCalculator damageCalculator = Mock(DamageCalculator)
        MonsterAI monsterAI = Mock(MonsterAI)
        Menu menu = Mock(Menu)
        battle.getPlayer() >> player
        battle.getEnemy() >> enemy
        battle.getDamageCalculator() >> damageCalculator
        battle.getMonsterAI() >> monsterAI
        battle.getMenu()>>menu;
        player.getSpeed() >> 5
        enemy.getSpeed() >> 10

        BaseBattleState state = new BaseBattleState(battle,game)  // Pass the MonsterState instance to the BaseBattleState constructor

        expect: "getInitialSubstate should return a MonsterState instance"
        state.getInitialSubstate() instanceof MonsterState
    }

    def "getInitialSubstate should return HeroBaseState when player speed is greater than or equal to enemy speed"() {
        given: "A BaseBattleState instance with a Battle model where the player speed is greater than or equal to the enemy speed"
       Game game=Mock(Game)
        Battle battle = Mock(Battle)
        PlayerBattler player = Mock(PlayerBattler)
        MonsterBattler enemy = Mock(MonsterBattler)
        DamageCalculator damageCalculator = Mock(DamageCalculator)
        Menu menu = Mock(Menu)
        battle.getPlayer() >> player
        battle.getEnemy() >> enemy
        battle.getDamageCalculator() >> damageCalculator
        battle.getMenu() >> menu
        player.getSpeed() >> 10
        enemy.getSpeed() >> 5  // Pass the mocked Menu instance to the HeroBaseState constructor
        BaseBattleState state = new BaseBattleState(battle,game)  // Pass the HeroBaseState instance to the BaseBattleState constructor

        expect: "getInitialSubstate should return a HeroBaseState instance"
        state.getInitialSubstate() instanceof HeroBaseState
    }


    def "initial MonsterState should execute"()
    {
        given: "A BaseBattleState instance with a Battle model where the enemy speed is greater than the player speed"
        Game game=Mock(Game)
        Battle battle = Mock(Battle)
        PlayerBattler player = Mock(PlayerBattler)
        MonsterBattler enemy = Mock(MonsterBattler)
        DamageCalculator damageCalculator = Mock(DamageCalculator)
        MonsterAI monsterAI = Mock(MonsterAI)
        Menu menu = Mock(Menu)
        battle.getPlayer() >> player
        battle.getEnemy() >> enemy
        battle.getDamageCalculator() >> damageCalculator
        battle.getMonsterAI() >> monsterAI
        battle.getMenu()>>menu;
        player.getSpeed() >> 5
        enemy.getSpeed() >> 10
        BattleSubstate substate= Mock(BattleSubstate);
        BaseBattleState state = new BaseBattleState(battle,game)  // Pass the MonsterState instance to the BaseBattleState constructor
        when:
        state.setSubstate(substate);

        then:
        1 * substate.init(state)
    }

}