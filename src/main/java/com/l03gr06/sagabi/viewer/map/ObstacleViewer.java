package com.l03gr06.sagabi.viewer.map;


import com.l03gr06.sagabi.gui.GUI;
import com.l03gr06.sagabi.model.battlers.MonsterElement;
import com.l03gr06.sagabi.model.map.Room;
import com.l03gr06.sagabi.states.State;
import com.l03gr06.sagabi.model.map.entities.Obstacle;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class ObstacleViewer extends MapViewer{
    @Override
    public void draw(GUI gui, State<Room> room) {
        for (Obstacle obstacle : room.getModel().getObstacles()) {
            MonsterElement element=room.getModel().getElement();
            String color;
            if (element==null)
            {
                color="white";
            }else
            {
                color= element.getColor();
            }
            gui.drawObstacle(obstacle.getPosition().getX(), obstacle.getPosition().getY(), obstacle.getId(), color);
        }
    }
}
