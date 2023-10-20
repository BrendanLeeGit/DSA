package dungeondelver;

public class MainRunner {
    public static void main(String[] args){
        PlayerContainer playerContainer = new PlayerContainer(new Player());
        DungeonGameInstance dungeonGameInstance = new DungeonGameInstance(playerContainer);
        dungeonGameInstance.runGame();
    }
}
