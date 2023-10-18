package dungeondelver;

public class RoomTrap extends DungeonRoom {

    RoomTrap(int goldValue) {
        super("Trap", goldValue);
    }

    @Override
    public Player runDungeon() {
        return null;
    }
}
