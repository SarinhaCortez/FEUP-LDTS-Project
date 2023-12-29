package com.l03gr06.sagabi.controller

import com.l03gr06.sagabi.Game
import com.l03gr06.sagabi.gui.Action
import com.l03gr06.sagabi.model.learn_state.LearnStateMenu
import com.l03gr06.sagabi.states.MainMenuState
import com.l03gr06.sagabi.states.State
import spock.lang.Specification

class LearnControllerTest extends Specification {

    def "test step method with RIGHT action"() {
        given:
        Game game = Mock(Game)
        State<LearnStateMenu> state = Mock(State)
        LearnStateMenu menu = Mock(LearnStateMenu)
        LearnController controller = new LearnController()

        when:
        state.getModel() >> menu
        controller.step(game, state, Action.RIGHT, 0)

        then:
        1 * menu.moveToNextPage()
    }

    def "test step method with LEFT action"() {
        given:
        Game game = Mock(Game)
        State<LearnStateMenu> state = Mock(State)
        LearnStateMenu menu = Mock(LearnStateMenu)
        LearnController controller = new LearnController()

        when:
        state.getModel() >> menu
        controller.step(game, state, Action.LEFT, 0)

        then:
        1 * menu.moveToPreviousPage()
    }

    def "test step method with DOWN action"() {
        given:
        Game game = Mock(Game)
        State<LearnStateMenu> state = Mock(State)
        LearnStateMenu menu = Mock(LearnStateMenu)
        LearnController controller = new LearnController()

        when:
        state.getModel() >> menu
        controller.step(game, state, Action.DOWN, 0)

        then:
        1 * game.setState(_ as MainMenuState)
    }
}