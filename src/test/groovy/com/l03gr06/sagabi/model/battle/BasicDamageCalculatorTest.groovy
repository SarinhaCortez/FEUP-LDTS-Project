package com.l03gr06.sagabi.model.battle

import com.l03gr06.sagabi.factories.BasicMonsterElementFactory
import com.l03gr06.sagabi.model.battle.damageCalculator.BasicDamageCalculator
import com.l03gr06.sagabi.model.battlers.Attack
import com.l03gr06.sagabi.model.battlers.Battler
import com.l03gr06.sagabi.model.battlers.MonsterElement
import com.l03gr06.sagabi.factories.MonsterElementFactory
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class BasicDamageCalculatorTest extends Specification {

    @Shared
    List<MonsterElement> allElementsForTarget = new BasicMonsterElementFactory("info/Elements.txt").getAllElements()
    @Shared
    List<MonsterElement> allElementsForUser = new BasicMonsterElementFactory("info/Elements.txt").getAllElements()

    @Unroll
    def "test useAttack from monster #targetElement to user #userElement"() {
        given: "A BasicDamageCalculator instance, an Attack instance, and two Battler instances"
        BasicDamageCalculator calculator = new BasicDamageCalculator()
        Attack attack = Mock(Attack)
        Battler user = Mock(Battler)
        Battler target = Mock(Battler)

        and: "Stub the methods of the Attack and Battler instances"
        attack.getHitChance() >> 100
        attack.getName() >> "Attack"
        attack.getDamage() >> 10
        attack.getElement() >> targetElement
        attack.getHeal() >> 0
        attack.getEnergyCost() >> 5
        user.getName() >> "User"
        user.getAttackStat(targetElement) >> 10
        target.getName() >> "Target"
        target.getDefenceStat(targetElement) >> 5
        target.isDefending() >> false
        user.getElement() >> userElement
        target.getElement() >> targetElement

        when: "useAttack is called"
        String result = calculator.useAttack(attack, user, target)

        then: "The result should be as expected"
        result.contains("User used Attack!")
        if (targetElement.isWeakAgainst(userElement)) {
            result.contains("It was very effective!")
            result.contains("Target lost 20 hp!")
        }
        if (targetElement.isResistantAgainst(userElement)) {
            result.contains("Target resisted the attack!")
            result.contains("Target lost 10 hp!")
        }

        result.contains("Lost 5 energy!")

        where:
        targetElement << allElementsForTarget
        userElement << allElementsForUser
    }
    def "onTurnBegin should stop battler from defending"() {
        given: "A BasicDamageCalculator instance and a Battler instance"
        BasicDamageCalculator calculator = new BasicDamageCalculator()
        Battler battler = Mock(Battler)

        when: "onTurnBegin is called"
        calculator.onTurnBegin(battler)

        then: "stopDefending should be called on the battler"
        1 * battler.stopDefending()
    }

    def "onRest should add energy to battler"() {
        given: "A BasicDamageCalculator instance and a Battler instance"
        BasicDamageCalculator calculator = new BasicDamageCalculator()
        Battler battler = Mock(Battler)

        and: "Stub the getEnergyRecovery method of the Battler instance"
        battler.getEnergyRecovery() >> 10

        when: "onRest is called"
        calculator.onRest(battler)

        then: "addEnergy should be called on the battler with the correct amount of energy"
        1 * battler.addEnergy(10)
    }
}
