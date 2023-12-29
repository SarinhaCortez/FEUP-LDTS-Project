import com.l03gr06.sagabi.factories.BasicMonsterElementFactory
import com.l03gr06.sagabi.factories.MonsterElementFactory
import spock.lang.Specification
import com.l03gr06.sagabi.model.battlers.*

class BattlerTest extends Specification {

    MonsterElementFactory factory
    MonsterElement fireElement

    def setup() {
        factory = new BasicMonsterElementFactory("info/Elements.txt")
        fireElement = factory.getElement("fire")
    }
    def "test subtractEnergy method"() {
        given: "A Battler instance with energy"
        Stats stats = new Stats(100, 100, 100, 100, [fireElement: 100], [fireElement:100])
        Battler battler = new ConcreteBattler(stats, fireElement, [], 1, "Test")
        Integer energy = battler.getCurrentEnergy()

        when: "subtractEnergy is called"
        battler.subtractEnergy(subtractAmount)

        then: "Energy is subtracted correctly"
        battler.getCurrentEnergy() == Math.max(0, energy - subtractAmount)

        where:
        subtractAmount || _
        50             || _
        0              || _
        -10            || _
        1000           || _
    }
    def "test addEnergy method"() {
        given: "A Battler instance with less than max energy"
        Stats stats = new Stats(100, 100, 100, 100, [fireElement: 100], [fireElement:100])
        Battler battler = new ConcreteBattler(stats, fireElement, [], 1, "Test")
        battler.getCurrentEnergy()
        battler.subtractEnergy(50)

        Integer energy = battler.getCurrentEnergy()

        when: "addEnergy is called"
        battler.addEnergy(addAmount)

        then: "Energy is increased correctly"
        battler.getCurrentEnergy() == Math.min(100, energy + addAmount)
        where:
        addAmount || _
        0          || _
        -10        || _
    }



    def "test heal method"() {
        given: "A Battler instance with less than max health"
        Stats stats = new Stats(100, 100, 100, 100, [fireElement: 100], [fireElement:100])
        Battler battler = new ConcreteBattler(stats, fireElement, [], 1, "Test")
        battler.damage(50)
        Integer health = battler.getCurrentHealth()

        when: "heal is called"
        battler.heal(healAmount)

        then: "Health is increased correctly"
        battler.getCurrentHealth() == Math.min(100, health + healAmount)

        where:
        healAmount || _
        0          || _
        -10        || _
    }

    def "test damage method"() {
        given: "A Battler instance with health"
        Stats stats = new Stats(100, 100, 100, 100, [fireElement: 100],[fireElement:100])
        Battler battler = new ConcreteBattler(stats, fireElement, [], 1, "Test")
        Integer health = battler.getCurrentHealth()

        when: "damage is called"
        battler.damage(damageAmount)

        then: "Health is decreased correctly"
        battler.getCurrentHealth() == Math.max(0, health - damageAmount)

        where:
        damageAmount || _
        50           || _
        0            || _
        -10          || _
        1000         || _
    }

    def "test isDead method"() {
        given: "A Battler instance with 0 health"
        Stats stats = new Stats(0, 100, 100, 100, [fireElement: 100], [fireElement:100])
        Battler battler = new ConcreteBattler(stats, fireElement, [], 1, "Test")

        expect: "isDead returns true"
        battler.isDead() == true
    }

    

    def "test isTired method"() {
        given: "A Battler instance with less energy than the cost of all attacks"
        Stats stats = new Stats(100, 100, 100, 100, [fireElement: 100], [fireElement:100])
        Attack attack = new Attack("Test", fireElement, 80, 200, 0, 200)
        Battler battler = new ConcreteBattler(stats, fireElement, [attack], 1, "Test")

        expect: "isTired returns true"
        battler.isTired() == true
    }
}

class ConcreteBattler extends Battler {

    ConcreteBattler(Stats stats, MonsterElement element, List<Attack> attacks, int level, String name) {
        super(stats, element, attacks, level, name)
    }
}