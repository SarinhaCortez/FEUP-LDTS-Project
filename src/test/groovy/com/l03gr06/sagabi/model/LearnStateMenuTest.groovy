package com.l03gr06.sagabi.model

import com.l03gr06.sagabi.model.learn_state.LearnStateMenu
import com.l03gr06.sagabi.model.learn_state.LearnStateMenuPage
import spock.lang.Specification


class LearnStateMenuTest extends Specification {

    def "moveToPreviousPage should decrease current or set it to the last page if it's the first page"() {
        given: "A mock list of LearnStateMenuPage instances"
        List<LearnStateMenuPage> pages = [Mock(LearnStateMenuPage), Mock(LearnStateMenuPage), Mock(LearnStateMenuPage)]

        and: "A LearnStateMenu instance with the mock list"
        LearnStateMenu menu = new LearnStateMenu(pages)

        when: "moveToNextPage is called twice to set current to 2"
        menu.moveToNextPage()
        menu.moveToNextPage()

        then: "current page should be the third page"
        assert menu.getCurrentPage() == pages[2]

        when: "moveToPreviousPage is called"
        menu.moveToPreviousPage()

        then: "current page should be the second page"
        assert menu.getCurrentPage() == pages[1]

        when: "moveToPreviousPage is called again"
        menu.moveToPreviousPage()

        then: "current page should be the first page"
        assert menu.getCurrentPage() == pages[0]

        when: "moveToPreviousPage is called again"
        menu.moveToPreviousPage()

        then: "current page should be the third page (the last page)"
        assert menu.getCurrentPage() == pages[2]
    }

    def "moveToNextPage should increase current or set it to the first page if it's the last page"() {
        given: "A mock list of LearnStateMenuPage instances"
        List<LearnStateMenuPage> pages = [Mock(LearnStateMenuPage), Mock(LearnStateMenuPage), Mock(LearnStateMenuPage)]

        and: "A LearnStateMenu instance with the mock list"
        LearnStateMenu menu = new LearnStateMenu(pages)

        when: "moveToNextPage is called"
        menu.moveToNextPage()

        then: "current page should be the second page"
        assert menu.getCurrentPage() == pages[1]

        when: "moveToNextPage is called again"
        menu.moveToNextPage()

        then: "current page should be the third page"
        assert menu.getCurrentPage() == pages[2]

        when: "moveToNextPage is called again"
        menu.moveToNextPage()

        then: "current page should be the first page (the first page)"
        assert menu.getCurrentPage() == pages[0]
    }
}