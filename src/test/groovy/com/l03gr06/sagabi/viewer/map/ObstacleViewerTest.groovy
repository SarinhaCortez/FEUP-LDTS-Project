package com.l03gr06.sagabi.viewer.map

import com.l03gr06.sagabi.gui.GUI
import com.l03gr06.sagabi.model.Position
import com.l03gr06.sagabi.model.battlers.MonsterElement
import com.l03gr06.sagabi.model.map.Room
import com.l03gr06.sagabi.model.map.entities.Obstacle
import com.l03gr06.sagabi.states.State
import com.l03gr06.sagabi.viewer.map.ObstacleViewer
import org.mockito.Mockito
import spock.lang.Specification

class ObstacleViewerTest extends Specification {

    def "test ObstacleViewer draw method"() {

        given: "A mocked GUI, State, Room, and Obstacle"
            GUI gui = Mockito.mock(GUI.class)
            State<Room> state = Mockito.mock(State.class)
            Room room = Mockito.mock(Room.class)
            Obstacle obstacle = Mockito.mock(Obstacle.class)
            MonsterElement element = Mockito.mock(MonsterElement.class)
            Mockito.when(state.getModel()).thenReturn(room)
            Mockito.when(room.getObstacles()).thenReturn([obstacle])
            Mockito.when(obstacle.getPosition()).thenReturn(new Position(1, 1))
            Mockito.when(obstacle.getId()).thenReturn("obstacleId")
            Mockito.when(room.getElement()).thenReturn(element)
            Mockito.when(element.getColor()).thenReturn("red")

        and: "An ObstacleViewer instance"
            ObstacleViewer viewer = new ObstacleViewer()

        when: "draw is called"
            viewer.draw(gui, state)

        then: "The drawObstacle method is called with the correct parameters"
            Mockito.verify(gui).drawObstacle(1, 1, "obstacleId", "red")

    }
}
