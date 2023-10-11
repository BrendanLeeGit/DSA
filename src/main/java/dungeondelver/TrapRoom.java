package dungeondelver;

public class TrapRoom extends DungeonRoom{
    TrapRoom(int goldValue) {
        super("Trap", goldValue);
    }

    @Override
    public Player runDungeon() {
        return new Player();
    }
}
