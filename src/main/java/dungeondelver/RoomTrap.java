package dungeondelver;

public class RoomTrap extends DungeonRoom {

    RoomTrap(int goldValue) {
        super("Trap", goldValue);
    }

    @Override
    public void runDungeon(PlayerContainer playerContainer){
        System.out.println("It's a trap!");
        System.out.println("An arrow flies out towards you!");
        if (Dice.rollDice("1d20") + 5 >= playerContainer.getPlayer().getDefense() + 10){
            int diceRoll = Dice.rollDice("2d4");
            playerContainer.modifyLife(-diceRoll);
            System.out.println("It hits.\nYou lost " + diceRoll + " hp.");
        }
        else {
            System.out.println("The arrow bounces off your armor!");
        }
    }

    @Override
    public String toString(){
        return "suspicious area";
    }
}
