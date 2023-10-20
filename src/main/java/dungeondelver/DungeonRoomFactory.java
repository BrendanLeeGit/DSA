package dungeondelver;

/**
 * Creates Dungeon Rooms
 */
public class DungeonRoomFactory {
    private final CreatureFactory creatureFactory;
    private final ItemRoomFactory itemRoomFactory;

    //The more creatures we create, the stronger they'll be. Makes late game more difficult and ensures eventual death
    private int creatureCreationCount;

    public DungeonRoomFactory(){
        creatureFactory = new CreatureFactory();
        itemRoomFactory = new ItemRoomFactory();
    }

    public DungeonRoom getDungeonRoom(int type){
        if (type == 0){
            return new RoomTrap(20);
        }
        else if (type == 1){
            creatureCreationCount++;
            //Calculate what level to make the creature and add a random monster
            //The level calculation is (# of monsters made) / 10
            return new RoomMonster(creatureFactory.getRandomCreature(creatureCreationCount/10 + 1), 20);
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
}
