package dungeondelver;

public class ItemVitalityPotion extends Item{
    public ItemVitalityPotion(){
        super("Vitality Potion");
    }

    @Override
    public void runEffect(PlayerContainer playerContainer){
        System.out.println("You find a Vitality Potion! Time to add it to the bunch.");
        int maxHealthIncreaseValue = Dice.rollDice("1d2");
        System.out.println("Your max health increases by " + maxHealthIncreaseValue + " points.");
    }
}