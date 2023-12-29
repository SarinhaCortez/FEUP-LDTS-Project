package com.l03gr06.sagabi.model.battle.substates

import com.l03gr06.sagabi.model.battle.Battle
import com.l03gr06.sagabi.model.menu.Menu
import com.l03gr06.sagabi.model.menu.MenuOption
import com.l03gr06.sagabi.states.BattleState
import spock.lang.Specification

class WinStateTest extends Specification{
    def "init should set the menu text to 'Sagabi won!' and add a WinAndBackToRoomCommand option"(){
        given: "A BattleState instance and a WinState instance"
        BattleState state = Mock(BattleState)
        Battle battle = Mock(Battle)
        Menu menu = Mock(Menu)
        state.getModel() >> battle
        battle.getMenu() >> menu
        WinState winState = new WinState()

        when: "init is called"
        winState.init(state)

        then: "The menu's text should be set to 'Sagabi won!'"
        1 * menu.setText("Sagabi won!")

        and: "A WinAndBackToRoomCommand option should be added to the menu"
        1 * menu.setOptions(_ as List<MenuOption>)
    }
}
