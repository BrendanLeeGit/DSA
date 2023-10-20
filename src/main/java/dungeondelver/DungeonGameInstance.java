package dungeondelver;

public class DungeonGameInstance {
    private final DungeonNavigator dungeonNavigator;

    public DungeonGameInstance(){
        //Create a player for the instance
        PlayerContainer playerContainer = new PlayerContainer(new Player());
        dungeonNavigator = new DungeonNavigator(playerContainer);
    }

    public void runGame(){
        dungeonNavigator.runDungeonNavigator();
    }
}
