package com.l03gr06.sagabi.controller.map

import com.l03gr06.sagabi.Game
import com.l03gr06.sagabi.model.map.Room
import com.l03gr06.sagabi.states.MapState
import com.l03gr06.sagabi.states.State
import com.l03gr06.sagabi.gui.Action
import spock.lang.Specification

class GoToPauseControllerTest extends Specification {

    def "test step method"() {
        given:
        Game game = Mock(Game)
        Room model = Mock(Room)
        State<Room> state = new MapState(model);
        GoToPauseController controller = new GoToPauseController()

        when:
        controller.step(game, state, Action.SELECT, 0)

        then:
        1 * game.setState(_)
    }
}