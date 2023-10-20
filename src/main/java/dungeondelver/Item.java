package dungeondelver;

/**
 * Superclass for all items.
 */
public class Item {
    private String name;

    public Item(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void runEffect(PlayerContainer playerContainer){
        System.out.println("");
    }
}
