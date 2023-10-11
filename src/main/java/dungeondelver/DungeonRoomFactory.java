package dungeondelver;

/**
 * Creates Dungeon Rooms
 */
public class DungeonRoomFactory {
    public DungeonRoomFactory(){

    }

    public DungeonRoom getDungeonRoom(int type){
        if (type == 0){
            return new TrapRoom(20);
        }
        else {
            return null;
        }
    }
}
