package com.l03gr06.sagabi.model.game_over_state;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class GameOverStateMessage {
    public String getTitle()
    {
        return title;
    }
    public String getMainText()
    {
        return main;
    }
    private String title,main;
    public GameOverStateMessage(String title,String main)
    {
        this.title=title;
        this.main=main;
    }
}
