package com.l03gr06.sagabi.states;

import com.l03gr06.sagabi.model.menu.Menu;
import com.l03gr06.sagabi.viewer.GameOverViewer;
import com.l03gr06.sagabi.viewer.MainMenuViewer;
import com.l03gr06.sagabi.viewer.Viewer;
import com.l03gr06.sagabi.controller.menu.MainMenuController;
import com.l03gr06.sagabi.controller.Controller;

@SuppressWarnings({"Immutable","JavaLangClash"})

public class MainMenuState extends State<Menu>
{
    @Override
    protected Viewer<Menu> getViewer()
    {
        return new MainMenuViewer();
    }
    @Override
    protected Controller<Menu> getController()
    {
        return new MainMenuController();
    }
    public MainMenuState(Menu model)
    {
        super(model);
    }

}
