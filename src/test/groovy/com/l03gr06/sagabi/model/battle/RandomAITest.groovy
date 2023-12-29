package com.l03gr06.sagabi.model.battle

import com.l03gr06.sagabi.model.battle.monsterAI.RandomAI
import spock.lang.Specification
import spock.lang.Specification
import com.l03gr06.sagabi.model.battlers.Attack
import com.l03gr06.sagabi.model.battlers.Battler

class RandomAITest extends Specification {

    def "chooseAttack should return null or an attack from the user's attacks"() {
        given: "A RandomAI instance, a Battler instance, and a list of Attack instances"
        RandomAI ai = new TestableRandomAI()
        Battler user = Mock(Battler)
        Attack attack1 = Mock(Attack)
        Attack attack2 = Mock(Attack)
        List<Attack> attacks = [attack1, attack2]

        and: "Stub the getAttacks method of the Battler instance"
        user.getAttacks() >> attacks

        when: "chooseAttack is called"
        Attack result = ai.chooseAttack(user, null)

        then: "The result should be null or an attack from the user's attacks"
        assert result == null || attacks.contains(result)
    }

    class TestableRandomAI extends RandomAI {
        @Override
        protected float getRandomFloat() {
            return 0.5f; // Replace with the desired value for testing
        }

        @Override
        protected int getRandomInt(int bound) {
            return 0; // Replace with the desired value for testing
        }
    }
}