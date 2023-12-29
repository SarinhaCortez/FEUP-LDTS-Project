package com.l03gr06.sagabi.model.map.entities.interactables;


import com.l03gr06.sagabi.Game;
import com.l03gr06.sagabi.model.battlers.MonsterBattler;
import com.l03gr06.sagabi.model.battlers.MonsterElement;
import com.l03gr06.sagabi.model.map.Room;

@SuppressWarnings({"Immutable","JavaLangClash"})
public abstract class Door extends Interactable {
    private MonsterElement element;
    private boolean doorIsOpen=false;
protected Game game;
    @Override
    public  boolean onMonsterDefeated(MonsterBattler battler, int monstersLeft)
    {
        if (monstersLeft==0){open();}
        return false;
    }

    public Door(int x, int y,MonsterElement nextRoomElement, boolean doorIsOpen,Game game) {
        super(x, y); this.element = nextRoomElement;
        this.doorIsOpen=doorIsOpen;
        this.game=game;
    }
    public Door(int x, int y,MonsterElement nextRoomElement,Game game) {
        super(x, y); this.element = nextRoomElement;
        this.game=game;
    }

    public Door(int x, int y,Game game) {
        super(x, y); this.element =null;
        this.game=game;
    }
    public MonsterElement getNextRoomElement()
    {
        return element;
    }
    @Override
    public abstract void onCollision();
    public void open() {
        doorIsOpen=true;
    }
    public boolean isOpen()
    {
        return doorIsOpen;
    }
}
