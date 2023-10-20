package dungeondelver;

/**
 * Superclass for all items.
 */
public class RoomItem extends DungeonRoom{
    private String name;

    public RoomItem(String name){
        super(name, 0);
    }

    public String getName(){
        return name;
    }

    @Override
    public void runDungeon(PlayerContainer playerContainer) {
        System.out.println("The " + name + " was broken and useless...");
    }

    @Override
    public String toString(){
        return "item of some kind";
    }
}
