package com.l03gr06.sagabi.states;

import com.l03gr06.sagabi.controller.map.RoomController;
import com.l03gr06.sagabi.model.map.Room;
import com.l03gr06.sagabi.viewer.map.RoomViewer;
import com.l03gr06.sagabi.viewer.Viewer;
import com.l03gr06.sagabi.controller.Controller;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class MapState extends State<Room>{
    @Override
    protected  Viewer<Room> getViewer()
    {
        return new RoomViewer();
    }
    @Override
    protected Controller<Room> getController()
    {
        return (Controller<Room>) new RoomController();
    }
    public MapState(Room model)
    {
        super(model);
    }
}
