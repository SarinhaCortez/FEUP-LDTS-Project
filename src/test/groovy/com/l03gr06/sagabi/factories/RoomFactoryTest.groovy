
package com.l03gr06.sagabi.factories

import com.l03gr06.sagabi.Game
import com.l03gr06.sagabi.model.Position
import com.l03gr06.sagabi.model.battlers.MonsterElement
import com.l03gr06.sagabi.model.battlers.PlayerBattler
import com.l03gr06.sagabi.model.map.Room
import com.l03gr06.sagabi.model.map.entities.interactables.Monster
import spock.lang.Specification
import org.mockito.Mockito

import java.nio.file.Path
import java.util.stream.Stream

class BasicRoomFactoryTest extends Specification {

    BasicRoomFactory basicRoomFactory
    String path = "tests/rooms/1";


    def "test readComponents"() {
        setup:
        MonsterFactory factory= Mockito.mock(MonsterFactory)
        MonsterElementFactory elfac=Mockito.mock(MonsterElementFactory)
        elfac.getAllElements()>>[]
        Game game= Mockito.mock(Game)
        Mockito.when(game.getMonsterFactory()).thenReturn(factory)
        Mockito.when(game.getMonsterElementFactory()).thenReturn(elfac)
        PlayerBattler b=PlayerBattler.getEmptyInstance(game);
        basicRoomFactory = new BasicRoomFactory(path,path,  path,game)
        ReadFile parseFile = Mockito.mock(ReadFile.class)
        String doorType = "heal_or_battle"
        MonsterElement element = Mockito.mock(MonsterElement.class)
        List<String> roomFileInfo = ["#TtHDMS "]

        Mockito.when(parseFile.splitInLines()).thenReturn(roomFileInfo)

        when:
        Room room = basicRoomFactory.readComponents(parseFile, doorType, element)

        then:
        room != null
    }
}
//working



class CreateRoomTest extends Specification {

    BasicRoomFactory basicRoomFactory
    MonsterElement monsterElement
    Game game;

   def setup() { //TODO: isto informa-nos que não temos error checking suficiente para verificar se o diretorio existe?

        String path = "/tests/rooms/1"
       MonsterFactory factory= Mockito.mock(MonsterFactory)
       MonsterElementFactory elfac=Mockito.mock(MonsterElementFactory)
       elfac.getAllElements()>>[]
       Game game= Mockito.mock(Game)
       Mockito.when(game.getMonsterFactory()).thenReturn(factory)
       Mockito.when(game.getMonsterElementFactory()).thenReturn(elfac)
       PlayerBattler p=PlayerBattler.getEmptyInstance(game)

       basicRoomFactory = new BasicRoomFactory( path,path,path,game)
        monsterElement = Mockito.mock(MonsterElement.class)
    }



def "test createBattleRoom"() {

        when:
        Room room = basicRoomFactory.createBattleRoom(monsterElement)

        then:
        room != null
        room.getPlayer().position.equals(new Position(1,1))

}

def "test createCorridor"() {

    when:
    Room room = basicRoomFactory.createCorridor()

    then:
    room != null
    room.getPlayer().position.equals(new Position(1,1))
}
}


class CreateRoomTestException extends Specification
{
    BasicRoomFactory basicRoomFactory
    MonsterElement monsterElement


    def setup() { //TODO: isto informa-nos que não temos error checking suficiente para verificar se o diretorio existe?

        String path="this path doesn't exist"
        Game game= Mock(Game)
        basicRoomFactory = new BasicRoomFactory( path,path,path,game)
        monsterElement = Mockito.mock(MonsterElement.class)
    }

    def "createRoom should fail if path doesn't exist"()
    {
        when:
        basicRoomFactory.createBattleRoom(null);
        then:
        thrown(Exception)
    }
}




/*      Choosing this option requires importing

        String pathToCorridorFiles = "/rooms/battle_rooms"
        String pathToBattleRoomFiles = "/rooms/corridors"
        String pathToHealRoomFiles = "/rooms/heal_rooms"
        basicRoomFactory = new BasicRoomFactory(pathToCorridorFiles, pathToBattleRoomFiles, pathToHealRoomFiles)
        monsterElement = Mockito.mock(MonsterElement.class)
        readFile = Mockito.mock(ReadFile.class)
        file = Mockito.mock(File.class)
        uri = new URI("file:/path/to/battle/room/files")
        path = Paths.get(uri)
        paths = Stream.of(path)
        Mockito.when(basicRoomFactory.getClass().getResource(anyString()).toURI()).thenReturn(uri)
        Mockito.when(Files.walk(any() as Path, anyInt())).thenReturn(paths)
        Mockito.when(new ReadFile(any() as File)).thenReturn(readFile)
        Mockito.when(readFile.getFile()).thenReturn(file)


        private void printRoomFiles(String roomPath) {
            URI uri = getClass().getResource(roomPath).toURI()
            Path roomFilesPath = Paths.get(uri)
            try (Stream<Path> paths = Files.walk(roomFilesPath)) {
                paths.forEach(path -> {
                    System.out.println(path);
                });
            } catch (IOException e) {
                e.printStackTrace();
        }
}*/

        