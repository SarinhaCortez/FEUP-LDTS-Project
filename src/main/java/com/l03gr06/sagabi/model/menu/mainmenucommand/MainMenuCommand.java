package com.l03gr06.sagabi.model.menu.mainmenucommand;

import com.l03gr06.sagabi.Game;
import com.l03gr06.sagabi.model.menu.MenuOptionCommand;
import com.l03gr06.sagabi.states.State;

@SuppressWarnings({"Immutable","JavaLangClash"})


public abstract class MainMenuCommand implements MenuOptionCommand {
    public MainMenuCommand() {}

    @Override
    public abstract void onClick();
}
