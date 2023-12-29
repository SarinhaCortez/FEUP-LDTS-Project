package com.l03gr06.sagabi.viewer;

import com.l03gr06.sagabi.gui.GUI;
import com.l03gr06.sagabi.model.menu.Menu;
import com.l03gr06.sagabi.states.State;
import com.l03gr06.sagabi.viewer.Viewer;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class PauseMenuViewer implements Viewer<Menu> {
    @Override
    public void draw(GUI gui, State<Menu> state)
    {
        int limit = state.getModel().getOptions().size();
        gui.drawStringBig(1,3, state.getModel().getText());

        for(int i = 0; i < limit; i++){

              gui.drawStringNormal(5,15+ i * 2,state.getModel().getOptions().get(i).getText(), "light_blue");

        }
    }
}
