package com.l03gr06.sagabi.model.battle.substates

import com.l03gr06.sagabi.Game
import com.l03gr06.sagabi.model.battle.damageCalculator.DamageCalculator
import spock.lang.Specification
import com.l03gr06.sagabi.model.battle.Battle
import com.l03gr06.sagabi.model.battlers.PlayerBattler
import com.l03gr06.sagabi.model.menu.Menu
import com.l03gr06.sagabi.states.BattleState


class HeroBaseStateTest extends Specification {

    def "init should initialize the menu with the player's actions and call onTurnBegin if callOnTurnStart is true"() {
        given: "A BattleState instance and a HeroBaseState instance with callOnTurnStart set to true"
        BattleState state = Mock(BattleState)
        Battle battle = Mock(Battle)
        Menu menu = Mock(Menu)
        DamageCalculator damageCalculator = Mock(DamageCalculator)
        state.getModel() >> battle
        battle.getMenu() >> menu
        battle.getDamageCalculator() >> damageCalculator
        PlayerBattler player = Mock(PlayerBattler)
        Game game =Mock(Game)
        battle.getPlayer() >> player
        HeroBaseState heroBaseState = new HeroBaseState(true,game)


        when: "init is called"
        heroBaseState.init(state)

        then: "onTurnBegin should be called on the damage calculator with the player"
        1 * damageCalculator.onTurnBegin(player)

        and: "The menu's text should be set to 'What will Sagabi do?'"
        1 * menu.setText("What will Sagabi do?")

        and: "The menu's options should be set to the player's actions"
        1 * menu.setOptions(_ as List)
    }

    def "init should initialize the menu with the player's actions and not call onTurnBegin if callOnTurnStart is false"() {
        given: "A BattleState instance and a HeroBaseState instance with callOnTurnStart set to false"
        Game game=Mock(Game)
        BattleState state = Mock(BattleState)
        Battle battle = Mock(Battle)
        Menu menu = Mock(Menu)
        state.getModel() >> battle
        battle.getMenu() >> menu
        battle.getMenu() >> menu
        DamageCalculator dc=Mock(DamageCalculator)
        battle.getDamageCalculator()>>dc
        HeroBaseState heroBaseState = new HeroBaseState(false,game)

        when: "init is called"
        heroBaseState.init(state)

        then: "onTurnBegin should not be called on the damage calculator"
        0 * battle.getDamageCalculator().onTurnBegin(_)

        and: "The menu's text should be set to 'What will Sagabi do?'"
        1 * menu.setText("What will Sagabi do?")

        and: "The menu's options should be set to the player's actions"
        1 * menu.setOptions(_ as List)
        and: "The onTurnBegin of class DamageCalculator shouldn't be called:"
        0*dc.onTurnBegin(_)
    }
}