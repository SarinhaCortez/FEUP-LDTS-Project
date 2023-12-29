package com.l03gr06.sagabi.viewer.map.interactable;


import com.l03gr06.sagabi.model.map.entities.interactables.*;
import com.l03gr06.sagabi.gui.GUI;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class MonsterViewer extends InteractableTypeBasedViewer{
    @Override
    public void draw(GUI gui, Interactable interactable){
        Monster monster =(Monster) interactable;
            gui.drawMonster(interactable.getPosition().getX(), interactable.getPosition().getY(), monster.getId()  , monster.getMonsterBattler().getElement().getColor());
    }
    @Override
    public boolean accepts(Interactable interactable){
        return interactable instanceof Monster;
    }
}
