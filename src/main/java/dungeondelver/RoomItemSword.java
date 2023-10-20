package dungeondelver;

public class RoomItemSword extends RoomItem {
    public RoomItemSword(){
        super("Sword");
    }

    @Override
    public void runDungeon(PlayerContainer playerContainer){
        System.out.println("You find a sword! Time to add it to the bunch.");
        int attackIncreaseValue = Dice.rollDice("1d2");
        playerContainer.modifyAttack(attackIncreaseValue);
        System.out.println("Your attack increases by " + attackIncreaseValue + " points.");
    }
}
