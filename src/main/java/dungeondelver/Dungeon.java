package dungeondelver;

import java.util.Random;

public class Dungeon {
    private DSACircularLinkedList<DungeonRoom> dungeonRooms;
    private final DungeonRoomFactory dungeonRoomFactory;
    private DSACircularLinkedList<DungeonRoom>.MyIterator dungeonIterator;
    private Player player;


    public Dungeon(){
        dungeonRooms = new DSACircularLinkedList<>();
        dungeonRoomFactory = new DungeonRoomFactory();
    }

    /**
     * Deletes the old dungeon if it had one and builds a new one.
     * @param dungeonCreationKey    The array of int values that determines the dungeon layout.
     */
    public void buildDungeon(int[] dungeonCreationKey){
        //Clear the old dungeon and increment dungeonIncrement
        dungeonRooms.clear();

        //Begin constructing a new dungeon with the new key
        int[] key = produceKey();
        for (int j : key) {
            dungeonRooms.add(dungeonRoomFactory.getDungeonRoom(j));
        }
    }

    /**
     * Returns a randomly generated array of integers, where one index has been changed to a 4.
     * @return  The randomly generated array of integers
     */
    public int[] produceKey(){
        //Generate the array of random integers of 0 - 2
        int[] producedKey = new int[10];
        Random rand = new Random();
        for (int i = 0; i < 10; i++){
            producedKey[i] = rand.nextInt(3);
        }
        //Change one of the indices to 3 to denote the exit
        producedKey[rand.nextInt(10)] = 3;
        return producedKey;
    }

    /**
     * Returns a randomly generates dungeon using the above two methods.
     */
    public void buildRandomDungeon(Player player){
        //Build the dungeon from a randomly generated key
        buildDungeon(produceKey());

        //Get the iterator so the player can traverse it
        getIteratorFromCircularLinkedList();
        this.player = player;
    }

    private void getIteratorFromCircularLinkedList(){
        dungeonIterator = dungeonRooms.getIterator();
    }

    public void goRight(){
        dungeonIterator.next();
        dungeonIterator.getCurrentData().runDungeon(player);
    }

    public void goLeft(){
        dungeonIterator.previous();
        dungeonIterator.getCurrentData().runDungeon(player);
    }

}
