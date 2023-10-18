package dungeondelver;

public class RoomTrap extends DungeonRoom {

    RoomTrap(int goldValue) {
        super("Trap", goldValue);
    }

    @Override
    public void runDungeon(Player player) {
        System.out.println(getType());
    }
}
