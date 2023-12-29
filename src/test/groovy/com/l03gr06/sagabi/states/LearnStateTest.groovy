package com.l03gr06.sagabi.states

import com.l03gr06.sagabi.controller.LearnController
import com.l03gr06.sagabi.model.learn_state.LearnStateMenu
import com.l03gr06.sagabi.model.menu.Menu
import com.l03gr06.sagabi.viewer.LearnViewer
import spock.lang.Specification

class LearnStateTest extends Specification {
    def "options shouldn't be initialized as null"()
    {
        given:
        LearnState state= new LearnState(null);
        when:
        LearnStateMenu menu = state.getModel();
        int num=menu.getTotalPagesNum()
        then:
        thrown(NullPointerException);
        assert(menu==null);
    }

    def "getViewer and getController should return LearnViewer and LearnController"()
    {
        given:
        LearnState state= new LearnState(null);
        when:
        LearnController controller=state.getController();
        LearnViewer viewer= state.getViewer();
        then:
        controller instanceof LearnController
        viewer instanceof LearnViewer
    }


}
