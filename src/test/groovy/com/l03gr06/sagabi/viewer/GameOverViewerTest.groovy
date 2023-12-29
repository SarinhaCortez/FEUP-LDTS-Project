package com.l03gr06.sagabi.viewer

import com.l03gr06.sagabi.gui.GUI
import com.l03gr06.sagabi.model.game_over_state.GameOverStateMessage
import com.l03gr06.sagabi.states.State
import org.mockito.Mockito
import spock.lang.Specification

class GameOverViewerTest extends Specification {

    def "test draw method"() {
        given: "A mocked GUI and State"
        GUI gui = Mockito.mock(GUI.class)
        State<GameOverStateMessage> state = Mockito.mock(State.class)
        GameOverStateMessage message = new GameOverStateMessage("Title", "MainText")
        Mockito.when(state.getModel()).thenReturn(message)

        and: "A GameOverViewer instance"
        GameOverViewer viewer = new GameOverViewer()

        when: "draw is called"
        viewer.draw(gui, state)

        then: "The drawStringBig, drawStringNormal, and refresh methods are called with the correct parameters"
        Mockito.verify(gui).drawStringBig(5, 3, "Title")
        Mockito.verify(gui).drawStringNormal(2, 6, "MainText", "white")

    }
}