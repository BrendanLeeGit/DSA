package dungeondelver;

public class DungeonGameInstance {
    private DungeonNavigator dungeonNavigator;

    public DungeonGameInstance(PlayerContainer playerContainer){
        dungeonNavigator = new DungeonNavigator(playerContainer);
    }

    public void runGame(){
        dungeonNavigator.runDungeonNavigator();
    }
}
