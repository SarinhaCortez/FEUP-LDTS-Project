package com.l03gr06.sagabi.model.battle.substates

import com.l03gr06.sagabi.model.battle.Battle
import com.l03gr06.sagabi.model.battle.damageCalculator.DamageCalculator
import com.l03gr06.sagabi.model.battlers.Attack
import com.l03gr06.sagabi.model.battlers.PlayerBattler
import com.l03gr06.sagabi.model.menu.Menu
import com.l03gr06.sagabi.states.BattleState
import spock.lang.Specification

class ShowPlayerDefenceRestMessageTest extends Specification {

    def "init should set up the menu with the correct options and text"() {
        given: "A BattleState instance and a ShowPlayerRestMessageState instance"
        BattleState state = Mock(BattleState)
        Battle model = Mock(Battle)
        DamageCalculator dc = Mock(DamageCalculator)
        Menu menu = new Menu()
        PlayerBattler player = Mock(PlayerBattler)
        state.getModel() >> model
        model.getDamageCalculator() >> dc
        model.getMenu() >> menu
        model.getPlayer() >> player
        ShowPlayerRestMessageState showPlayerRestMessageState = new ShowPlayerRestMessageState()

        when: "init is called"
        showPlayerRestMessageState.init(state)

        then: "The menu should have one option and the text should be 'Sagabi is resting!'"
        menu.getOptions().size() == 1
        menu.getText() == "Sagabi is resting!"

        and: "The onRest method of the DamageCalculator should be called with the player as the argument"
        1 * dc.onRest(player)
    }
    def "init should set up the menu with the correct options and text"() {
        given: "A BattleState instance and a ShowPlayerDefenceMessageState instance"
        BattleState state = Mock(BattleState)
        Battle model = Mock(Battle)
        Menu menu = new Menu()
        PlayerBattler player = Mock(PlayerBattler)
        state.getModel() >> model
        model.getMenu() >> menu
        model.getPlayer() >> player
        ShowPlayerDefenceMessageState showPlayerDefenceMessageState = new ShowPlayerDefenceMessageState()

        when: "init is called"
        showPlayerDefenceMessageState.init(state)

        then: "The menu should have one option and the text should be 'Sagabi is defending!'"
        menu.getOptions().size() == 1
        menu.getText() == "Sagabi is defending!"

        and: "The startDefending method of the player should be called"
        1 * player.startDefending()
    }
}

