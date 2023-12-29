package com.l03gr06.sagabi.viewer.map.interactable;


import com.l03gr06.sagabi.model.map.entities.interactables.*;
import com.l03gr06.sagabi.gui.GUI;
import com.l03gr06.sagabi.model.map.entities.interactables.Door;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class DoorViewer extends InteractableTypeBasedViewer{
    @Override
    public void draw(GUI gui, Interactable interactable) {
        Door door = (Door)interactable;
        String color;
        if (door.getNextRoomElement()==null)
        {
            color="white";
        }else
        {
            color= door.getNextRoomElement().getColor();
        }

        if (door.isOpen()) {
            gui.drawOpenDoor(interactable.getPosition().getX(), interactable.getPosition().getY(), color);
        }else
        {
            gui.drawClosedDoor(interactable.getPosition().getX(), interactable.getPosition().getY(), color);

        }
    }
//TODO
    @Override
    public boolean accepts(Interactable interactable) {

        return interactable instanceof Door;
    }
}
