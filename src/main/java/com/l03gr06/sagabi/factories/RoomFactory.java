package com.l03gr06.sagabi.factories;

import com.l03gr06.sagabi.model.battlers.MonsterElement;
import com.l03gr06.sagabi.model.map.Room;

@SuppressWarnings({"Immutable","JavaLangClash"})
public interface RoomFactory {
    
    public Room createCorridor();
    public Room createHealRoom();
    public Room createBattleRoom(MonsterElement element);

}
