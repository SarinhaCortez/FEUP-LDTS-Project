package com.l03gr06.sagabi.controller.map;

import com.l03gr06.sagabi.Game;
import com.l03gr06.sagabi.gui.Action;
import com.l03gr06.sagabi.model.map.Room;
import com.l03gr06.sagabi.model.map.entities.Player;
import com.l03gr06.sagabi.states.State;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class RoomController extends MapController{

    PlayerController player;
    InteractableController inter ;
    GoToPauseController pause;
    public RoomController(){
        player = new PlayerController();
        inter = new InteractableController();
        pause= new GoToPauseController();
    }
    public RoomController(PlayerController player, InteractableController inter,GoToPauseController pause){
        this.player = player;
        this.inter = inter;
        this.pause=pause;
    }

    @Override
    public void step(Game game, State<Room> state, Action action, float delta) {

        player.step(game, state, action, delta);
        inter.step(game, state, action, delta);
        pause.step(game,state,action,delta);
    }
}