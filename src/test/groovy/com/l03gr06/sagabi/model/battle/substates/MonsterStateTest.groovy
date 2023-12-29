package com.l03gr06.sagabi.model.battle.substates

import com.l03gr06.sagabi.model.battle.monsterAI.MonsterAI
import spock.lang.Specification
import com.l03gr06.sagabi.model.battle.Battle
import com.l03gr06.sagabi.model.battle.damageCalculator.DamageCalculator
import com.l03gr06.sagabi.model.battlers.Attack
import com.l03gr06.sagabi.model.battlers.MonsterBattler
import com.l03gr06.sagabi.model.battlers.PlayerBattler
import com.l03gr06.sagabi.model.menu.Menu
import com.l03gr06.sagabi.states.BattleState
import com.l03gr06.sagabi.model.menu.MenuOption

class MonsterStateTest extends Specification {

    def "init should initialize the menu with the monster's attack or defense action"() {
        given: "A BattleState instance and a MonsterState instance"
        BattleState state = Mock(BattleState)
        Battle battle = Mock(Battle)
        Menu menu = Mock(Menu)
        DamageCalculator damageCalculator = Mock(DamageCalculator)
        MonsterAI monsterAI = Mock(MonsterAI)
        Attack attack = Mock(Attack)
        MonsterBattler monster = Mock(MonsterBattler)
        state.getModel() >> battle
        battle.getMenu() >> menu
        battle.getDamageCalculator() >> damageCalculator
        battle.getMonsterAI() >> monsterAI
        monsterAI.chooseAttack(_, _) >> attack
        damageCalculator.useAttack(_, _, _) >> "Mock attack result"
        battle.getEnemy() >> monster
        MonsterState monsterState = new MonsterState()

        when: "init is called"
        monsterState.init(state)

        then: "The menu's text should be set to the result of the monster's attack or the monster's defense action"
        1 * menu.setText(_ as String)

        and: "A WaitForClickCommand option should be added to the menu"
        1 * menu.setOptions(_ as List<MenuOption>)
    }

    def "getNextSubstate should return WinState when the player is alive and the enemy is tired"() {
        given: "A Battle instance and a MonsterState instance"
        Battle battle = Mock(Battle)
        PlayerBattler player = Mock(PlayerBattler)
        MonsterBattler enemy = Mock(MonsterBattler)
        battle.getPlayer() >> player
        battle.getEnemy() >> enemy
        MonsterState monsterState = new MonsterState()

        and: "The player is not dead and the enemy is tired"
        player.isDead() >> false
        enemy.isTired() >> true

        when: "getNextSubstate is called"
        BattleSubstate nextSubstate = monsterState.getNextSubstate(battle)

        then: "It should return a WinState instance"
        assert nextSubstate instanceof WinState
    }
    def "getNextSubstate should return LooseState when the player is dead"() {
        given: "A Battle instance and a MonsterState instance"
        Battle battle = Mock(Battle)
        PlayerBattler player = Mock(PlayerBattler)
        MonsterBattler enemy = Mock(MonsterBattler)
        battle.getPlayer() >> player
        battle.getEnemy() >> enemy
        MonsterState monsterState = new MonsterState()

        and: "The player is dead"
        player.isDead() >> true

        when: "getNextSubstate is called"
        BattleSubstate nextSubstate = monsterState.getNextSubstate(battle)

        then: "It should return a LooseState instance"
        assert nextSubstate instanceof LooseState
    }
}