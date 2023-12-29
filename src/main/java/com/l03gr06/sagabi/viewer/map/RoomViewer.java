package com.l03gr06.sagabi.viewer.map;

import com.l03gr06.sagabi.gui.GUI;
import com.l03gr06.sagabi.model.map.Room;
import com.l03gr06.sagabi.model.map.entities.interactables.Interactable;
import com.l03gr06.sagabi.states.State;
import com.l03gr06.sagabi.viewer.map.interactable.InteractableViewer;

import java.util.List;
@SuppressWarnings({"Immutable","JavaLangClash"})
public class RoomViewer extends MapViewer{

    private InteractableViewer interactableViewer;
    private ObstacleViewer obstacleViewer;
    private PlayerViewer playerViewer;

    public RoomViewer(){
        interactableViewer = new InteractableViewer();
        obstacleViewer = new ObstacleViewer();
        playerViewer = new PlayerViewer();
    }
    public RoomViewer(InteractableViewer i, ObstacleViewer o, PlayerViewer p){
        interactableViewer = i;
        obstacleViewer = o;
        playerViewer = p;
    }
    @Override
    public void draw(GUI gui, State<Room> room) {
        interactableViewer.draw(gui, room);
        obstacleViewer.draw(gui, room);
        playerViewer.draw(gui, room);
    }
}
