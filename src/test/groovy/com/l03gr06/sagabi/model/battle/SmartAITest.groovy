import com.l03gr06.sagabi.model.battle.monsterAI.SmartAI
import spock.lang.Specification
import com.l03gr06.sagabi.model.battlers.Attack
import com.l03gr06.sagabi.model.battlers.Battler

class SmartAITest extends Specification {

    def "chooseAttack should return the attack with the highest priority"() {
        given: "A SmartAI instance, a Battler instance, and a list of Attack instances"
        SmartAI ai = new SmartAI()
        Battler user = Mock(Battler)
        Attack attack1 = Mock(Attack) {
            getDamage() >> 10
            getHitChance() >> 90
            getEnergyCost() >> 5
        }
        Attack attack2 = Mock(Attack) {
            getDamage() >> 20
            getHitChance() >> 80
            getEnergyCost() >> 10
        }
        List<Attack> attacks = [attack1, attack2]

        and: "Stub the getAttacks method of the Battler instance"
        user.getAttacks() >> attacks

        when: "chooseAttack is called"
        Attack result = ai.chooseAttack(user, null)

        then: "The result should be the attack with the highest priority"
        assert result == attack1
    }
}