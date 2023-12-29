package com.l03gr06.sagabi.viewer
import spock.lang.Specification
import org.mockito.Mockito
import com.l03gr06.sagabi.gui.GUI
import com.l03gr06.sagabi.states.State
import com.l03gr06.sagabi.model.learn_state.LearnStateMenu
import com.l03gr06.sagabi.model.learn_state.LearnStateMenuPage

class LearnViewerTest extends Specification {

    LearnViewer learnViewer
    GUI gui
    State<LearnStateMenu> state
    LearnStateMenu learnStateMenu
    LearnStateMenuPage page

    def setup() {
        learnViewer = new LearnViewer()
        gui = Mockito.mock(GUI.class)
        state = Mockito.mock(State.class)
        learnStateMenu = Mockito.mock(LearnStateMenu.class)
        page = Mockito.mock(LearnStateMenuPage.class)
        Mockito.when(state.getModel()).thenReturn(learnStateMenu)
        Mockito.when(learnStateMenu.getCurrentPage()).thenReturn(page)
    }

    def "test LearnViewer draw method"() {
        given: "A mocked GUI, State, and LearnStateMenu"
        GUI gui = Mockito.mock(GUI.class)
        State<LearnStateMenu> state = Mockito.mock(State.class)
        LearnStateMenu menu = Mockito.mock(LearnStateMenu.class)
        Mockito.when(state.getModel()).thenReturn(menu)
        LearnStateMenuPage page = Mockito.mock(LearnStateMenuPage.class)
        Mockito.when(page.getTitle()).thenReturn("Title")
        Mockito.when(page.getIntroductionParagraph()).thenReturn("Introduction");
        Mockito.when(page.getParagraphThatWillBeInsideSquare()).thenReturn("Paragraph")

        Mockito.when(menu.getCurrentPage()).thenReturn(page)
        Mockito.when(menu.getCurrentPageNum()).thenReturn(1)
        Mockito.when(menu.getTotalPagesNum()).thenReturn(10)

        and: "A LearnViewer instance"
        LearnViewer viewer = new LearnViewer()

        when: "draw is called"
        viewer.draw(gui, state)

        then: "The draw methods are called with the correct parameters"
        Mockito.verify(gui).drawStringBig(2, 0, "Title")
        Mockito.verify(gui).drawStringNormal(10, 3, "Introduction", "light_blue")
        Mockito.verify(gui).drawBox(0, 5, 49, 22)
        Mockito.verify(gui).drawStringNormal(1, 6, "Paragraph", "white")
        Mockito.verify(gui).drawStringNormal(1, 25, "Press down to return to main menu", "learn_menu_purple")
        Mockito.verify(gui).drawStringNormal(45, 25, "1/10", "white")

    }
}