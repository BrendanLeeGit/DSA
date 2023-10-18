package dungeondelver;

public class RoomExit extends DungeonRoom {

    RoomExit(String type, int goldValue) {
        super(type, goldValue);
    }

    @Override
    public Player runDungeon() {
        return null;
    }
}
