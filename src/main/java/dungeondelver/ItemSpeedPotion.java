package dungeondelver;

public class ItemSpeedPotion extends Item{
    public ItemSpeedPotion(){
        super("Speed Potion");
    }

    @Override
    public void runEffect(PlayerContainer playerContainer){
        System.out.println("You find a Speed Potion. Bottoms up!");
        int speedIncreaseValue = Dice.rollDice("1d2");
        System.out.println("Your speed increases by " + speedIncreaseValue + " points.");
    }
}