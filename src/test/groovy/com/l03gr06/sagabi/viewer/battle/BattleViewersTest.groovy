package com.l03gr06.sagabi.viewer.battle

import com.l03gr06.sagabi.model.battlers.MonsterBattler
import com.l03gr06.sagabi.model.battlers.MonsterElement
import com.l03gr06.sagabi.model.battlers.PlayerBattler
import com.l03gr06.sagabi.model.map.entities.Player
import com.l03gr06.sagabi.viewer.battle.BattleEnemyViewer
import com.l03gr06.sagabi.viewer.battle.BattleMenuViewer
import com.l03gr06.sagabi.viewer.battle.BattlePlayerViewer
import com.l03gr06.sagabi.model.battle.Battle
import com.l03gr06.sagabi.model.menu.Menu
import com.l03gr06.sagabi.model.menu.MenuOption
import com.l03gr06.sagabi.states.State
import com.l03gr06.sagabi.gui.GUI
import com.l03gr06.sagabi.viewer.battle.MainBattleViewer
import org.mockito.Mockito
import spock.lang.Specification

class BattleViewersTest extends Specification{

    GUI gui
    State<Battle> state
    Battle battle
    Menu menu
    MenuOption option1
    MenuOption option2
    MonsterBattler enemy
    PlayerBattler player;
    MonsterElement element;

    def setup() {
        gui = Mockito.mock(GUI.class)
        state = Mockito.mock(State.class)
        battle = Mockito.mock(Battle.class)
        menu = Mockito.mock(Menu.class)
        option1 = Mockito.mock(MenuOption.class)
        option2 = Mockito.mock(MenuOption.class)
        enemy = Mockito.mock(MonsterBattler.class)
        player= Mockito.mock(PlayerBattler.class)
        element= Mockito.mock(MonsterElement.class)


        Mockito.when(element.getColor()).thenReturn("red");
        Mockito.when(enemy.getElement()).thenReturn(element);
        Mockito.when(battle.getPlayer()).thenReturn(player);
        Mockito.when(player.getCurrentHealth()).thenReturn(10);
        Mockito.when(player.getCurrentEnergy()).thenReturn(10);
        Mockito.when(player.getMaxHealth()).thenReturn(10);
        Mockito.when(player.getMaxEnergy()).thenReturn(10);
        Mockito.when(enemy.getCurrentHealth()).thenReturn(10);
        Mockito.when(enemy.getCurrentEnergy()).thenReturn(10);
        Mockito.when(enemy.getMaxHealth()).thenReturn(10);
        Mockito.when(enemy.getMaxEnergy()).thenReturn(10);
        PlayerBattler.metaClass.static.getInstance={->player}

        Mockito.when(state.getModel()).thenReturn(battle)
        Mockito.when(enemy.getId()).thenReturn("Something")
        Mockito.when(battle.getEnemy()).thenReturn(enemy);
        Mockito.when(state.getModel()).thenReturn(battle)
        Mockito.when(battle.getMenu()).thenReturn(menu)
        Mockito.when(menu.getText()).thenReturn("Menu Text")
        Mockito.when(menu.getOptions()).thenReturn([option1, option2])
        Mockito.when(menu.getCurrentOption()).thenReturn(option1)
        Mockito.when(option1.getText()).thenReturn("Option 1")
        Mockito.when(option2.getText()).thenReturn("Option 2")
    }

    def "BattleEnemyViewerTest"() {

        given: "A BattleEnemyViewer, a mock GUI, and a mock State"
        BattleEnemyViewer battleEnemyViewer = new BattleEnemyViewer()


        when: "draw is called"
        battleEnemyViewer.draw(gui, state)

        then: "drawEnemyInBattle is called on the GUI with the correct parameters"
        Mockito.verify(gui).drawEnemyInBattle(10, 1, "Something")

    }
    def "BattleMenuViewerTest"() {
        given: "A BattleMenuViewer, a mock GUI, and a mock State"
        BattleMenuViewer battleMenuViewer = new BattleMenuViewer()


        when: "draw is called"
        battleMenuViewer.draw(gui, state)

        then: "drawStringNormal is called on the GUI with the correct parameters"
        Mockito.verify(gui).drawStringNormal(1, 15, "Menu Text", "white")
        Mockito.verify(gui).drawStringNormal(12, 17, "Option 1", "yellow")
        Mockito.verify(gui).drawStringNormal(12, 18, "Option 2", "white")
    }

    def "BattlePlayerViewerTest"() {
        given: "A BattlePlayerViewer, a mock GUI, and a mock State"
        BattlePlayerViewer battlePlayerViewer = new BattlePlayerViewer()

        when: "draw is called"
        battlePlayerViewer.draw(gui, state)

        then: "drawPlayerInBattle is called on the GUI with the correct parameters"
        Mockito.verify(gui).drawPlayerInBattle(1, 10)
    }

    def "MainBattleViewerTest"() {
        given: "A MainBattleViewer, a mock GUI, and a mock State"


        BattlePlayerViewer player = Mockito.mock(BattlePlayerViewer)
        BattleMenuViewer viewer = Mockito.mock(BattleMenuViewer)
        BattleEnemyViewer enemy = Mockito.mock(BattleEnemyViewer)
        MainBattleViewer mainBattleViewer = new MainBattleViewer(player, viewer, enemy)


        when: "draw is called"
        mainBattleViewer.draw(gui, state)

        then: "draw is called on the player, viewer, and enemy with the correct parameters"
        Mockito.verify(player).draw(gui, state)
        Mockito.verify(viewer).draw(gui, state)
        Mockito.verify(enemy).draw(gui, state)
    }



}