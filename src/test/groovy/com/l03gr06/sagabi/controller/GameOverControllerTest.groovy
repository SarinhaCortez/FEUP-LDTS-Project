package com.l03gr06.sagabi.controller

import com.l03gr06.sagabi.Game
import com.l03gr06.sagabi.factories.AttackFactory
import com.l03gr06.sagabi.factories.MainMenuFactory
import com.l03gr06.sagabi.factories.MonsterElementFactory
import com.l03gr06.sagabi.gui.Action
import com.l03gr06.sagabi.model.game_over_state.GameOverStateMessage
import com.l03gr06.sagabi.states.State
import com.l03gr06.sagabi.states.GameOverState

import spock.lang.Specification

class GameOverControllerTest extends Specification {

    def "test step method"() {
        given:
        Game game = Mock(Game)
        GameOverStateMessage model = Mock(GameOverStateMessage)
        State<GameOverStateMessage> state = new GameOverState(model);
        GameOverController controller = new GameOverController()
        MonsterElementFactory elFac=Mock(MonsterElementFactory)
        elFac.getAllElements()>>[]
        AttackFactory attackFactory=Mock(AttackFactory)
        attackFactory.getXRandomAttacks()>>[]
        MainMenuFactory factory= Mock(MainMenuFactory)
        game.getMonsterElementFactory()>>elFac;
        game.getAttackFactory()>>attackFactory
        game.getMenuFactory()>>factory;

        when:
        controller.step(game, state, Action.SELECT, 0)

        then:
        1 * game.setState(_)
    }
}
//working