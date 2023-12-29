package com.l03gr06.sagabi.model.menu;

import com.l03gr06.sagabi.Game;
import com.l03gr06.sagabi.model.menu.mainmenucommand.ExitCommand;
import com.l03gr06.sagabi.model.menu.mainmenucommand.LearnCommand;
import com.l03gr06.sagabi.model.menu.mainmenucommand.MainMenuCommand;
import com.l03gr06.sagabi.model.menu.mainmenucommand.PlayCommand;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class Menu {
    private String text;
    private int currentOption;
    private List<MenuOption> options;

    public Menu() {


    }


    public MenuOption getCurrentOption() {

        if (currentOption >= 0 && currentOption < options.size()) {
            return options.get(currentOption);
        }

        return null;
    }

    public String getText(){return text;}

    public List<MenuOption> getOptions(){return options;}

    public void scrollUp(){
        currentOption--;

        if (currentOption < 0) {
            currentOption = 0;
        }
    }

    public void scrollDown(){
        currentOption++;

        if(currentOption>=options.size())
        {
            currentOption=Math.max(0,options.size()-1);
        }
    }

    public Menu(String text,List<MenuOption> options) {
        this.text=text;
        this.options=options;
        currentOption=0;
    }

    public void resetScroll(){currentOption=0;}

    public void setText(String text){this.text=text;}

    public void setOptions(List<MenuOption> options) {this.options=options;currentOption=0;}

}
