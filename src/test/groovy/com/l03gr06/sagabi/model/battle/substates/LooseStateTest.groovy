package com.l03gr06.sagabi.model.battle.substates
import spock.lang.Specification
import com.l03gr06.sagabi.model.battle.Battle
import com.l03gr06.sagabi.model.menu.Menu
import com.l03gr06.sagabi.states.BattleState
import com.l03gr06.sagabi.model.menu.MenuOption

class LooseStateTest extends Specification {

    def "init should set the menu text to 'Sagabi lost!' and add a LooseAndGoToGameOverCommand option"() {
        given: "A BattleState instance and a LooseState instance"
        BattleState state = Mock(BattleState)
        Battle battle = Mock(Battle)
        Menu menu = Mock(Menu)
        state.getModel() >> battle
        battle.getMenu() >> menu
        LooseState looseState = new LooseState()

        when: "init is called"
        looseState.init(state)

        then: "The menu's text should be set to 'Sagabi lost!'"
        1 * menu.setText("Sagabi lost!")

        and: "A LooseAndGoToGameOverCommand option should be added to the menu"
        1 * menu.setOptions(_ as List<MenuOption>)
    }
}