package dungeondelver;

import java.util.Random;

public class Dungeon {
    private DSACircularLinkedList<DungeonRoom> dungeonRooms;
    private final DungeonRoomFactory dungeonRoomFactory;
    private DSACircularLinkedList<DungeonRoom>.MyIterator dungeonIterator;
    private PlayerContainer playerContainer;

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

    public void runCurrentDungeon(){
        dungeonIterator.getCurrentData().runDungeon(playerContainer);
    }

    public void cycleToAvoidBeingAtExit(){
        //If the first room is the exit, then we'll just shift over to the right a few times before it starts
        if (dungeonIterator.getCurrentData() instanceof RoomExit){
            for (int i = 0; i < 4; i++){
                goRight();
            }
        }
    }

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
