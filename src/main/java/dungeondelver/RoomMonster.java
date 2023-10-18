package dungeondelver;

public class RoomMonster extends DungeonRoom {
    private final Creature monster;

    RoomMonster(int goldValue, Creature monster) {
        super("Monster", goldValue);
        this.monster = monster;
    }

    @Override
    public Player runDungeon() {
        return null;
    }
}
