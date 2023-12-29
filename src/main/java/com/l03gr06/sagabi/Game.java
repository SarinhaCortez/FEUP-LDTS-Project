package com.l03gr06.sagabi;

import com.l03gr06.sagabi.factories.*;
import com.l03gr06.sagabi.gui.GUI;
import com.l03gr06.sagabi.gui.LanternaGUI;
import com.l03gr06.sagabi.model.battlers.PlayerBattler;
import com.l03gr06.sagabi.states.MainMenuState;
import com.l03gr06.sagabi.states.State;


import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class Game {
    private final GUI gui;

    private final MainMenuFactory mainMenuFactory;
    private  MonsterFactory monsterFactory;
    private  AttackFactory attackFactory;
    private  RoomFactory roomFactory;
    private  MonsterElementFactory elementFactory;
    private   LevelUpAttackLearner attackLearner;

    public LevelUpAttackLearner getAttackLearner() {
        return attackLearner;
    }

    public AttackFactory getAttackFactory(){return attackFactory;}
    public RoomFactory getRoomFactory(){return roomFactory;}
    public MonsterFactory getMonsterFactory(){return monsterFactory;}
    public MonsterElementFactory getMonsterElementFactory(){return elementFactory;}






    public void setAttackFactory(AttackFactory attack){ attackFactory=attack;}
    public void setRoomFactory(RoomFactory room){roomFactory=room;}
    public void setMonsterFactory(MonsterFactory monster){ monsterFactory=monster;}
    public void setMonsterElementFactory(MonsterElementFactory element){elementFactory=element;}
    public void setAttackLearner(LevelUpAttackLearner learner){
        attackLearner=learner;
    }



    private State state;
    private static Game instance;

    public State getState() {
        return state;
    }
    public MainMenuFactory getMenuFactory()
    {
        return mainMenuFactory;
    }
    private State nextState=null;
    private Game() throws IOException, FontFormatException, URISyntaxException{
        this.gui = new LanternaGUI(50, 50,"graphics/Colors.txt","info/MonsterImages.txt");
        elementFactory = new BasicMonsterElementFactory("info/Elements.txt");
        mainMenuFactory= new BasicMainMenuFactory(this);
        attackFactory= new BasicAttackFactory("info/Attacks.txt",elementFactory);
        monsterFactory= new BasicMonsterFactory("info/Monsters.txt",elementFactory,this);
        PlayerBattler.getInstance(this);
        roomFactory = new BasicRoomFactory("/rooms/battle_rooms","/rooms/corridors", "/rooms/heal_rooms",this);
        attackLearner= new SimpleLevelUpAttackLearner(this);
        this.state = new MainMenuState(mainMenuFactory.createMainMenu());

    }

    public void setState(State state)
    {
        this.nextState = state;
    };

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException, Exception {
        getInstance().start();
    }

    private void start() throws IOException, Exception{
        int FPS = 10;
        int frameTime = 1000/FPS;

        while(this.state != null){
            long startTime = System.currentTimeMillis();
            if (nextState!=null)
            {
                state=nextState;
                nextState=null;
            }

            state.step(this, gui, (float)startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try{
                if (sleepTime > 0) Thread.sleep(sleepTime);
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
        }

        gui.close();
    }

    public void stop() throws Exception {
        gui.close();
        System.exit(0);
    }

    public State peekNextState()
    {
        return nextState;
    }
    public static Game getInstance(){
        try{
            if(instance == null){
                instance = new Game();
            }
        } catch(Exception ignored)
        {
            System.out.println("Error initiating game: ");
            System.out.println(ignored.toString());
        }

        return instance;
    }
}
