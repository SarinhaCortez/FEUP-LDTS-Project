package com.l03gr06.sagabi.controller.map;

import com.l03gr06.sagabi.Game;
import com.l03gr06.sagabi.gui.Action;
import com.l03gr06.sagabi.model.map.Room;
import com.l03gr06.sagabi.model.map.entities.interactables.Interactable;
import com.l03gr06.sagabi.states.State;

import java.util.List;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class InteractableController extends MapController{
    @Override
    public void  step(Game game, State<Room> state, Action action, float delta) {
        
        List<Interactable> interactables = state.getModel().getInteractables();

        for(Interactable i : interactables){
            if(state.getModel().getPlayer().getPosition().equals(i.getPosition())){
                i.onCollision();
            }
        }
    }
}
