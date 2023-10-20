package dungeondelver;

public abstract class DungeonRoom {
    private String type;
    private int goldValue;

    DungeonRoom(String type, int goldValue){
        this.type = type;
        this.goldValue = goldValue;
    }

    public int getGoldValue(){
        return goldValue;
    }

    public String getType(){
        return type;
    }

    public abstract void runDungeon(PlayerContainer playerContainer);
}
