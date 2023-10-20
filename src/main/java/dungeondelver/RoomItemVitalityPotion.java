package dungeondelver;

public class RoomItemVitalityPotion extends RoomItem {
    public RoomItemVitalityPotion(){
        super("Vitality Potion");
    }

    @Override
    public void runDungeon(PlayerContainer playerContainer){
        System.out.println("You find a Vitality Potion! Time to add it to the bunch.");
        int maxHealthIncreaseValue = Dice.rollDice("1d2");
        playerContainer.modifyMaxHealth(maxHealthIncreaseValue);
        System.out.println("Your max health increases by " + maxHealthIncreaseValue + " points.");
    }
}