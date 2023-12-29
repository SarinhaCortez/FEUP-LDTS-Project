package com.l03gr06.sagabi.viewer.battle;

import com.l03gr06.sagabi.gui.GUI;
import com.l03gr06.sagabi.model.battle.Battle;
import com.l03gr06.sagabi.model.menu.Menu;
import com.l03gr06.sagabi.model.menu.MenuOption;
import com.l03gr06.sagabi.viewer.Viewer;
import com.l03gr06.sagabi.states.State;

import java.util.List;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class BattleMenuViewer extends BattleViewer{
    @Override
    public void draw(GUI gui, State<Battle> state)
    {
        Menu menu=state.getModel().getMenu();
        String text=menu.getText();
          if (text!=null) {
              gui.drawStringNormal(1, 15, text, "white");
          }
        List<MenuOption> options=menu.getOptions();
          if (options!=null){
          int y=0;

          for (MenuOption option:options)
          {
                y++;
                if (option==menu.getCurrentOption())
                {
                    gui.drawStringNormal(12,16+y,option.getText(),"yellow");
                }else
                {
                    gui.drawStringNormal(12,16+y,option.getText(),"white");
                }
          }
          }
    }
}
