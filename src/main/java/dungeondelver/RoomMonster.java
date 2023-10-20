package dungeondelver;

import java.util.Scanner;

public class RoomMonster extends DungeonRoom {
    private final Creature monster;
    private PlayerContainer playerContainer;
    private Scanner scan;

    RoomMonster(Creature monster, int goldValue) {
        super("Monster", goldValue);
        this.monster = monster;
        this.scan = new Scanner(System.in);
    }

    @Override
    public void runDungeon(PlayerContainer playerContainer){
        System.out.println("You enter the room and find yourself in the presence of... a " + monster.getName() + "!");
        System.out.println("---Combat Begins---");
        this.playerContainer = playerContainer;

        //Have them fight to the death
        while (playerContainer.isAlive() && monster.getLife() > 0){
            //Print out health so player can decide if they want to run
            System.out.println("Your health: " + playerContainer.getPlayer().getLife());
            System.out.println(monster.getName() + "'s health: " + monster.getLife());

            //Speed decides who goes first in the fight
            if (playerContainer.getPlayer().getSpeed() > monster.getSpeed()){
                playerAttack();
                monsterAttack();
            }
            else {
                monsterAttack();
                playerAttack();
            }

            //Let the player run away after the first round of combat
            System.out.println("Enter \"fight\" to continue fighting or \"flee\" to run.");
            String choice = scan.next();
            if (choice.equals("flee")){
                System.out.println("You run away!");

                //Set success to ensure the dungeon navigator knows this room wasn't completed
                playerContainer.getPlayer().setSuccess(false);
                break;
            }
            else if (choice.equals("fight")){
                System.out.println("You continue to fight!");
            }
            else {
                System.out.println("You're indecisive I suppose, because that was neither flee nor fight. " +
                        "So you fight!");
            }
        }
        if (monster.getLife() <= 0){
            System.out.println("You've slain the " + monster.getName() + " and receive " + getGoldValue() + " gold!");
            playerContainer.modifyMoney(getGoldValue());
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

    public String toString(){
        return "creature";
    }

}
