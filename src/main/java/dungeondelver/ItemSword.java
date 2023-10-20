package dungeondelver;

public class ItemSword extends Item{
    public ItemSword(){
        super("Sword");
    }

    @Override
    public void runEffect(PlayerContainer playerContainer){
        System.out.println("You find a sword! Time to add it to the bunch.");
        int attackIncreaseValue = Dice.rollDice("1d2");
        System.out.println("Your attack increases by " + attackIncreaseValue + " points.");
    }
}
