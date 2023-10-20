package dungeondelver;

import java.util.Scanner;

/**
 * Used to navigate the dungeons properly. :D
 */
public class DungeonNavigator {
    private Dungeon dungeon;
    private Scanner scan;
    private PlayerContainer playerContainer;
    private int roomNumber; //Mainly used to check if the player runs from the very first room
    private int globalRoomNumber; //Used to check total rooms progressed through

    public DungeonNavigator(PlayerContainer playerContainer){
        this.dungeon = new Dungeon(playerContainer);
        this.scan = new Scanner(System.in);
        this.playerContainer = playerContainer;
        globalRoomNumber = 1;
    }

    public void runDungeonNavigator(){
        //Introduction stuff
        System.out.println("Welcome to the dungeon! We hope you enjoy your stay.");
        System.out.println("Enter in anything to begin.");
        scan.next();

        //Player death will generally be handled more specifically in dungeon rooms as well
        while (playerContainer.isAlive()){
            //Build a very random dungeon
            dungeon.buildRandomDungeon();
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
                    System.out.println("You got to room " + globalRoomNumber + "!");
                    break;
                }

                //If the player passes the room, then they get to continue to the next!
                if (playerContainer.getPlayer().wasSuccessful()){
                    roomNumber++;
                    globalRoomNumber++;
                    //Prompt user for directions and interpret them
                    System.out.println("Current health: " + playerContainer.getPlayer().getLife());
                    System.out.println("\nEnter \"right\" to go right or \"left\" to go left");
                    choice = scan.next();

                    //Clear dungeon room moves the player and deletes the current room
                    dungeon.clearDungeonRoom(choice);
                }
                //If the player flees from the room, they go back to the previous room
                else {
                    System.out.println("Lick your wounds, but remember that you still have to trudge forwards!");

                    //And if they're only at the first room, then they have nowhere else to go and must reenter.
                    if (roomNumber != 0){
                        if (choice.equals("right")){
                            dungeon.goLeft();
                        }
                        else if (choice.equals("left")){
                            dungeon.goRight();
                        }
                        else {
                            System.out.println("Well, I suppose you go right back into the room!");
                        }
                    }
                    else {
                        System.out.println("This is the first room of the dungeon... You'll have to reenter it.");
                    }
                }
            }
        }
    }
}
