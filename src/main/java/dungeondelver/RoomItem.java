package dungeondelver;

public class RoomItem extends DungeonRoom {
    RoomItem() {
        super("Item", 0);
    }

    @Override
    public void runDungeon(Player player) {
        System.out.println(getType());
    }
}
