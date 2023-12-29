package com.l03gr06.sagabi.states;

import com.l03gr06.sagabi.controller.Controller;
import com.l03gr06.sagabi.controller.LearnController;
import com.l03gr06.sagabi.model.learn_state.LearnStateMenu;
import com.l03gr06.sagabi.viewer.LearnViewer;
import com.l03gr06.sagabi.viewer.Viewer;


@SuppressWarnings({"Immutable","JavaLangClash"})
public class LearnState extends State<LearnStateMenu>
{
    @Override
    protected Viewer<LearnStateMenu> getViewer()
    {
        return new LearnViewer();
    }
    @Override
    protected Controller<LearnStateMenu> getController()
    {
        return new LearnController();
    }
    public LearnState(LearnStateMenu model)
    {
        super(model);
    }
}
