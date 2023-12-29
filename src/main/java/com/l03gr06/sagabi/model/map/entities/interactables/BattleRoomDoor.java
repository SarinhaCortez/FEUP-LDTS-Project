package com.l03gr06.sagabi.model.map.entities.interactables;

import com.l03gr06.sagabi.Game;
import com.l03gr06.sagabi.model.battlers.MonsterElement;
import com.l03gr06.sagabi.states.MapState;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class BattleRoomDoor extends Door{

    public BattleRoomDoor(Game game){
        super(4, 4, new MonsterElement("water", "dark_blue"),true,game);
        System.out.println("Water BattleRoomDoor created at (4,4), if you want another element use the argument constructor.");
    }

    public BattleRoomDoor(int x, int y, MonsterElement element,Game game){super(x,y,element,true,game);

    }
    @Override
    public void onCollision() {
        if (isOpen()){
        MonsterElement element=getNextRoomElement();
        game.setState(new MapState(game.getRoomFactory().createBattleRoom(element)));
    }}
}
