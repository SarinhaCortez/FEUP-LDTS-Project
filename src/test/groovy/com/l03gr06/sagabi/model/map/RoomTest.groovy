package com.l03gr06.sagabi.model.map

import com.l03gr06.sagabi.model.map.Room
import com.l03gr06.sagabi.model.Position
import com.l03gr06.sagabi.model.battlers.MonsterElement
import com.l03gr06.sagabi.model.map.entities.Player
import com.l03gr06.sagabi.model.map.entities.interactables.Interactable
import com.l03gr06.sagabi.model.map.entities.Obstacle

import spock.lang.Specification
import org.mockito.Mockito

class RoomTest extends Specification {

    def "Room constructor sets fields correctly"() {
        given:
        Player player = Mockito.mock(Player.class)
        List<Interactable> interactables = new ArrayList<>()
        List<Obstacle> obstacles = new ArrayList<>()
        MonsterElement element = Mockito.mock(MonsterElement.class)

        when:
        Room room = new Room(player, interactables, obstacles, element)

        then:
        room.getPlayer() == player
        room.getInteractables() == interactables
        room.getObstacles() == obstacles
        room.getElement() == element
    }

    def "addObstacle adds an obstacle to the room"() {
        given:
        Room room = new Room(Mockito.mock(Player.class), new ArrayList<>(), new ArrayList<>(), Mockito.mock(MonsterElement.class))
        Obstacle obstacle = Mockito.mock(Obstacle.class)

        when:
        room.addObstacle(obstacle)

        then:
        room.getObstacles().contains(obstacle)
    }

    def "addInteractable adds an interactable to the room"() {
        given:
        Room room = new Room(Mockito.mock(Player.class), new ArrayList<>(), new ArrayList<>(), Mockito.mock(MonsterElement.class))
        Interactable interactable = Mockito.mock(Interactable.class)

        when:
        room.addInteractable(interactable)

        then:
        room.getInteractables().contains(interactable)
    }

    def "isObstacleAt returns true if an obstacle is at the given position"() {
        given:

        Room room = new Room(Mockito.mock(Player.class), new ArrayList<>(), new ArrayList<>(), Mockito.mock(MonsterElement.class))
        Obstacle obstacle = Mockito.mock(Obstacle.class)
        Position position = Mockito.mock(Position.class)
        Mockito.when(obstacle.getPosition()).thenReturn(position)
        room.addObstacle(obstacle)

        expect:
        room.isObstacleAt(position)
    }
}