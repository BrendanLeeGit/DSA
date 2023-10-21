package dungeondelver;

/**
 * Supertype for every other dungeon room in the game.
 */
public abstract class DungeonRoom {
    private String type;
    private int goldValue;

    /**
     * Constructs the room with the given type and gold value.
     * @param type      The type of room (I.e. monster or trap)
     * @param goldValue How much gold is inside the room
     */
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

    /**
     * Every dungeon room has some sort of effect on the player. This method is what makes the effect happen.
     * @param playerContainer   The PlayerContainer that contains the Player
     */
    public abstract void runDungeon(PlayerContainer playerContainer);
}
