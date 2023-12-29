package com.l03gr06.sagabi.model.map.entities.interactables;


import com.l03gr06.sagabi.model.battlers.PlayerBattler;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class HealSpot extends Interactable {

    public HealSpot(int x, int y) {
        super(x, y);
    }

    @Override
    public void onCollision() {
        PlayerBattler.getInstance(null).healFull();
    }
}
