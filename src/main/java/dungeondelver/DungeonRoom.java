package dungeondelver;

public abstract class DungeonRoom {
    String type;
    int goldValue;

    DungeonRoom(String type, int goldValue){
        this.type = type;
        this.goldValue = goldValue;
    }

    public abstract Player runDungeon();
}
