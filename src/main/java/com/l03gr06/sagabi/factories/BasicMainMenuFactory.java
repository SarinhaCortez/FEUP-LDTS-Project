package com.l03gr06.sagabi.factories;

import com.l03gr06.sagabi.Game;
import com.l03gr06.sagabi.model.game_over_state.GameOverStateMessage;
import com.l03gr06.sagabi.model.learn_state.LearnStateMenuPage;
import com.l03gr06.sagabi.model.menu.Menu;
import com.l03gr06.sagabi.model.menu.MenuOption;
import com.l03gr06.sagabi.model.menu.mainmenucommand.ExitCommand;
import com.l03gr06.sagabi.model.menu.mainmenucommand.LearnCommand;
import com.l03gr06.sagabi.model.menu.mainmenucommand.MainMenuCommand;
import com.l03gr06.sagabi.model.menu.mainmenucommand.PlayCommand;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class BasicMainMenuFactory implements MainMenuFactory {
    private Game game;
    public BasicMainMenuFactory(Game game)
    {
        this.game=game;
    }
    @Override
    public Menu createMainMenu()
    {
        Menu menu= new Menu();
        menu.setText("Warrior\n Princess\n     Sagabi");



        MainMenuCommand playCommand = new PlayCommand(game);
        MainMenuCommand learnCommand = new LearnCommand(game);
        MainMenuCommand exitCommand = new ExitCommand(game);

        List<MenuOption> options = new ArrayList<MenuOption>();
        options.add(0, new MenuOption("Play", playCommand));
        options.add(1, new MenuOption("Learn", learnCommand));
        options.add(2, new MenuOption("Exit", exitCommand));

        menu.setOptions(options);
        return menu;
    }
@Override
    public List<LearnStateMenuPage> createLearnMenuPages()
    {
        List<LearnStateMenuPage> pages=new ArrayList<>();

        pages.add(new LearnStateMenuPage("Introduction","    Welcome to our game :)","In this game, you'll play as Warrior Princess\nSagabi.\n\nElemental Monsters are running rampant and \ninvading your castle. They plan to control\nyour entire kingdom. Something has to be done!\n\nEven though you know very little about fighting\nyou jump to action. As you advance you'll learn\nand develop your skills.\n\nWho knows...\nmaybe you'll even learn a bit of magic...","_"));
        pages.add(new LearnStateMenuPage("How to play","Moving around in the corridor","When you press play you'll find yourself in one\nof your castle's corridors. There, you will see\nplenty of multicolored doors.\n\nYou can use the arrow keys to move around. \n\nTo enter a room, simply walk up to its door.","_"));
        pages.add(new LearnStateMenuPage("How to play","        Door Types","There are two types of Doors: \n\n- Colored doors: lead to Battle Rooms\n\n- White doors: lead to Heal Rooms\n\n\nEach door's color represents the element of the\nmonster you'll find inside.","_"));
        pages.add(new LearnStateMenuPage("How to play","      Monster Elements","There are 8 different elements\n\n- Fire\n- Water\n- Air\n- Earth\n- Ice\n- Lightning\n- Paranormal\n- Poison\n\nEach element has weaknesses and elements they \nare resistant to.\n\nBut that's for you to find out ;)","_"));
        pages.add(new LearnStateMenuPage("How to play","       Battle Rooms","If you enter a battle door, you will find a\nmonster inside.\n\nIf you collide with it, a battle will start.\n\nYou can't return to the corridor if you change\nyour mind. It's time to defend your kingdom!","_"));
        pages.add(new LearnStateMenuPage("How to play","         Battles","The battle is turn-based. The one who is the \nfastest will start. You gain speed as you reach\nhigher levels.\n\nDuring your turn, you will be able to either\nattack or defend yourself\n\nIf you attack, there's always a chance the \nmonster will defend or resist your attack.\n\nIf you defend, the monster's attack effect on\nyou will be reduced.\n\nAttacking will cost you energy but being hit\nwill affect your health","_"));
        pages.add(new LearnStateMenuPage("How to play","        Heal Room","With that in mind, you can choose to relax in a\nheal room before your next big fight!\n\nInside you'll be able to rest and regain energy\nand health.\n\nBeing able to recognize when you need to reset\nis vital to reaching a high score - so use the\nheal room wisely!","_"));
        pages.add(new LearnStateMenuPage("Game Over ?","     Losing the Game","This game is all about defeating the highest\nnumber of monsters you can. But that doesn't\nmean you should stop looking after yourself!\n\nIf a monster's attack completely depletes your\nhealth,you'll lose and the monsters will win.\n\nGood thing Warrior Princess Sagabi is stuck in\na time loop - she can just try again tomorrow.","_"));
        return pages;

    }
    @Override
    public GameOverStateMessage createGameOverMessage()
    {
        return new GameOverStateMessage("You lost!","Press select to go back to main menu...");
    }
}
