import com.l03gr06.sagabi.Game
import com.l03gr06.sagabi.factories.AttackFactory
import com.l03gr06.sagabi.factories.MonsterElementFactory
import com.l03gr06.sagabi.model.battle.substates.BattleSubstate
import com.l03gr06.sagabi.model.battlers.MonsterElement
import com.l03gr06.sagabi.model.menu.Menu
import spock.lang.Specification
import com.l03gr06.sagabi.model.battle.Battle
import com.l03gr06.sagabi.model.battle.substates.AttackSelectState
import com.l03gr06.sagabi.model.battle.substates.HeroBaseState
import com.l03gr06.sagabi.model.battle.substates.ShowPlayerAttackMessageState
import com.l03gr06.sagabi.model.battlers.Attack
import com.l03gr06.sagabi.model.battlers.PlayerBattler
import com.l03gr06.sagabi.states.BattleState

class AttackSelectStateTest extends Specification {

    def "init should initialize the menu with the player's attacks and a quit option"() {
        given: "A BattleState instance and a PlayerBattler instance with some attacks"
        BattleState state = Mock(BattleState)
        Battle model = Mock(Battle)
        Menu menu = Mock(Menu)
        state.getModel() >> model
        model.getMenu() >> menu
        Game game=Mock(Game)
        MonsterElementFactory monsterElementFactory= Mock(MonsterElementFactory)
        monsterElementFactory.getAllElements()>>[new MonsterElement( "fire","red")]
        game.getMonsterElementFactory()>>monsterElementFactory;
        PlayerBattler player = PlayerBattler.getEmptyInstance(game)
        Attack attack1 = Mock(Attack)
        Attack attack2 = Mock(Attack)
        player.addAttack(attack1)
        player.addAttack(attack2)

        and: "An AttackSelectState instance"
        AttackSelectState attackSelectState = new AttackSelectState(game)

        when: "init is called"
        attackSelectState.init(state)

        then: "The menu's text should be set to 'Which attack: '"
        1 * menu.setText("Which attack: ")

        and: "The menu's options should be set to the player's attacks and a quit option"
        1 * menu.setOptions(_ as List)
    }


    def "getNextSubstate should return a HeroBaseState instance if attack is null"() {
        given: "An AttackSelectState instance with attack set to null"
        AttackSelectState attackSelectState = new AttackSelectState()
        attackSelectState.setAttack(null)

        when: "getNextSubstate is called"
        BattleSubstate nextSubstate = attackSelectState.getNextSubstate(Mock(Battle))

        then: "The returned instance should be a HeroBaseState instance"
        assert nextSubstate instanceof HeroBaseState
    }

    def "getNextSubstate should return a ShowPlayerAttackMessageState instance if attack is not null"() {
        given: "An AttackSelectState instance with attack set to a non-null value"
        Attack attack1 = Mock(Attack)
        AttackSelectState attackSelectState = new AttackSelectState()
        attackSelectState.setAttack(attack1)

        when: "getNextSubstate is called"
        BattleSubstate nextSubstate = attackSelectState.getNextSubstate(Mock(Battle))

        then: "The returned instance should be a ShowPlayerAttackMessageState instance"
        assert nextSubstate instanceof ShowPlayerAttackMessageState
    }
}