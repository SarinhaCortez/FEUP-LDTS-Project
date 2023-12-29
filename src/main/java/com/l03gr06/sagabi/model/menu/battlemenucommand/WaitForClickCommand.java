package com.l03gr06.sagabi.model.menu.battlemenucommand;

import com.l03gr06.sagabi.states.BattleState;

@SuppressWarnings({"Immutable","JavaLangClash"})

public class WaitForClickCommand extends BattleMenuCommand{
    @Override
    public void onClick() {

        state.moveToNextState();
    }
    public WaitForClickCommand(BattleState state)
    {
        super(state);
    }
}
