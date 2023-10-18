package dungeondelver;

public class RoomExit extends DungeonRoom {

    RoomExit() {
        super("Exit", 20);
    }

    @Override
    public void runDungeon(Player player) {
        System.out.println(getType());
    }
}
