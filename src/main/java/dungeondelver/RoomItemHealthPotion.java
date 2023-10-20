package dungeondelver;

public class RoomItemHealthPotion extends RoomItem {
    public RoomItemHealthPotion(){
        super("Health Potion");
    }

    @Override
    public void runDungeon(PlayerContainer playerContainer){
        System.out.println("You find a health potion!");
        int healValue = Dice.rollDice("3d8");
        playerContainer.modifyLife(healValue);
        System.out.println("You heal " + healValue + " hp.");
    }
}
