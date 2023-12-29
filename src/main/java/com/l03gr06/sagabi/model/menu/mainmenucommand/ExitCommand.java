package com.l03gr06.sagabi.model.menu.mainmenucommand;

import com.l03gr06.sagabi.Game;

@SuppressWarnings({"Immutable","JavaLangClash"})

public class ExitCommand extends MainMenuCommand{
    public ExitCommand(Game game) {this.game=game;}
private Game game;

    @Override
    public void onClick() {
        try{
            game.stop();
        }catch(Exception ignored)
        {
            System.out.println(ignored.toString());
        }
    }
}
