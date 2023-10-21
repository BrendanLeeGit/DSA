package dungeondelver;

import java.util.Random;

/**
 * The class that represents the Dungeon's structure and layout.
 */
public class Dungeon {
    private DSACircularLinkedList<DungeonRoom> dungeonRooms;
    private final DungeonRoomFactory dungeonRoomFactory;
    private DSACircularLinkedList<DungeonRoom>.MyIterator dungeonIterator;
    private PlayerContainer playerContainer;

    /**
     * Initializes a Dungeon with the inputted PlayerContainer.
     * @param playerContainer   The PlayerContainer that holds the Player that will traverse the dungeon
     */
    public Dungeon(PlayerContainer playerContainer){
        dungeonRooms = new DSACircularLinkedList<>();
        dungeonRoomFactory = new DungeonRoomFactory();
        this.playerContainer = playerContainer;
    }

    /**
     * Deletes the old dungeon if it had one and builds a new one.
     * @param dungeonCreationKey    The array of int values that determines the dungeon layout.
     */
    public void buildDungeon(int[] dungeonCreationKey){
        //Clear the old dungeon and increment dungeonIncrement
        dungeonRooms.clear();

        //Begin constructing a new dungeon with the new key
        int[] key = produceKey(15);
        for (int j : key) {
            dungeonRooms.add(dungeonRoomFactory.getDungeonRoom(j));
        }

        //Making a new dungeon, so reset the level of the monsters
        dungeonRoomFactory.resetCreatureCreationCount();
    }

    /**
     * Returns a randomly generated array of integers, where one index has been changed to a 4.
     * @return  The randomly generated array of integers
     */
    public int[] produceKey(int keySize){
        //Generate the array of random integers of 0 - 2
        int[] producedKey = new int[keySize];
        Random rand = new Random();
        for (int i = 0; i < keySize; i++){
            producedKey[i] = rand.nextInt(3);
        }
        //Change one of the indices to 3 to denote the exit
        producedKey[rand.nextInt(10)] = 3;
        return producedKey;
    }

    /**
     * Returns a randomly generates dungeon using the above two methods.
     */
    public void buildRandomDungeon(){
        //Build the dungeon from a randomly generated key with 15 rooms
        buildDungeon(produceKey(15));

        //Get the iterator so the player can traverse it
        getIteratorFromCircularLinkedList();
    }

    /**
     * Updates the Iterator, making sure that the discarded old dungeons aren't still in use.
     */
    private void getIteratorFromCircularLinkedList(){
        dungeonIterator = dungeonRooms.getIterator();
        dungeonIterator.next();
    }

    public void goRight(){
        dungeonIterator.next();
    }

    public void goLeft(){
        dungeonIterator.previous();
    }

    public String peakLeft(){
        return dungeonIterator.peakLeft();
    }

    public String peakRight(){
        return dungeonIterator.peakRight();
    }

    /**
     * Calls the run method of the current dungeon room.
     */
    public void runCurrentDungeon(){
        dungeonIterator.getCurrentData().runDungeon(playerContainer);
    }

    /**
     * Occasionally, the Player may start in an exit room in the dungeon. To prevent this, we cycle them
     * a bit before they start traversing.
     */
    public void cycleToAvoidBeingAtExit(){
        //If the first room is the exit, then we'll just shift over to the right a few times before it starts
        if (dungeonIterator.getCurrentData() instanceof RoomExit){
            for (int i = 0; i < 4; i++){
                goRight();
            }
        }
    }

    /**
     * Removes the current dungeon room. Use this once the Player successfully clears a room and needs to move on.
     * @param direction Whether the Player will move to the left or the right after clearing the room.
     */
    public void clearDungeonRoom(String direction){
        try {
            if (direction.equals("left")){
                dungeonIterator.removeCurrentNodeGoToLeft();
            }
            else if (direction.equals("right")){
                dungeonIterator.removeCurrentNodeGoToRight();
            }
        } catch(Exception e){
            System.out.println("\"left\" or \"right\", but since you got it wrong I'll choose right for you");
            dungeonIterator.removeCurrentNodeGoToRight();
        }

    }
}
