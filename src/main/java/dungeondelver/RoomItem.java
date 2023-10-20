package dungeondelver;

public class RoomItem extends DungeonRoom {
    RoomItem() {
        super("Item", 0);
    }

    @Override
    public void runDungeon(PlayerContainer playerContainer){
        System.out.println(getType() + " room!");
    }
}
