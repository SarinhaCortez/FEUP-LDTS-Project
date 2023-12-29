package com.l03gr06.sagabi.controller.map
import com.l03gr06.sagabi.Game
import com.l03gr06.sagabi.controller.map.PlayerController
import com.l03gr06.sagabi.gui.Action
import com.l03gr06.sagabi.model.Position
import com.l03gr06.sagabi.model.map.Room
import com.l03gr06.sagabi.model.map.entities.Player
import com.l03gr06.sagabi.states.State
import org.mockito.Mockito
import spock.lang.Specification

class PlayerControllerTest extends Specification {

    def "test PlayerController step with action = #action"() {

        given: "a PlayerController, a mock Game, a mock State, and a mock Room"
            PlayerController playerController = new PlayerController()
            Game game = Mockito.mock(Game.class)
            State<Room> state = Mockito.mock(State.class)
            Room room = Mockito.mock(Room.class)
            Player player = Mockito.mock(Player.class)
            Position position = new Position(0, 0)
            Mockito.when(state.getModel()).thenReturn(room)
            Mockito.when(room.getPlayer()).thenReturn(player)
            Mockito.when(player.getPosition()).thenReturn(position)
            Mockito.when(room.isObstacleAt(Mockito.any())).thenReturn(false)

        when: "step is called"
            playerController.step(game, state, action, 0)

        then: "verify that the player's position was updated correctly"
            Position newPosition = getNewPosition(action, position)
            Mockito.verify(room.getPlayer()).setPosition(newPosition)

        where:
            action << [Action.RIGHT, Action.LEFT, Action.UP, Action.DOWN]
    }

    private Position getNewPosition(Action action, Position position) {
        switch (action) {
            case Action.RIGHT:
                return position.right()
            case Action.LEFT:
                return position.left()
            case Action.UP:
                return position.up()
            case Action.DOWN:
                return position.down()
        }
    }
}
//working