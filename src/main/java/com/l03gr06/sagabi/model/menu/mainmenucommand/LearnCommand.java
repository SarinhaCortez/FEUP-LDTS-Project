package com.l03gr06.sagabi.model.menu.mainmenucommand;

import com.l03gr06.sagabi.Game;
import com.l03gr06.sagabi.factories.BasicMainMenuFactory;
import com.l03gr06.sagabi.model.learn_state.LearnStateMenu;
import com.l03gr06.sagabi.model.learn_state.LearnStateMenuPage;
import com.l03gr06.sagabi.states.LearnState;

import java.util.List;

@SuppressWarnings({"Immutable","JavaLangClash"})

public class LearnCommand extends MainMenuCommand{


private Game game;
    public LearnCommand(Game game)
    {
        this.game=game;
    }

    @Override
    public void onClick() {

        game.setState(new LearnState(new LearnStateMenu(game.getMenuFactory().createLearnMenuPages())));
    }
}
