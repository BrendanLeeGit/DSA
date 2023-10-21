package dungeondelver;

/**
 * This class builds and combines the two main components of the game: The Player and the DungeonNavigator.
 */
public class DungeonGameInstance {
    private final DungeonNavigator dungeonNavigator;

    /**
     * Creates an instance of the game. In particular, it gets the Player ready and starts up the DungeonNavigator.
     */
    public DungeonGameInstance(){
        //Create a player for the instance
        PlayerCreator playerCreator = new PlayerCreator();
        Player player = playerCreator.createPlayer();

        //Hand the player over to the container and send the container into the navigator
        PlayerContainer playerContainer = new PlayerContainer(player);
        dungeonNavigator = new DungeonNavigator(playerContainer);
    }

    /**
     * The DungeonNavigator is basically the game loop, so this runs the game loop.
     */
    public void runGame(){
        dungeonNavigator.runDungeonNavigator();
    }
}
