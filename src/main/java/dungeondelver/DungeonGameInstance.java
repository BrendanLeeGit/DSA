package dungeondelver;

public class DungeonGameInstance {
    private Player player;
    private DungeonNavigator dungeonNavigator;

    public DungeonGameInstance(Player player){
        this.player = player;
        dungeonNavigator = new DungeonNavigator(player);
    }

    public void runGame(){
        dungeonNavigator.runDungeonNavigator();
    }
}
