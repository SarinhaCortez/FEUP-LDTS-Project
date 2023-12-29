package com.l03gr06.sagabi.viewer

import com.l03gr06.sagabi.gui.GUI
import com.l03gr06.sagabi.model.menu.Menu
import com.l03gr06.sagabi.model.menu.MenuOption
import com.l03gr06.sagabi.model.menu.MenuOptionCommand
import com.l03gr06.sagabi.model.menu.battlemenucommand.BattleMenuCommand
import com.l03gr06.sagabi.states.State
import org.mockito.Mockito
import spock.lang.Specification

class MainMenuViewerTest extends Specification {

    def "test draw method"() {
        given: "A mocked GUI and State"
        GUI gui = Mockito.mock(GUI.class)
        State<Menu> state = Mockito.mock(State.class)
        MenuOptionCommand option= Mockito.mock(MenuOptionCommand.class)
        Menu menu = new Menu("MenuText", [new MenuOption("Option1",option), new MenuOption("Option2",option)])
        Mockito.when(state.getModel()).thenReturn(menu)

        and: "A MainMenuViewer instance"
        MainMenuViewer viewer = new MainMenuViewer()

        when: "draw is called"
        viewer.draw(gui, state)

        then: "The drawStringBig and drawStringNormal methods are called with the correct parameters"
        Mockito.verify(gui).drawStringBig(1, 3, "MenuText")
        Mockito.verify(gui, Mockito.times(2)).drawStringNormal(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyString(), Mockito.anyString())
    }
}