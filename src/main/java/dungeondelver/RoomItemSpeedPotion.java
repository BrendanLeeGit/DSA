package dungeondelver;

public class RoomItemSpeedPotion extends RoomItem {
    public RoomItemSpeedPotion(){
        super("Speed Potion");
    }

    @Override
    public void runDungeon(PlayerContainer playerContainer){
        System.out.println("You find a Speed Potion. Bottoms up!");
        int speedIncreaseValue = Dice.rollDice("1d2");
        playerContainer.modifySpeed(speedIncreaseValue);
        System.out.println("Your speed increases by " + speedIncreaseValue + " points.");
    }
}