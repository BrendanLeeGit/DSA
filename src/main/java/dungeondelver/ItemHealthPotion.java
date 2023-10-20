package dungeondelver;

public class ItemHealthPotion extends Item{
    public ItemHealthPotion(){
        super("Health Potion");
    }

    @Override
    public void runEffect(PlayerContainer playerContainer){
        System.out.println("You find a health potion!");
        int healValue = Dice.rollDice("3d4");
        playerContainer.modifyLife(healValue);
        System.out.println("You heal " + healValue + " hp.");
    }
}
