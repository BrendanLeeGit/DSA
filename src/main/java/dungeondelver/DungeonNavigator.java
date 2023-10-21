package dungeondelver;

import java.util.Scanner;

/**
 * This essentially contains the game loop. Most of the logic and player interaction is here.
 */
public class DungeonNavigator {
    private Dungeon dungeon;
    private Scanner scan;
    private PlayerContainer playerContainer;
    private int roomNumber; //Mainly used to check if the player runs from the very first room
    private int globalRoomNumber; //Used to check total rooms progressed through

    /**
     * Initializes the DungeonNavigator with the inputted PlayerContainer. Also generates a Dungeon for its own use.
     * @param playerContainer   The PlayerContainer that contains the Player to be used
     */
    public DungeonNavigator(PlayerContainer playerContainer){
        this.dungeon = new Dungeon(playerContainer);
        this.scan = new Scanner(System.in);
        this.playerContainer = playerContainer;
        globalRoomNumber = 1;
    }

    /**
     * This is essentially the entire game loop. Call it when you want the game to begin.
     */
    public void runDungeonNavigator(){
        //Introduction stuff and soem tips
        System.out.println("Welcome to the dungeon! We hope you enjoy your stay.");
        System.out.println("Your gained stats will carry with you as you continue to play, but monsters will get " +
                "stronger as\nyou get farther into the dungeon.");
        System.out.println("Enter in anything to begin.");
        scan.next();

        //Keep flee variable out here so the entire loop can check it
        boolean fled = false;

        //Encasing loop for if the player wants to continue playing.
        for (;;){
            playerContainer.modifyLife(playerContainer.getPlayer().getMaxHealth());      //Set the player to full hp

            //Print out all the player stats
            System.out.println("Your stats:");
            System.out.println("Max health: " + playerContainer.getPlayer().getMaxHealth());
            System.out.println("Attack: " + playerContainer.getPlayer().getAttack());
            System.out.println("Defense: " + playerContainer.getPlayer().getDefense());
            System.out.println("Speed: " + playerContainer.getPlayer().getSpeed() + "\n");

            //Player death will generally be handled more specifically in dungeon rooms as well
            while (playerContainer.isAlive()){
                //Build a very random dungeon
                dungeon.buildRandomDungeon();
                playerContainer.getPlayer().setFledThisDungeon(false); //New dungeon, so they can flee again
                roomNumber = 1;
                String choice = "right";
                playerContainer.getPlayer().setIsAtExit(false);     //Player is probably not at the exit

                //And if they are, cycle a few rooms so that they aren't
                dungeon.cycleToAvoidBeingAtExit();

                //Continue until the player hits the exit
                while (!playerContainer.getPlayer().getIsAtExit()){

                    //Stay optimistic! Start successful and only change if the character flees a dungeon
                    playerContainer.getPlayer().setSuccess(true);
                    dungeon.runCurrentDungeon();

                    //Check if the player succumbs from the wounds they got in the dungeon
                    if (!playerContainer.isAlive()){
                        System.out.println("You succumb to your wounds and die...");
                        System.out.println("You got to room " + roomNumber + "!");
                        System.out.println("Total rooms traversed: " + globalRoomNumber + ".");
                        break;
                    }

                    //If the player passes the room, then they get to continue to the next!
                    if (playerContainer.getPlayer().wasSuccessful()){
                        roomNumber++;
                        globalRoomNumber++;

                        //Let the player see what's in each room with peek
                        System.out.println("The right room houses a " + dungeon.peakRight() + ".");
                        System.out.println("The left room houses a " + dungeon.peakLeft() + ".");

                        //Prompt user for directions and interpret them
                        System.out.println("Current health: " + playerContainer.getPlayer().getLife());
                        System.out.println("\nEnter \"right\" to go right or \"left\" to go left");
                        choice = scan.next();

                        //Clear dungeon room moves the player and deletes the current room
                        dungeon.clearDungeonRoom(choice);
                    }
                    //If the player flees from the room, they go back to the previous room
                    else {
                        //Need to reset success
                        playerContainer.getPlayer().setSuccess(true);
                        System.out.println("Lick your wounds, but remember that you still have to trudge forwards!");

                        //Move them back to the room they didn't choose
                        if (roomNumber != 1){
                            if (choice.equals("right")){
                                dungeon.goLeft();
                                System.out.println("To the room in the opposite direction!");
                            }
                            else if (choice.equals("left")){
                                dungeon.goRight();
                                System.out.println("To the room in the opposite direction!");
                            }
                            else {
                                System.out.println("Well, I suppose you go right back into the room!");
                            }
                        }
                        //And if they're only at the first room, then they have nowhere else to go and must reenter.
                        else {
                            System.out.println("This is the first room of the dungeon... You'll have to reenter it.");
                        }
                    }
                }
            }

            //Now we check if they wanna continue, and we print out stats and update the char if not
            System.out.println("Would you like to keep going? Type \"yes\" if so, and \"no\" if not.");
            String keepGoing = scan.next();
            if (keepGoing.equals("no")){
                PlayerCreator.createPlayerFile(playerContainer.getPlayer());
                System.out.println("You ended with " + playerContainer.getPlayer().getMoney() + " gold!");
                break;
            }
            else {
                System.out.println("Then we continue on!");
            }
            //If the player enters something wrong, they'll just keep going automatically
        }
    }
}
