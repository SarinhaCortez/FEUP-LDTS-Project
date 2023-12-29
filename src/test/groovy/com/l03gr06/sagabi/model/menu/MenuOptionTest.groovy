package com.l03gr06.sagabi.model.menu

import spock.lang.Specification

class MenuOptionTest extends Specification{
    def "getText should return string associated with MenuOption"(){
        given: "A test string and a MenuOptionCommand mock"
        String text = "test12"
        MenuOptionCommand optionCommand = Mock(MenuOptionCommand)

        and: "A MenuOption made from the test string and MenuOptionCommand mock"
        MenuOption menuOption = new MenuOption(text, optionCommand)

        when: "getText return value is passed on to a variable"
        String testing = menuOption.getText()

        then: "It should be the same as test string"
        assert testing == text
    }

    def "test onClick for MenuOption"(){
        given: "A test string and a MenuOptionCommand mock"
        String text = "test12"
        MenuOptionCommand optionCommand = Mock(MenuOptionCommand)

        and: "A MenuOption made from the test string and MenuOptionCommand mock"
        MenuOption menuOption = new MenuOption(text, optionCommand)

        when: "onClick is called"
        menuOption.onClick()

        then: "optionCommand.onClick is called"
        1 * optionCommand.onClick()
    }

}
