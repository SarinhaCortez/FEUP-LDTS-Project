package com.l03gr06.sagabi.model.battle.substates

import com.l03gr06.sagabi.Game
import com.l03gr06.sagabi.model.menu.Menu
import com.l03gr06.sagabi.model.menu.battlemenucommand.DefendCommand
import com.l03gr06.sagabi.model.menu.battlemenucommand.GetOutOfWantToAttackMenuCommand
import com.l03gr06.sagabi.model.menu.battlemenucommand.LooseAndGoToGameOverCommand
import com.l03gr06.sagabi.model.menu.battlemenucommand.RestOptionCommand
import com.l03gr06.sagabi.states.BattleState
import com.l03gr06.sagabi.model.battle.substates.HeroBaseState
import com.l03gr06.sagabi.states.GameOverState
import com.l03gr06.sagabi.states.MainMenuState
import spock.lang.Specification

class MenuCommandsOnClickTest extends Specification{
    def "test DefendCommand onClick"() {
        given: "A DefendCommand instance, a HeroBaseState owner, and a BattleState state"
        HeroBaseState owner = Mock(HeroBaseState)
        BattleState state = Mock(BattleState)
        Game game=Mock(Game);
        DefendCommand defendCommand = new DefendCommand(state, owner,game)

        when: "onClick is called"
        defendCommand.onClick()

        then: "The next state of the owner should be set to ShowPlayerDefenceMessageState and moveToNextState should be called on the state"
        1 * owner.setNextState(_ as ShowPlayerDefenceMessageState)
        1 * state.moveToNextState()
    }
    def "test GetOutOfWantToAttackMenuCommand onClick"() {
        given: "A GetOutOfWantToAttackMenuCommand instance, a BattleState state, and an AttackSelectState owner"
        BattleState state = Mock(BattleState)
        AttackSelectState owner = Mock(AttackSelectState)
        GetOutOfWantToAttackMenuCommand command = new GetOutOfWantToAttackMenuCommand(state, owner)

        when: "onClick is called"
        command.onClick()

        then: "The attack of the owner should be set to null and moveToNextState should be called on the state"
        1 * owner.setAttack(null)
        1 * state.moveToNextState()
    }
    /*def "test LooseAndGoToGameOverCommand onClick"() {

        given: "A LooseAndGoToGameOverCommand instance, a BattleState state, and a Game instance"
        Menu menu = Mock(Menu)
        Game.getInstance().setState(new MainMenuState(menu))
        BattleState state = Mock(BattleState)
        LooseAndGoToGameOverCommand command = new LooseAndGoToGameOverCommand(state)
        Game game = Mock(Game)
        Game.metaClass.static.getInstance = { -> game }

        when: "onClick is called"
        command.onClick()

        then: "The state of the game should be set to GameOverState"
        1 * game.setState({ it instanceof GameOverState })

        cleanup:
        Game.metaClass = null
    }*/

    def "test RestOptionCommand onClick"() {
        given: "A RestOptionCommand instance, a BattleState state, and a HeroBaseState owner"
        BattleState state = Mock(BattleState)
        HeroBaseState owner = Mock(HeroBaseState)
        Game game=Mock(Game)
        RestOptionCommand command = new RestOptionCommand(state, owner,game)

        when: "onClick is called"
        command.onClick()

        then: "The next state of the owner should be set to ShowPlayerRestMessageState and moveToNextState should be called on the state"
        1 * owner.setNextState(_ as ShowPlayerRestMessageState)
        1 * state.moveToNextState()
    }

}
