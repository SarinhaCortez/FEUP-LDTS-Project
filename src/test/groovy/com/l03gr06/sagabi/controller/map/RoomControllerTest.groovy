package com.l03gr06.sagabi.controller.map

import com.l03gr06.sagabi.Game;
import com.l03gr06.sagabi.controller.map.InteractableController;
import com.l03gr06.sagabi.controller.map.PlayerController;
import com.l03gr06.sagabi.controller.map.RoomController;
import com.l03gr06.sagabi.gui.Action;
import com.l03gr06.sagabi.model.map.Room;
import com.l03gr06.sagabi.states.State;
import org.mockito.Mockito;
import spock.lang.Specification;

class RoomControllerTest extends Specification {

    def "test RoomController step with action = #action"() {
        given: "a RoomController, a mock Game, a mock State, a mock PlayerController, and a mock InteractableController"

        Game game = Mockito.mock(Game.class)
        State<Room> state = Mockito.mock(State.class)
        PlayerController playerController = Mockito.mock(PlayerController.class)
        InteractableController interactableController = Mockito.mock(InteractableController.class)
        GoToPauseController pauseController= Mock(GoToPauseController)
        RoomController roomController = new RoomController(playerController, interactableController,pauseController)

        when: "step is called"
        roomController.step(game, state, action, 0)

        then: "verify that the step method was called on the PlayerController and InteractableController"
        Mockito.verify(playerController).step(game, state, action, 0)
        Mockito.verify(interactableController).step(game, state, action, 0)

        where:
        action << [Action.RIGHT, Action.LEFT, Action.UP, Action.DOWN]
    }
}