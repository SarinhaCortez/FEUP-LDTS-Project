package com.l03gr06.sagabi.viewer.map

import com.l03gr06.sagabi.gui.GUI
import com.l03gr06.sagabi.model.Position
import com.l03gr06.sagabi.model.map.Room
import com.l03gr06.sagabi.model.map.entities.Obstacle
import com.l03gr06.sagabi.model.map.entities.Player
import com.l03gr06.sagabi.model.map.entities.interactables.Interactable
import com.l03gr06.sagabi.states.State
import com.l03gr06.sagabi.viewer.map.ObstacleViewer
import com.l03gr06.sagabi.viewer.map.PlayerViewer
import com.l03gr06.sagabi.viewer.map.RoomViewer
import com.l03gr06.sagabi.viewer.map.interactable.InteractableViewer
import spock.lang.Specification

class RoomViewerTest extends Specification {
    
    def "test RoomViewer draw method"() {
        given: "A mocked GUI, State, Room, InteractableViewer, ObstacleViewer, and PlayerViewer"
            GUI gui = Mock(GUI)
            State<Room> state = Mock(State)
            Room room = Mock(Room)
            Player player = Mock(Player)
            Position position = new Position(1, 1)
            InteractableViewer interactableViewer = Mock(InteractableViewer)
            ObstacleViewer obstacleViewer = Mock(ObstacleViewer)
            PlayerViewer playerViewer = Mock(PlayerViewer)
            Interactable interactable = Mock(Interactable)
            List interactables = [interactable]
            Obstacle obstacle = Mock(Obstacle)
            List obstacles = [obstacle]
            state.getModel() >> room
            room.getPlayer() >> player
            room.getInteractables() >> interactables
            room.getObstacles() >> obstacles
            player.getPosition() >> position
            interactable.getPosition() >> position
            obstacle.getPosition() >> position
            
        and: "A RoomViewer instance"
            RoomViewer viewer = new RoomViewer(interactableViewer, obstacleViewer, playerViewer)

        when: "draw is called"
            viewer.draw(gui, state)

        then: "The draw method is called on each viewer with the correct parameters"
            1 * interactableViewer.draw(gui, state)
            1 * obstacleViewer.draw(gui, state)
            1 * playerViewer.draw(gui, state)
    }
}