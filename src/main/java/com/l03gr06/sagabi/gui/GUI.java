package com.l03gr06.sagabi.gui;

@SuppressWarnings({"Immutable","JavaLangClash"})
public interface GUI {
    public void refresh() throws Exception;
    public void drawPlayer(int x, int y);
    public void drawMonster(int x, int y, String id,String color);
    public void drawObstacle(int x, int y, String id,String color);
    public void drawHealSpot(int x, int y);
    public void drawStringNormal(int x, int y, String string, String color);
    public void drawStringBig(int x, int y, String string);
    public void drawBox(int x, int y, int w, int h);
    public void clear();
    public void close() throws Exception;
    public void drawPlayerInBattle(int x, int y);
    public void drawEnemyInBattle(int x, int y,String id);
    public Action getNextAction() throws Exception;
    public void drawOpenDoor(int x,int y,String color);
    public void drawClosedDoor(int x,int y,String color);

}
