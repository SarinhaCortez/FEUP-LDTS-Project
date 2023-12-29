package com.l03gr06.sagabi.factories;

import com.l03gr06.sagabi.model.game_over_state.GameOverStateMessage;
import com.l03gr06.sagabi.model.learn_state.LearnStateMenuPage;
import com.l03gr06.sagabi.model.menu.Menu;

import java.util.List;

@SuppressWarnings({"Immutable","JavaLangClash"})
public interface MainMenuFactory {
    public Menu createMainMenu();
    public List<LearnStateMenuPage> createLearnMenuPages();

    public GameOverStateMessage createGameOverMessage();
}
