package com.l03gr06.sagabi.factories;
import com.l03gr06.sagabi.Game;
import com.l03gr06.sagabi.model.*;
import com.l03gr06.sagabi.model.battlers.MonsterBattler;
import com.l03gr06.sagabi.model.battlers.MonsterElement;
import com.l03gr06.sagabi.model.battlers.PlayerBattler;
import com.l03gr06.sagabi.model.map.Room;
import com.l03gr06.sagabi.model.map.entities.*;
import com.l03gr06.sagabi.model.map.entities.interactables.*;

import javax.naming.InvalidNameException;
import java.io.File;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Stream;

@SuppressWarnings({"Immutable","JavaLangClash","RestrictedApiChecker","ObjectToString"})

public class BasicRoomFactory implements RoomFactory{
private Game game;
    String pathToCorridorFiles,pathToBattleRoomFiles, pathToHealRoomFiles;
    //not being recognised as directories?
        public BasicRoomFactory(String pathToBattleRoomFiles, String pathToCorridorFiles, String pathToHealRoomFiles,Game game){
            this.game=game;
        this.pathToCorridorFiles=pathToCorridorFiles;
        this.pathToBattleRoomFiles=pathToBattleRoomFiles;
        this.pathToHealRoomFiles=pathToHealRoomFiles;
        random = new Random();

        }

Random random;

        private Room readComponents(ReadFile parseFile, String doorType,MonsterElement element) {

            List<String> roomFileInfo; //?til?? pode ser s? uma vari?vel da funcao roomCreator
            List<Interactable> interactables;
            List<Obstacle> obstacles;

            Position playerPosition= new Position(0,0);


            roomFileInfo = new ArrayList<>();
            interactables = new ArrayList<>();
            obstacles = new ArrayList<>();


            int x = 0; // bounds?
            int y = 0; // bounds?

            roomFileInfo = parseFile.splitInLines();
            for (String line : roomFileInfo) {
                    x = 0;
                    for (char ch : line.toCharArray()) {
                        switch (ch) {
                            case '#':

                                Obstacle wall = new Obstacle(x, y, "wall");
                                obstacles.add(wall);
                                break;
                            case 'T':
                                Obstacle tree = new Obstacle(x, y, "tree1");
                                obstacles.add(tree);
                                break;
                            case 't':

                                Obstacle tree2 = new Obstacle(x, y, "tree2");
                                obstacles.add(tree2);
                                break;
                            case 'M':
                                if (element==null){break;}
                                Position monsterPosition = new Position(x, y);
                                MonsterBattler monsterBattler =
                                       game.getMonsterFactory()
                                                .createMonsterBattler(PlayerBattler.getInstance(null).getLevel(),
                                                element);
                                Monster monster = new Monster(monsterPosition.getX(), monsterPosition.getY(), monsterBattler,"round_monster",game);
                                interactables.add(monster);
                                break;
                            case 'H':
                                Interactable healSpot = new HealSpot(x, y);
                                interactables.add(healSpot);
                                break;
                            case 'S':
                                playerPosition = new Position(x, y);
                                break;
                            case 'D':
                                Interactable door=null;
                                if (doorType.equals("heal_or_battle"))
                                {
                                    if (random.nextInt(0,20)>3)
                                    {
                                        List<MonsterElement> elements= game.getMonsterElementFactory().getAllElements();
                                        elements.removeIf(new Predicate<MonsterElement>() {
                                            @Override
                                            public boolean test(MonsterElement element) {
                                                return element.getName().equals("player");
                                            }
                                        });
                                        if (!elements.isEmpty()) {
                                            door = new BattleRoomDoor(x,y,elements.get(random.nextInt(0,elements.size())),game);
                                        } else {
                                            door = new HealRoomDoor(x, y,game);
                                        }
                                    }else
                                    {
                                        door= new HealRoomDoor(x,y,game);
                                    }
                                }else if (doorType.equals("to_corridor"))
                                {
                                    door= new CorridorDoor(x,y,element==null,game);
                                }
                                interactables.add(door);
                                break;
                            case ' ':
                                break;
                            }
                        x++;
                    }
                    y++;
            }

            return new Room(new Player(playerPosition.getX(),playerPosition.getY()),interactables,obstacles,element);
        }


        //select correct files and return the private function evoked for said files...
        @Override
        public Room createBattleRoom(MonsterElement element){
            List<Path> files = new ArrayList<>();
            try {
                URI uri = getClass().getResource(pathToBattleRoomFiles).toURI();
                Path myPath = Paths.get(uri);
                try(Stream<Path> walk = Files.walk(myPath, 1))
                {for (Iterator<Path> it = walk.iterator(); it.hasNext(); ) {
                    Path filename = it.next();
                    files.add(filename);
                }}
            }catch(Exception e)
            {
                throw new RuntimeException("Failed to read files from directory: " + pathToBattleRoomFiles, e);
            }

            if(!files.isEmpty()) files.remove(0);

            if (!files.isEmpty()) {
                Random random= new Random();
                ReadFile file = new ReadFile(files.get(random.nextInt(files.size())).toFile());
                return readComponents(file,"to_corridor",element);
            } else {
                throw new RuntimeException("No files in directory: " + pathToBattleRoomFiles);
            }
        }




@Override
public Room createCorridor(){
    List<Path> files = new ArrayList<>();
    try {
        URI uri = getClass().getResource(pathToCorridorFiles).toURI();
        Path myPath = Paths.get(uri);
        try (Stream<Path> walk = Files.walk(myPath, 1)) {
            for (Iterator<Path> it = walk.iterator(); it.hasNext(); ) {
                Path filename = it.next();
                files.add(filename);
            }
        }
    }
    catch(Exception e)
    {
        throw new RuntimeException("Failed to read files from directory: " + pathToCorridorFiles, e);
    }

    if(!files.isEmpty()) files.remove(0);

    if (!files.isEmpty()) {
        Random random = new Random();
        ReadFile file = new ReadFile(files.get(random.nextInt(files.size())).toFile());
        return readComponents(file, "heal_or_battle", null);
    } else {
        throw new RuntimeException("No files in directory: " + pathToCorridorFiles);
    }
}

@Override
public Room createHealRoom()
{
    List<Path> files = new ArrayList<>();
    try {
        URI uri = getClass().getResource(pathToHealRoomFiles).toURI();
        Path myPath = Paths.get(uri);
        try (Stream<Path> walk = Files.walk(myPath, 1)) {
            for (Iterator<Path> it = walk.iterator(); it.hasNext(); ) {
                Path filename = it.next();
                files.add(filename);
            }
        }
    }
    catch(Exception e)
    {
        throw new RuntimeException("Failed to read files from directory: " + pathToHealRoomFiles, e);
    }

    if(!files.isEmpty())files.remove(0);

    if (!files.isEmpty()) {
        Random random = new Random();
        ReadFile file = new ReadFile(files.get(random.nextInt(files.size())).toFile());
        return readComponents(file, "to_corridor", null);
    } else {
        throw new RuntimeException("No files in directory: " + pathToHealRoomFiles);
    }
}
}
//testes a falhar porque o c?digo tem que ser corrigido