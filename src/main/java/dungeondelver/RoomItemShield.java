package dungeondelver;

public class RoomItemShield extends RoomItem {
    public RoomItemShield(){
        super("Shield");
    }

    @Override
    public void runDungeon(PlayerContainer playerContainer){
        System.out.println("You find a shield! Time to add it to the bunch.");
        int defenseIncreaseValue = Dice.rollDice("1d2");
        playerContainer.modifyDefense(defenseIncreaseValue);
        System.out.println("Your defense increases by " + defenseIncreaseValue + " points.");
    }
}
