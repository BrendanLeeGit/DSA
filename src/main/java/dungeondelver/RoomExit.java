package dungeondelver;

public class RoomExit extends DungeonRoom {

    RoomExit() {
        super("Exit", 20);
    }

    @Override
    public Player runDungeon() {
        return null;
    }
}
