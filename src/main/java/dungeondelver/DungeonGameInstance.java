package dungeondelver;

public class DungeonGameInstance {
    private final DungeonNavigator dungeonNavigator;

    public DungeonGameInstance(){
        //Create a player for the instance
        PlayerCreator playerCreator = new PlayerCreator();
        Player player = playerCreator.createPlayer();

        //Hand the player over to the container and send the container into the navigator
        PlayerContainer playerContainer = new PlayerContainer(player);
        dungeonNavigator = new DungeonNavigator(playerContainer);
    }

    public void runGame(){
        dungeonNavigator.runDungeonNavigator();
    }
}
