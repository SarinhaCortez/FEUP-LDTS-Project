package com.l03gr06.sagabi.states;

import com.l03gr06.sagabi.Game;
import com.l03gr06.sagabi.controller.BattleController;
import com.l03gr06.sagabi.controller.Controller;
import com.l03gr06.sagabi.model.battle.substates.BattleSubstate;
import com.l03gr06.sagabi.model.battle.Battle;
import com.l03gr06.sagabi.viewer.Viewer;
import com.l03gr06.sagabi.viewer.battle.MainBattleViewer;


@SuppressWarnings({"Immutable","JavaLangClash"})
public abstract class BattleState extends State<Battle>
{
    protected Game game;

    private BattleSubstate substate;
    @Override
    protected Viewer<Battle> getViewer()
    {
        return new MainBattleViewer();
    }
    @Override
    protected Controller<Battle> getController()
    {
        return new BattleController();
    }
    public BattleState(Battle model,Game game)
    {
        super(model);
        this.game=game;
        setSubstate(getInitialSubstate());
    }
    protected abstract BattleSubstate getInitialSubstate();
    public void setSubstate(BattleSubstate state)
    {
        substate=state;
        substate.init(this);
    }
    public void moveToNextState()
    {
        setSubstate(substate.getNextSubstate(getModel()));
    }
}
