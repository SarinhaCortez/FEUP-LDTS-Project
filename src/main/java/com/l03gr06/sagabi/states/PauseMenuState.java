package com.l03gr06.sagabi.states;

import com.l03gr06.sagabi.Game;
import com.l03gr06.sagabi.controller.Controller;
import com.l03gr06.sagabi.controller.menu.MainMenuController;
import com.l03gr06.sagabi.model.battlers.PlayerBattler;
import com.l03gr06.sagabi.model.map.Room;
import com.l03gr06.sagabi.model.menu.Menu;
import com.l03gr06.sagabi.model.menu.MenuOption;
import com.l03gr06.sagabi.model.menu.pausemenucommand.BackToRoomPauseCommand;
import com.l03gr06.sagabi.viewer.Viewer;
import com.l03gr06.sagabi.viewer.PauseMenuViewer;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings({"Immutable","JavaLangClash","ObjectToString"})
public class PauseMenuState extends State<Menu>{
    @Override
    protected Viewer<Menu> getViewer()
{
    return new PauseMenuViewer();
}
    @Override
    protected Controller<Menu> getController()
    {
        return new MainMenuController();
    }
    static Menu createMenu(Room room,Game game)
    {
        Menu menu= new Menu();
        menu.setText("Pause");
        List<MenuOption> options= new ArrayList<>();
        PlayerBattler player= PlayerBattler.getInstance(null);
        BackToRoomPauseCommand command= new BackToRoomPauseCommand(room,game);
        options.add( new MenuOption("Stats:",command ));
        options.add( new MenuOption(" - Level "+player.getLevel(),command ));
        options.add( new MenuOption(" - Health: "+player.getCurrentHealth()+"/"+player.getMaxHealth(),command ));
        options.add( new MenuOption(" - Energy: "+player.getCurrentEnergy()+"/"+player.getMaxEnergy(),command ));
        menu.setOptions(options);
        return menu;
    }
    public PauseMenuState(Room room, Game game)
    {
        super(createMenu(room,game));
    }
}
