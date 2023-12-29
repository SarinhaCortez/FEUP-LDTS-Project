package com.l03gr06.sagabi.controller.map;

import com.l03gr06.sagabi.Game;
import com.l03gr06.sagabi.gui.Action;
import com.l03gr06.sagabi.model.Position;
import com.l03gr06.sagabi.model.map.Room;
import com.l03gr06.sagabi.states.State;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class PlayerController extends MapController{
    @Override
    public void step(Game game, State<Room> state, Action action, float delta) {
        Position pos = state.getModel().getPlayer().getPosition();
        switch(action){
            case RIGHT:
                if(!state.getModel().isObstacleAt(pos.right())){
                    state.getModel().getPlayer().setPosition(pos.right());
                }
                break;
            case LEFT:
                if(!state.getModel().isObstacleAt(pos.left())){
                    state.getModel().getPlayer().setPosition(pos.left());
                }
                break;
            case UP:
                if(!state.getModel().isObstacleAt(pos.up())){
                    state.getModel().getPlayer().setPosition(pos.up());
                }
                break;
            case DOWN:
                if(!state.getModel().isObstacleAt(pos.down())){
                    state.getModel().getPlayer().setPosition(pos.down());
                }
                break;
            default:
            break;
        }
    }
}
