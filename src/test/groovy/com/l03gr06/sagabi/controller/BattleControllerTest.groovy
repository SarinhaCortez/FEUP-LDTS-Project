package com.l03gr06.sagabi.controller

import com.l03gr06.sagabi.Game
import com.l03gr06.sagabi.gui.Action
import com.l03gr06.sagabi.model.battle.Battle
import com.l03gr06.sagabi.states.State
import com.l03gr06.sagabi.controller.BattleController
import com.l03gr06.sagabi.model.menu.Menu
import com.l03gr06.sagabi.model.menu.MenuOption
import spock.lang.Specification
import spock.lang.Unroll

class BattleControllerTest extends Specification {

    @Unroll
    def "test step method with action #action"() {
        given:
        Game game = Mock(Game)
        State<Battle> state = Mock(State)
        Battle battle = Mock(Battle)
        Menu menu = Mock(Menu)
        MenuOption option = Mock(MenuOption)
        BattleController controller = new BattleController()

        state.getModel() >> battle
        battle.getMenu() >> menu
        menu.getCurrentOption() >> option

        when:
        controller.step(game, state, action, 0)

        then:
        if (action == Action.SELECT) {
            1 * option.onClick()
        } else {
            1 * menu."$method"()
        }

        where:
        action    || method
        Action.UP || 'scrollUp'
        Action.DOWN || 'scrollDown'
        Action.SELECT || 'onClick'
    }
}