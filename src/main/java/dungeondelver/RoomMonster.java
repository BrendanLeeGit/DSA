package dungeondelver;

public class RoomMonster extends DungeonRoom {
    private final Creature monster;
    private PlayerContainer playerContainer;

    RoomMonster(Creature monster, int goldValue) {
        super("Monster", goldValue);
        this.monster = monster;
    }

    @Override
    public void runDungeon(PlayerContainer playerContainer){
        System.out.println("You enter the room and find yourself in the presence of... a " + monster.getName() + "!");
        System.out.println("---Combat Begins---");
        this.playerContainer = playerContainer;

        //Have them fight to the death
        while (playerContainer.isAlive() && monster.getLife() > 0){
            //Speed decides who goes first in the fight
            if (playerContainer.getPlayer().getSpeed() > monster.getSpeed()){
                playerAttack();
                monsterAttack();
            }
            else {
                monsterAttack();
                playerAttack();
            }
        }
    }

    private void monsterAttack() {
        System.out.println("The " + monster.getName() + " attempts to attack you...");
        //If attack hits, roll damage and apply. If not, print out how they missed
        if (Dice.rollDice("1d20") + monster.getAttack() > Dice.rollDice("1d20") +
                playerContainer.getPlayer().getDefense()) {
            System.out.println("You get hit! You receive " + monster.getAttack() + " damage.");
            playerContainer.modifyLife(-monster.getAttack());
        }
        else {
            System.out.println("You avoid any damage!");
        }
    }

    private void playerAttack() {
        System.out.println("You attempt to attack the monster!");

        //If attack hits, roll damage and apply. If not, print out how they missed
        if (Dice.rollDice("1d20") + playerContainer.getPlayer().getAttack() >
                Dice.rollDice("1d20") + monster.getDefense()) {
            System.out.println("You manage to hit! The " + monster.getName() + " receives " +
                    playerContainer.getPlayer().getAttack() + " damage.");
            monster.setLife(monster.getLife() - monster.getAttack());
        }
        else {
            System.out.println("You miss...");
        }
    }

}
