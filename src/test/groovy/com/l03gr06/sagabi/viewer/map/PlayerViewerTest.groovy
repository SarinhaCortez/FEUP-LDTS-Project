package com.l03gr06.sagabi.viewer.map

import com.l03gr06.sagabi.gui.GUI
import com.l03gr06.sagabi.model.Position
import com.l03gr06.sagabi.model.map.Room
import com.l03gr06.sagabi.model.map.entities.Player
import com.l03gr06.sagabi.states.State
import com.l03gr06.sagabi.viewer.map.PlayerViewer
import org.mockito.Mockito
import spock.lang.Specification

class PlayerViewerTest extends Specification{
    def "test PlayerViewer draw method"() {
        given: "A mocked GUI, State, Room, and Player"
        GUI gui = Mockito.mock(GUI.class)
        State<Room> state = Mockito.mock(State.class)
        Room room = Mockito.mock(Room.class)
        Player player = Mockito.mock(Player.class)
        Mockito.when(state.getModel()).thenReturn(room)
        Mockito.when(room.getPlayer()).thenReturn(player)
        Mockito.when(player.getPosition()).thenReturn(new Position(1, 1))

        and: "A PlayerViewer instance"
        PlayerViewer viewer = new PlayerViewer()

        when: "draw is called"
        viewer.draw(gui, state)

        then: "The drawPlayer method is called with the correct parameters"
        Mockito.verify(gui).drawPlayer(1, 1)
    }
}
