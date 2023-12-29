package com.l03gr06.sagabi.viewer.map.interactable;

import com.l03gr06.sagabi.gui.GUI;
import com.l03gr06.sagabi.model.map.Room;
import com.l03gr06.sagabi.model.map.entities.interactables.*;
import com.l03gr06.sagabi.viewer.map.MapViewer;
import com.l03gr06.sagabi.states.State;
@SuppressWarnings({"Immutable","JavaLangClash"})
public class InteractableViewer extends MapViewer {

    private InteractableTypeBasedViewer[] viewers;


    public InteractableViewer() {
        viewers = new InteractableTypeBasedViewer[] {
                new DoorViewer(),
                new MonsterViewer(),
                new HealViewer()
        };
    }

    public InteractableViewer(DoorViewer doorViewer, MonsterViewer monsterViewer, HealViewer healviewer){
        viewers = new InteractableTypeBasedViewer[] {
                doorViewer,
                monsterViewer,
                healviewer
        };
    }
@Override
    public void draw(GUI gui, State<Room> room)  {
        for(Interactable interactable : room.getModel().getInteractables()) {
            for(InteractableTypeBasedViewer viewer : viewers) {
                if(viewer.accepts(interactable))
                    viewer.draw(gui, interactable);
            }
        }
    }

}