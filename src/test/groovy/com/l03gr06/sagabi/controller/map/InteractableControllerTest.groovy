package com.l03gr06.sagabi.controller.map
import com.l03gr06.sagabi.Game
import com.l03gr06.sagabi.controller.map.InteractableController
import com.l03gr06.sagabi.gui.Action
import com.l03gr06.sagabi.model.Position
import com.l03gr06.sagabi.model.map.Room
import com.l03gr06.sagabi.model.map.entities.Player
import com.l03gr06.sagabi.model.map.entities.interactables.Interactable
import com.l03gr06.sagabi.states.State
import org.mockito.Mockito
import spock.lang.Specification

class InteractableControllerTest extends Specification {

    def "test InteractableController step with action = #action"() {
        given: "an InteractableController, a mock Game, a mock State, a mock Room, a mock Player, and a mock Interactable"
        InteractableController interactableController = new InteractableController()
        Game game = Mockito.mock(Game.class)
        State<Room> state = Mockito.mock(State.class)
        Room room = Mockito.mock(Room.class)
        Player player = Mockito.mock(Player.class)
        Interactable interactable = Mockito.mock(Interactable.class)
        Position position = new Position(0, 0)
        Mockito.when(state.getModel()).thenReturn(room)
        Mockito.when(room.getPlayer()).thenReturn(player)
        Mockito.when(player.getPosition()).thenReturn(position)
        Mockito.when(room.getInteractables()).thenReturn([interactable])
        Mockito.when(interactable.getPosition()).thenReturn(position)

        when: "step is called"
        interactableController.step(game, state, action, 0)

        then: "verify that the onCollision method was called on the Interactable"
        Mockito.verify(interactable).onCollision()

        where:
        action << [Action.RIGHT, Action.LEFT, Action.UP, Action.DOWN]
    }
}
//working