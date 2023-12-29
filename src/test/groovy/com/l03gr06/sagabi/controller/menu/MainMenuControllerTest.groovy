package com.l03gr06.sagabi.controller.menu

import com.l03gr06.sagabi.controller.menu.MainMenuController
import com.l03gr06.sagabi.states.MainMenuState
import com.l03gr06.sagabi.model.menu.MenuOption
import spock.lang.Specification
import com.l03gr06.sagabi.Game
import com.l03gr06.sagabi.model.menu.Menu
import com.l03gr06.sagabi.states.State
import com.l03gr06.sagabi.gui.Action

class MainMenuControllerTest extends Specification {

    MainMenuController mainMenuController
    Game game
    State<Menu> state
    Menu menu

    def setup() {
        mainMenuController = new MainMenuController()
        game = Mock(Game)
        state = Mock(MainMenuState)
        menu = Mock(Menu)
        state.getModel() >> menu
    }

    def "test step with UP action"() {
        when:
        mainMenuController.step(game, state, Action.UP, 0)

        then:
        1 * menu.scrollUp()
    }

    def "test step with DOWN action"() {
        when:
        mainMenuController.step(game, state, Action.DOWN, 0)

        then:
        1 * menu.scrollDown()
    }

    def "test step with SELECT action"() {
        setup:
        MenuOption option = Mock(MenuOption)
        menu.getCurrentOption() >> option

        when:
        mainMenuController.step(game, state, Action.SELECT, 0)

        then:
        1 * option.onClick()
    }
}