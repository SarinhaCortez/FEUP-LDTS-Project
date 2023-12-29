package com.l03gr06.sagabi.viewer.map

import com.l03gr06.sagabi.gui.GUI
import com.l03gr06.sagabi.model.Position
import com.l03gr06.sagabi.model.battlers.MonsterBattler
import com.l03gr06.sagabi.model.battlers.MonsterElement
import com.l03gr06.sagabi.model.map.Room
import com.l03gr06.sagabi.model.map.entities.interactables.*
import com.l03gr06.sagabi.states.State
import com.l03gr06.sagabi.viewer.map.interactable.*
import org.mockito.Mockito
import spock.lang.Specification

class InteractableViewerTest extends Specification {
    
    GUI gui

    def setup() {
        gui = Mockito.mock(GUI.class)
    }

    def "test DoorViewer draw method"() {
        given: "A mocked GUI and Door"
            Door door = Mockito.mock(Door.class)
            Mockito.when(door.getPosition()).thenReturn(new Position(1, 1))
            Mockito.when(door.isOpen()).thenReturn(true) 

        and: "A DoorViewer instance"
            DoorViewer viewer = new DoorViewer()

        when: "draw is called"
            viewer.draw(gui, door)

        then: "The drawOpenDoor method is called with the correct parameters"
            Mockito.verify(gui).drawOpenDoor(1, 1, "white")
    }

    def "test HealViewer draw method"() {
        given: "A mocked GUI and HealSpot"
            HealSpot healSpot = Mockito.mock(HealSpot.class)
            Mockito.when(healSpot.getPosition()).thenReturn(new Position(1, 1))

        and: "A HealViewer instance"
            HealViewer viewer = new HealViewer()

        when: "draw is called"
            viewer.draw(gui, healSpot)

        then: "The drawHealSpot method is called with the correct parameters"
            Mockito.verify(gui).drawHealSpot(1, 1)
    }



    def "test MonsterViewer draw method"() {
        given: "A mocked GUI and Monster"
            Monster monster = Mockito.mock(Monster.class)
            MonsterBattler monsterBattler = Mockito.mock(MonsterBattler.class)
            MonsterElement element = Mockito.mock(MonsterElement.class)

            Mockito.when(monster.getPosition()).thenReturn(new Position(1, 1))
            Mockito.when(monster.getId()).thenReturn("monsterId")
            Mockito.when(monster.getMonsterBattler()).thenReturn(monsterBattler)
            Mockito.when(monsterBattler.getElement()).thenReturn(element)
            Mockito.when(element.getColor()).thenReturn("red")

        and: "A MonsterViewer instance"
            MonsterViewer viewer = new MonsterViewer()

        when: "draw is called"
            viewer.draw(gui, monster)

        then: "The drawMonster method is called with the correct parameters"
            Mockito.verify(gui).drawMonster(1, 1, "monsterId", "red")
    }

    def "test InteractableViewer draw method"() {

        given: "A mocked GUI, State, and Room"
            State<Room> state = Mock(State)
            Room room = Mock(Room)
            Position position = new Position(1, 1) 
            CorridorDoor corridorDoor = Mock(CorridorDoor)
            HealRoomDoor healRoomDoor = Mock(HealRoomDoor)
            BattleRoomDoor battleRoomDoor = Mock(BattleRoomDoor)
            HealSpot healSpot = Mock(HealSpot)
            Monster monster = Mock(Monster)
            MonsterBattler monsterBattler = Mock(MonsterBattler)
            MonsterElement monsterElement = Mock(MonsterElement)
            DoorViewer doorViewer = Mock(DoorViewer)
            MonsterViewer monsterViewer = Mock(MonsterViewer)
            HealViewer healViewer = Mock(HealViewer)

            state.getModel() >> room
            room.getInteractables() >> [corridorDoor, healRoomDoor, battleRoomDoor, healSpot, monster]
            corridorDoor.getPosition() >> position 
            healRoomDoor.getPosition() >> position
            battleRoomDoor.getPosition() >> position
            healSpot.getPosition() >> position
            monster.getPosition() >> position
            monster.getMonsterBattler() >> monsterBattler
            monsterBattler.getElement() >> monsterElement
            doorViewer.accepts(corridorDoor) >> true
            doorViewer.accepts(healRoomDoor) >> true
            doorViewer.accepts(battleRoomDoor) >> true
            monsterViewer.accepts(monster) >> true
            healViewer.accepts(healSpot) >> true

        and: "An InteractableViewer instance"
            InteractableViewer viewer = new InteractableViewer(doorViewer, monsterViewer, healViewer)

        when: "draw is called"
            viewer.draw(gui, state)

        then: "The draw method is called on each viewer for each interactable"
            1 * doorViewer.draw(gui, corridorDoor)
            1 * doorViewer.draw(gui, healRoomDoor)
            1 * doorViewer.draw(gui, battleRoomDoor)
            1 * monsterViewer.draw(gui, monster)
            1 * healViewer.draw(gui, healSpot)
    }

}
//THROW A TAL EXCEPTION