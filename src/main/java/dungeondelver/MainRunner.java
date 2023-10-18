package dungeondelver;

public class MainRunner {
    public static void main(String[] args){
        Player test = new Player();
        System.out.println(test.getAttack());
        PlayerModifierTest playerModifierTest = new PlayerModifierTest();
        playerModifierTest.changePlayer(test);
        System.out.println(test.getAttack());

        DungeonGameInstance dungeonGameInstance = new DungeonGameInstance(new Player());
        dungeonGameInstance.runGame();
    }
}
