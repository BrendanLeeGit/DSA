package dungeondelver;

/**
 * Creates Dungeon Rooms
 */
public class DungeonRoomFactory {
    private final CreatureFactory creatureFactory;
    private final ItemRoomFactory itemRoomFactory;

    //The more creatures we create, the stronger they'll be. Makes late game more difficult and ensures eventual death
    private int creatureCreationCount;

    /**
     * Initializes the Dungeon Room Factory by generating the Creature and Item Room Factories and setting
     * creatureCreationCount to 0.
     */
    public DungeonRoomFactory(){
        creatureFactory = new CreatureFactory();
        itemRoomFactory = new ItemRoomFactory();
        creatureCreationCount = 0;
    }

    /**
     * Returns a Dungeon room with the associated type.
     * @param type  The int representation of room type. Trap - 0, Monster - 1, Item - 2, Exit -3.
     * @return      The generated DungeonRoom
     */
    public DungeonRoom getDungeonRoom(int type){
        if (type == 0){
            return new RoomTrap(20);
        }
        else if (type == 1){
            creatureCreationCount++;
            //Calculate what level to make the creature and add a random monster
            //The level calculation is (# of monsters made) / 10
            return new RoomMonster(creatureFactory.getRandomCreature(creatureCreationCount/10), 20);
        }
        else if (type == 2){
            return itemRoomFactory.getRandomItem();
        }
        else if (type == 3){
            return new RoomExit();
        }
        //We'll default to a trap if something goes wrong with the room creation process
        return new RoomTrap(0);
    }

    /**
     * When a new game begins, this resets the levels of the monsters by resetting the creatureCreationCount.
     */
    public void resetCreatureCreationCount(){
        creatureCreationCount = 0;
    }
}
