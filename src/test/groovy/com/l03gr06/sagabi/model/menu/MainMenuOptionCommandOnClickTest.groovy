package com.l03gr06.sagabi.model.menu

import com.l03gr06.sagabi.Game
import com.l03gr06.sagabi.factories.BasicMainMenuFactory
import com.l03gr06.sagabi.factories.MainMenuFactory
import com.l03gr06.sagabi.factories.RoomFactory
import com.l03gr06.sagabi.model.map.Room
import com.l03gr06.sagabi.model.map.entities.interactables.CorridorDoor
import com.l03gr06.sagabi.model.menu.mainmenucommand.ExitCommand
import com.l03gr06.sagabi.model.menu.mainmenucommand.LearnCommand
import com.l03gr06.sagabi.model.menu.mainmenucommand.PlayCommand
import com.l03gr06.sagabi.states.LearnState
import com.l03gr06.sagabi.states.MapState
import spock.lang.Specification

class MainMenuOptionCommandOnClickTest extends Specification{
    Game game;
    def setup()
    {
        game=Mock(Game);
        MainMenuFactory fac=Mock(MainMenuFactory)
        RoomFactory f=Mock(RoomFactory)
        game.getMenuFactory()>>new BasicMainMenuFactory(game)
        f.createCorridor()>>Mock(Room)
        game.getRoomFactory()>>f
    }

    def "PlayCommand onClick sets the game state as MapState"(){
        given: "A PlayCommand and game instance"
       PlayCommand playCommand = new PlayCommand(game)

        when: "onClick is called"
        playCommand.onClick()

        then: "The game state is changed as expected"
        1*game.setState({it instanceof  MapState})
    }

    def "LearnCommand onClick sets the game state as Learn"(){
        given: "A game instance and a LearnCommand"
        LearnCommand learnCommand = new LearnCommand(game)

        when: "onClick is called"
        learnCommand.onClick()

        then: "The game state is changed as expected"
        1*game.setState({it instanceof  LearnState})
   //     assert game.peekNextState() instanceof LearnState
    }
}
