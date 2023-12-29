package com.l03gr06.sagabi.viewer;
import com.l03gr06.sagabi.gui.GUI;
import com.l03gr06.sagabi.model.menu.Menu;
import com.l03gr06.sagabi.states.State;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class MainMenuViewer implements Viewer<Menu>{
    @Override
    public void draw(GUI gui, State<Menu> state) {
        int limit = state.getModel().getOptions().size();
        gui.drawStringBig(1,3, state.getModel().getText());

        for(int i = 0; i < limit; i++){

            if(state.getModel().getCurrentOption() == state.getModel().getOptions().get(i)){
                gui.drawStringNormal(5,15+ i * 2,state.getModel().getOptions().get(i).getText(), "light_blue");
            }
            else{
                gui.drawStringNormal(5,15 + i * 2,state.getModel().getOptions().get(i).getText(), "white");
            }
        }
    }

}
