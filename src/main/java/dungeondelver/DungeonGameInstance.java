package dungeondelver;

public class DungeonGameInstance {
    private final DungeonNavigator dungeonNavigator;

    public DungeonGameInstance(){
        //Create a player for the instance
        Player player = new Player("Player", 20, 9, 40, 40, 0, 0);
        PlayerContainer playerContainer = new PlayerContainer(player);
        dungeonNavigator = new DungeonNavigator(playerContainer);
    }

    public void runGame(){
        dungeonNavigator.runDungeonNavigator();
    }
}
