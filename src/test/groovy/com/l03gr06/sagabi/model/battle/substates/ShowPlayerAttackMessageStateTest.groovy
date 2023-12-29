package com.l03gr06.sagabi.model.battle.substates

import com.l03gr06.sagabi.Game
import com.l03gr06.sagabi.model.battle.Battle
import com.l03gr06.sagabi.model.battle.damageCalculator.DamageCalculator
import com.l03gr06.sagabi.model.battlers.Attack
import com.l03gr06.sagabi.model.battlers.MonsterBattler
import com.l03gr06.sagabi.model.battlers.PlayerBattler
import com.l03gr06.sagabi.model.menu.Menu
import com.l03gr06.sagabi.states.BattleState
import spock.lang.Specification

class ShowPlayerAttackMessageStateTest extends Specification {
    Game game;
    def setup()
    {
        game=Mock(Game)
    }

    def "init should set up the menu with the correct options and text"() {
        given: "A BattleState instance and a ShowPlayerAttackMessageState instance"

        BattleState state = Mock(BattleState)
        Battle battle = Mock(Battle)
        DamageCalculator dc = Mock(DamageCalculator)
        Menu menu = new Menu()
        PlayerBattler player = Mock(PlayerBattler)
        MonsterBattler enemy = Mock(MonsterBattler)
        state.getModel() >> battle
        battle.getDamageCalculator() >> dc
        battle.getMenu() >> menu
        battle.getPlayer() >> player
        battle.getEnemy() >> enemy
        Attack attack = Mock(Attack)
        ShowPlayerAttackMessageState showPlayerAttackMessageState = new ShowPlayerAttackMessageState(attack,game)

        when: "init is called"
        showPlayerAttackMessageState.init(state)

        then: "The menu should have one option and the text should be the result of useAttack"
        menu.getOptions().size() == 1
        menu.getText() == dc.useAttack(attack, player, enemy)
    }

    def "getNextSubstate should return WinState based on the enemy's status"() {
        given: "A Battle instance and a ShowPlayerAttackMessageState instance"
        Battle battle = Mock(Battle)
        MonsterBattler enemy = Mock(MonsterBattler)
        battle.getEnemy() >> enemy
        Attack attack = Mock(Attack)
        ShowPlayerAttackMessageState showPlayerAttackMessageState = new ShowPlayerAttackMessageState(attack,game)

        and: "The enemy is dead"
        enemy.isDead() >> true

        when: "getNextSubstate is called"
        BattleSubstate nextSubstate = showPlayerAttackMessageState.getNextSubstate(battle)

        then: "It should return a WinState instance"
        assert nextSubstate instanceof WinState

    }

    def "getNextSubstate should return MonsterState based on the enemy's status"() {
        given: "A Battle instance and a ShowPlayerAttackMessageState instance"
        Battle battle = Mock(Battle)
        MonsterBattler enemy = Mock(MonsterBattler)
        battle.getEnemy() >> enemy
        Attack attack = Mock(Attack)
        ShowPlayerAttackMessageState showPlayerAttackMessageState = new ShowPlayerAttackMessageState(attack,game)

        and: "The enemy is not dead"
        enemy.isDead() >> false

        when: "getNextSubstate is called"
        BattleSubstate nextSubstate = showPlayerAttackMessageState.getNextSubstate(battle)

        then: "It should return a MonsterState instance"
        assert nextSubstate instanceof MonsterState
    }
}