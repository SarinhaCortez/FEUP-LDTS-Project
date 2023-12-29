package com.l03gr06.sagabi.model.learn_state;

import java.util.List;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class LearnStateMenu {
    List<LearnStateMenuPage> pages;
    int current;

    public LearnStateMenu(List<LearnStateMenuPage> pages)
    {
        current=0;
        this.pages=pages;
    }

    public LearnStateMenuPage getCurrentPage(){
        if(current>=0&&current<pages.size())
        {
            return pages.get(current);
        }
        return null;
    }
    

    public int getCurrentPageNum(){
        return current + 1;
    }
    public int getTotalPagesNum(){
        return pages.size();
    }

public void moveToPreviousPage()
    {
        if (current==0)
        {
            current=pages.size()-1;
        }
        else{
            current--;
        }
    }
    public void moveToNextPage()
    {
        current++;
        if (current>=pages.size())
        {
            current=0;
        }
    }
}