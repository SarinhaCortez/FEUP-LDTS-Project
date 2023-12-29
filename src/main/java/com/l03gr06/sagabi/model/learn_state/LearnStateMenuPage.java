package com.l03gr06.sagabi.model.learn_state;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class LearnStateMenuPage {
    public String getTitle()
    {
        return title;
    }
    public String getIntroductionParagraph()
    {
        return intro;
    }
    public String getParagraphThatWillBeInsideSquare()
    {
        return main;
    }
    public String getImageId()
    {
        return image;
    }
    private String title,intro,main;
    private String image;
    public LearnStateMenuPage(String title,String intro,String main, String image)
    {
        this.title=title;
        this.main=main;
        this.intro=intro;
        this.image=image;
    }
}
