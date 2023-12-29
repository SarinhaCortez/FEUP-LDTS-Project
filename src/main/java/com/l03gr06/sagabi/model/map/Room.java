package com.l03gr06.sagabi.model.map;

import com.l03gr06.sagabi.model.Position;
import com.l03gr06.sagabi.model.battlers.MonsterBattler;
import com.l03gr06.sagabi.model.battlers.MonsterElement;
import com.l03gr06.sagabi.model.map.entities.Obstacle;
import com.l03gr06.sagabi.model.map.entities.Player;
import com.l03gr06.sagabi.model.map.entities.interactables.Door;
import com.l03gr06.sagabi.model.map.entities.interactables.Interactable;
import com.l03gr06.sagabi.model.map.entities.interactables.Monster;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class Room { //TODO: ADD element, so that things can know which colour they will be drawn...


    private MonsterElement element;
    public MonsterElement getElement(){return element;}
    private Player player;

    private List<Obstacle> obstacles;

    private List<Interactable> interactables;


    private int monsterCount;
    //Could call for player too
    public void removeMonster(MonsterBattler monster)
    {
    monsterCount--;
        for (int i=0;i<interactables.size();i++)
        {
            if (interactables.get(i).onMonsterDefeated(monster,monsterCount))
            {
                interactables.remove(i);
                i--;
            }
        }
    }


private int getMonsterCount()
{
int count=0;
    for (Interactable inter :interactables)
    {
        if (inter instanceof Monster){count++;}
    }
return count;
}
    public Room(Player player, List<Interactable> interactables, List<Obstacle> obstacles,MonsterElement element) {
        this.player = player;
        this.obstacles = obstacles;
        this.interactables = interactables;
        this.element= element;
        monsterCount=getMonsterCount();
    }

    public Room(Player player, List<Interactable> interactables, List<Obstacle> obstacles) {
        this.player = player;
        this.obstacles = obstacles;
        this.interactables = interactables;
        element=null;
        monsterCount=getMonsterCount();
    }
    public Player getPlayer() {
        return player;
    }

    public List<Interactable> getInteractables() {
        return interactables;
    }

    public List<Obstacle> getObstacles() {
        return obstacles;
    }

    public Position getPlayerPosition() {
        return (Position) player.getPosition();
    }
    public void addObstacle(Obstacle obstacle){
        obstacles.add(obstacle);
    }
    public void addInteractable(Interactable interactable){
        interactables.add(interactable);
    }

    public boolean isObstacleAt(Position p)
    {
        for(Obstacle obst : obstacles)
        {
            Position pos=obst.getPosition();
            if(pos.equals(p))
            {
                return true;
            }
        }
        return false;
    }

}
