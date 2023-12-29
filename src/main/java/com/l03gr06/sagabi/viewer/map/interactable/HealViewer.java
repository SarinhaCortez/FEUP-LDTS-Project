package com.l03gr06.sagabi.viewer.map.interactable;

import com.l03gr06.sagabi.gui.GUI;
import com.l03gr06.sagabi.model.map.entities.interactables.*;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class HealViewer extends InteractableTypeBasedViewer
{
    @Override
    public void draw(GUI gui, Interactable interactable){
            gui.drawHealSpot(interactable.getPosition().getX(), interactable.getPosition().getY());
    }
    @Override
    public boolean accepts(Interactable interactable){
        return interactable.getClass() == HealSpot.class;
    }
}
