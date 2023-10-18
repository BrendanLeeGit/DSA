package dungeondelver;

/**
 * Creates Dungeon Rooms
 */
public class DungeonRoomFactory {
    private final CreatureFactory creatureFactory;

    //The more creatures we create, the stronger they'll be. Makes late game more difficult and ensures eventual death
    private int creatureCreationCount;

    public DungeonRoomFactory(){
        creatureFactory = new CreatureFactory();
    }

    public DungeonRoom getDungeonRoom(int type){
        if (type == 0){
            return new RoomTrap(20);
        }
        else if (type == 1){
            creatureCreationCount++;
            //Calculate what level to make the creature
            //Pick a random creature to fill the room with

            return null;
        }

        //TODO: Finish
        return null;
    }
}
