package com.l03gr06.sagabi.states

import com.l03gr06.sagabi.Game
import com.l03gr06.sagabi.controller.LearnController
import com.l03gr06.sagabi.controller.menu.MainMenuController
import com.l03gr06.sagabi.factories.MonsterElementFactory
import com.l03gr06.sagabi.model.battlers.PlayerBattler
import com.l03gr06.sagabi.model.map.Room
import com.l03gr06.sagabi.model.menu.Menu
import com.l03gr06.sagabi.viewer.LearnViewer
import com.l03gr06.sagabi.viewer.PauseMenuViewer
import spock.lang.Specification

class PauseStateTest extends Specification {

    Game game;
    def setup()
    {
        game = Mock(Game)
        MonsterElementFactory elFac= Mock(MonsterElementFactory)
        game.getMonsterElementFactory()>>elFac
        elFac.getAllElements()>>[]
        game.getMonsterFactory()>>Mock(MonsterElementFactory)
        PlayerBattler b= PlayerBattler.getEmptyInstance(game)
    }
    def "menu should have four options"() {
        given:
        PauseMenuState state= new PauseMenuState(null,game);
        when:
        Menu menu = state.getModel();
        then:
        assert(menu.getOptions().size()==4);
    }

    def "getViewer should return PauseMenuViewer and getController should return MainMenuController"() {
        given:
        PauseMenuState state= new PauseMenuState(null,game);
        when:
        MainMenuController control = state.getController();
        PauseMenuViewer viewer= state.getViewer();
        then:
        assert(control instanceof MainMenuController);
        assert(viewer instanceof PauseMenuViewer);
    }

}
