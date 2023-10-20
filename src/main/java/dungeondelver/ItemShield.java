package dungeondelver;

public class ItemShield extends Item{
    public ItemShield(){
        super("Shield");
    }

    @Override
    public void runEffect(PlayerContainer playerContainer){
        System.out.println("You find a shield! Time to add it to the bunch.");
        int attackIncreaseValue = Dice.rollDice("1d2");
        System.out.println("Your defense increases by " + attackIncreaseValue + " points.");
    }
}
