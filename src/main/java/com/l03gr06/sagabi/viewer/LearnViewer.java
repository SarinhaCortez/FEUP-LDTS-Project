package com.l03gr06.sagabi.viewer;

import com.l03gr06.sagabi.gui.GUI;
import com.l03gr06.sagabi.model.learn_state.LearnStateMenu;
import com.l03gr06.sagabi.states.State;

@SuppressWarnings({"Immutable","JavaLangClash","ObjectToString"})
public class LearnViewer implements Viewer<LearnStateMenu>{
    @Override
    public void draw(GUI gui, State<LearnStateMenu> state) throws Exception{
        gui.drawStringBig(2, 0, state.getModel().getCurrentPage().getTitle());
        gui.drawStringNormal(10, 3, state.getModel().getCurrentPage().getIntroductionParagraph(), "light_blue");
        gui.drawBox(0, 5, 49, 22);
        gui.drawStringNormal(1, 6, state.getModel().getCurrentPage().getParagraphThatWillBeInsideSquare(), "white");
        //gui.drawLearnMenuImage(0, 3, state.getModel().getCurrentPage().getImageId());
        gui.drawStringNormal(1,25, "Press down to return to main menu", "learn_menu_purple");
        gui.drawStringNormal(45,25,state.getModel().getCurrentPageNum() + "/" + state.getModel().getTotalPagesNum(), "white");
        gui.refresh();
    }
}
