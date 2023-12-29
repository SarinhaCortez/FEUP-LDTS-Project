
package com.l03gr06.sagabi.gui

import com.googlecode.lanterna.TerminalPosition
import com.googlecode.lanterna.TextCharacter
import com.googlecode.lanterna.TextColor
import com.googlecode.lanterna.graphics.BasicTextImage
import com.googlecode.lanterna.graphics.TextGraphics
import com.googlecode.lanterna.input.KeyType
import com.googlecode.lanterna.screen.Screen
import com.l03gr06.sagabi.model.map.entities.interactables.Monster
import spock.lang.Specification

import javax.swing.KeyStroke

class LanternaGUITest extends Specification {

    private TextGraphics graphics
    private Screen screenMock = Mock(Screen)
    private String colorPath = "graphics/Colors.txt"
    private String monsterImagePath = "info/MonsterImages.txt"
    private LanternaGUI gui

    def setup() {
        graphics = Mock(TextGraphics)
        gui = new LanternaGUI(200, 200, graphics, colorPath, screenMock, monsterImagePath)
    }

    def "drawCharacterTest"() {
        given:
        def x = 1
        def y = 1
        def c = 'H'
        def color = "#336699"

        when:
        gui.drawCharacter(x, y, c as char, color, graphics)

        then:
        1 * graphics.setForegroundColor(TextColor.Factory.fromString(color))
        1 * graphics.setCharacter(x, y, c)
    }

    def "drawStringNormalTest"() {
        given:
        def x = 1
        def y = 1
        def str = "Hello World"
        def color = "yellow"

        when:
        gui.drawStringNormal(x, y, str, color)

        then:
        gui.drawString(x, y, str, color, graphics)
    }

    def "drawStringTest"() {
        given:
        def x = 1
        def y = 1
        def str = "Hello World"
        def color = "yellow"

        when:
        gui.drawString(x, y, str, color, graphics)
        then:
        1 * graphics.setForegroundColor({RGB:147;19;158})
        str.split("\n").size() * graphics.putString(x, _, _)}


    def "drawPlayerTest"() {
        when:
        gui.drawPlayer(1, 1)

        then:
        1 * graphics.setForegroundColor({RGB:255;255;255});
        1 * graphics.setCharacter(1, 1, '&');
    }
    def "drawMonsterTest"() {
        given: "coordinates, id, color, and a character"
        def x = 1
        def y = 1
        def id = "round_monster"
        def color = "white"

        and: "mapMonsterInfo contains the character for the given id"
        def c = gui.getMapMonsterInfo().get(id)

        when: "drawMonster is called"
        gui.drawMonster(x, y, id, color)

        then: "verify that setForegroundColor and putString were called with the correct arguments on the graphics object"
        1 * graphics.setForegroundColor({RGB:255;255;255})
        1 * graphics.setCharacter(x, y, c)
    }

    def "drawObstacleTest"() {
        given:
        def x = 1
        def y = 1
        def id = "wall"
        def color = "white"

        and: "mapMonsterInfo contains the character for the given id"
        def c = gui.getMapDecorationsInfo().get(id)
        when:
        gui.drawObstacle(x, y, id, color)

        then: "verify that setForegroundColor and putString were called with the correct arguments on the graphics object"
        1 * graphics.setForegroundColor({RGB:255;255;255})
        1 * graphics.setCharacter(x, y, c)

    }

    def "drawHealSpotTest"() {
        given:
        def x = 1
        def y = 1

        when:
        gui.drawHealSpot(x, y)

        then:
        1 * graphics.setForegroundColor({RGB:255;255;255})
        1 * graphics.setCharacter(x, y, '#')
    }


    def "drawStringBigTest"() {
        given:
        def x = 1
        def y = 1


        when:
        gui.drawStringBig(x, y, string)

      then:
            string.size()* graphics.drawImage(_,_)
    where:
    string <<["Hello", "Bigger string", "Something..." ]


   }

    def "drawBoxTest"() {
        given:
            def x = 1
            def y = 1


            when:
            gui.drawBox(x, y, w, h)

            then:
            if (w>1) {
                ((h) * 2 + (w - 3) * 2) * graphics.setCharacter(_, _, _)
            }
        where:
w<<[4,8,2,4,2,2]
h<<[9,12,14,2,2,2]

    }


    def "drawPlayerInBattle"() {
        given:
        def x = 1
        def y = 1

        when:
        gui.drawPlayerInBattle(x, y)

        then:
        1 * graphics.drawImage(new TerminalPosition(x, y), _)
    }

    def "drawEnemyInBattle"() {
        given:
        def x = 1
        def y = 1
        def id = "Bat"

        when:
        gui.drawEnemyInBattle(x, y, id)

        then:
        1 * graphics.drawImage(new TerminalPosition(x, y), gui.getBattlerTextImages().get(id))
        
    }

    def "drawOpenDoor"() {
        given:
        def x = 1
        def y = 1
        def color = "yellow"
        when:
        gui.drawOpenDoor(x, y, color)

        then:
        1 * graphics.setForegroundColor({RGB:250;234;65})
        1 * graphics.setCharacter(x, y, '%')
    }
    def "drawClosedDoor"() {
        given:
        def x = 1
        def y = 1
        def color = "purple"
        when:
        gui.drawClosedDoor(x, y, color)

        then:
        1 * graphics.setForegroundColor({RGB:147;19;158})
        1 * graphics.setCharacter(x, y, '\"')
    }
    def "getNextAction - with Arrow Up"() {
        given:
        def keyStroke = new com.googlecode.lanterna.input.KeyStroke(com.googlecode.lanterna.input.KeyType.ArrowUp)
        screenMock.pollInput() >>  keyStroke >> null >> keyStroke

        when:
        def action = gui.getNextAction()

        then:
        action == Action.UP
    }


    def "getNextAction - with Arrow Right"() {
        given:
        def keyStroke = new com.googlecode.lanterna.input.KeyStroke(com.googlecode.lanterna.input.KeyType.ArrowRight)
        screenMock.pollInput() >>  keyStroke >> null >> keyStroke


        when:
        def action = gui.getNextAction()

        then:
        action == Action.RIGHT
    }

    def "getNextAction - with Arrow Down"() {
        given:
        def keyStroke = new com.googlecode.lanterna.input.KeyStroke(com.googlecode.lanterna.input.KeyType.ArrowDown)
        screenMock.pollInput() >>  keyStroke >> null >> keyStroke

        when:
        def action = gui.getNextAction()

        then:
        action == Action.DOWN
    }

    def "getNextAction - with Arrow Left"() {
        given:
        def keyStroke = new com.googlecode.lanterna.input.KeyStroke(com.googlecode.lanterna.input.KeyType.ArrowLeft)
        screenMock.pollInput() >>  keyStroke >> null >> keyStroke

        when:
        def action = gui.getNextAction()

        then:
        action == Action.LEFT
    }
    def "getNextAction - with Enter Key"() {
        given:
        def keyStroke = new com.googlecode.lanterna.input.KeyStroke(com.googlecode.lanterna.input.KeyType.Enter)
        screenMock.pollInput() >>  keyStroke >> null >> keyStroke

        when:
        def action = gui.getNextAction()

        then:
        action == Action.SELECT
    }

    def "getNextAction - with EOF Key"() {
        given:
        def keyStroke = new com.googlecode.lanterna.input.KeyStroke(com.googlecode.lanterna.input.KeyType.EOF)
        screenMock.pollInput() >>  keyStroke >> null >> keyStroke

        when:
        def action = gui.getNextAction()

        then:
        action == Action.QUIT
    }

    def "getNextAction - with Character Key"() {
        given:
        def keyStroke = new com.googlecode.lanterna.input.KeyStroke('a' as char, false, false)
        screenMock.pollInput() >>  keyStroke >> null >> keyStroke

        when:
        def action = gui.getNextAction()

        then:
        action == Action.NONE
    }

    def "getNextAction - with No Action"() {
        given:
        def keyStroke = null // No action key
        screenMock.pollInput() >> keyStroke

        when:
        def action = gui.getNextAction()

        then:
        action == Action.NONE  // Assuming Action.NONE represents no action
    }
}
