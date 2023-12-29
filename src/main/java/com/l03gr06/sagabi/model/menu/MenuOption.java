package com.l03gr06.sagabi.model.menu;

import com.l03gr06.sagabi.model.menu.mainmenucommand.MainMenuCommand;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class MenuOption{
    private String option;
    MenuOptionCommand command;

    public MenuOption(String option, MenuOptionCommand command){
        this.option = option;
        this.command = command;
    }
    public String getText(){return option;}
    public void onClick(){command.onClick();}

}
