package dungeondelver;

public class RoomMonster extends DungeonRoom {
    private final Creature monster;

    RoomMonster(Creature monster, int goldValue) {
        super("Monster", goldValue);
        this.monster = monster;
    }

    @Override
    public Player runDungeon() {
        return null;
    }
}
