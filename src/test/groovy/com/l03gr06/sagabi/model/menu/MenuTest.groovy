package com.l03gr06.sagabi.model.menu

import spock.lang.Specification

class MenuTest extends Specification{
    def "scrollUp should move to previous option or remain in current option if it's the first"(){
        given: "A mock list of Menu Options and a test string"
        List<MenuOption> options = [Mock(MenuOption), Mock(MenuOption),Mock(MenuOption)]
        String text = "test12"

        and: "A menu instance with the mock list and text"
        Menu menu = new Menu(text, options)

        when: "scrollUp is called when current is the first option"
        menu.scrollUp()

        then: "currentOption should be the first option"
        assert menu.getCurrentOption() == options[0]

        when: "scrollDown is called twice so current is last option and then scrollUp is called"
        menu.scrollDown()
        menu.scrollDown()
        menu.scrollUp()

        then: "currentOption should be the second option"
        assert menu.getCurrentOption() == options[1]

        when: "scrollUp is called from the second option"
        menu.scrollUp()

        then: "currentOption should be the first option"
        assert menu.getCurrentOption() == options[0]
    }

    def "scrollDown should move to next option or remain in current option if it's the last"(){
        given: "A mock list of Menu Options and test string"
        List<MenuOption> options = [Mock(MenuOption), Mock(MenuOption),Mock(MenuOption)]
        String text = "test12"

        and: "A menu instance with the mock list and text"
        Menu menu = new Menu(text, options)

        when: "scrollDown is called when current is first option"
        menu.scrollDown()

        then: "currentOption should be the second option"
        assert menu.getCurrentOption() == options[1]

        when: "scrollDown is called when current is the second option"
        menu.scrollDown()

        then: "currentOption should be the last option"
        assert menu.getCurrentOption() == options[2]

        when: "scrollDown is called from the last option"
        menu.scrollDown()

        then: "currentOption should be the last option"
        assert menu.getCurrentOption() == options[2]
    }

    def "resetScroll should set currentOption to first option no matter what the currentOption is initially"(){
        given: "A mock list of Menu Options and test string"
        List<MenuOption> options = [Mock(MenuOption), Mock(MenuOption),Mock(MenuOption)]
        String text = "test12"

        and: "A menu instance with the mock list and text"
        Menu menu = new Menu(text, options)

        when: "resetScroll is called when current is the first option"
        menu.resetScroll()

        then: "currentOption should be the first option"
        assert menu.getCurrentOption() == options[0]

        when: "resetScroll is called when current is the second option"
        menu.scrollDown()
        menu.resetScroll()

        then: "currentOption should be the first option"
        assert menu.getCurrentOption() == options[0]

        when: "resetScroll is called when current option is the last option"
        menu.scrollDown()
        menu.scrollDown()
        menu.resetScroll()

        then: "currentOption should be the first option"
        assert menu.getCurrentOption() == options[0]
    }
}
