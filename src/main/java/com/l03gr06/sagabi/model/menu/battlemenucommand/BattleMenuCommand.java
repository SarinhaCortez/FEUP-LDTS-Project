package com.l03gr06.sagabi.model.menu.battlemenucommand;

import com.l03gr06.sagabi.model.menu.MenuOptionCommand;
import com.l03gr06.sagabi.states.BattleState;
@SuppressWarnings({"Immutable","JavaLangClash"})

public abstract class BattleMenuCommand implements MenuOptionCommand {
    protected final BattleState state;
    @Override
    public abstract void onClick();
    public BattleMenuCommand(BattleState state)
    {
        this.state=state;
    }
}
