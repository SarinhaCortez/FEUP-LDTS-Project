
package com.l03gr06.sagabi.model.map

import com.l03gr06.sagabi.Game
import com.l03gr06.sagabi.factories.BasicMonsterElementFactory
import com.l03gr06.sagabi.factories.RoomFactory
import com.l03gr06.sagabi.model.battlers.MonsterBattler
import com.l03gr06.sagabi.model.battlers.MonsterElement
import com.l03gr06.sagabi.model.map.Room
import com.l03gr06.sagabi.model.map.entities.interactables.CorridorDoor
import com.l03gr06.sagabi.model.map.entities.interactables.Door
import com.l03gr06.sagabi.model.map.entities.interactables.HealRoomDoor
import com.l03gr06.sagabi.states.MapState
import com.l03gr06.sagabi.model.map.entities.interactables.BattleRoomDoor
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class BattleRoomDoorTest extends Specification {

    @Shared
    List<MonsterElement> allElements = new BasicMonsterElementFactory("info/Elements.txt").getAllElements()

    @Unroll
    def "test BattleRoomDoor onCollision with #element"() {
        given: "a BattleRoomDoor with a specific MonsterElement and a mock RoomFactory"

            Game game = Mock(Game);
            BattleRoomDoor battleRoomDoor = new BattleRoomDoor(4,4, element,game)
            Room room = Mock(Room)
            RoomFactory roomFactory = Mock(RoomFactory)
            roomFactory.createBattleRoom(element) >> room
            game.getRoomFactory()>>roomFactory

        when: "onCollision is called"
            battleRoomDoor.onCollision()

        then: "verify that the setState method was called with a MapState that has the correct Room"

           1* game.setState({it instanceof MapState && it.getModel()==room})
        //    game.peekNextState().getModel()==room
        where:
            element << allElements
    }
}

class CorridorDoorTest extends Specification {

    def "test CorridorDoor onCollision with door open = #doorIsOpen"() {
        given: "a CorridorDoor and a mock RoomFactory"
            Game game = Mock(Game);
            CorridorDoor corridorDoor = new CorridorDoor(0, 0, doorIsOpen,game)
            Room room = Mock(Room)
            RoomFactory roomFactory = Mock(RoomFactory)
            roomFactory.createCorridor() >> room
            game.getRoomFactory() >> roomFactory

        when: "onCollision is called"
            corridorDoor.onCollision()

        then: "verify that the setState method was called with a MapState that has the correct Room"
            if (corridorDoor.isOpen()) {
                1* game.setState({it instanceof MapState && it.getModel()==room})
            } else {
                0* game.setState(_)
            }

        where:
            doorIsOpen << [true, false]
    }
}

class HealRoomDoorTest extends Specification {

    def "test HealRoomDoor onCollision with door open = #doorIsOpen"() {

        given: "a HealRoomDoor and a mock RoomFactory"
            Game game = Mock(Game);
            HealRoomDoor healRoomDoor = new HealRoomDoor(0, 0,doorIsOpen,game)
            Room room = Mock(Room)
            RoomFactory roomFactory = Mock(RoomFactory)
            roomFactory.createHealRoom() >> room
            game.getRoomFactory()>>roomFactory

        when: "onCollision is called"
            healRoomDoor.onCollision()

        then: "verify that the setState method was called with a MapState that has the correct Room"
            if (doorIsOpen) {
                1* game.setState({it instanceof MapState && it.getModel()==room})
            } else {
                game.peekNextState() ==null
            }

        where:
            doorIsOpen << [true, false]
    }
}
class GenericDoorTest extends Specification {

    def "test onMonsterDefeated"() {
        given: "A Door instance and a MonsterBattler instance"
            Door door = Mock(Door)
            MonsterBattler battler = Mock(MonsterBattler)
            door.isOpen() >> false

        when: "onMonsterDefeated is called with monstersLeft equal to 0"
            door.onMonsterDefeated(battler, 0)

        then: "The open method is called on the door"
            door.open()
    }
}