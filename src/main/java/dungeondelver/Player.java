package dungeondelver;

/**
 * The class that represents the Player, aka the entity the user controls throughout the game.
 */
public class Player extends Creature {
    private boolean success;   //This is used to keep track of if the player ran from the dungeon room or not
    private boolean isAtExit;   //Keeps track of if the player is currently in the exit room
    private boolean fledThisDungeon; //Keeps track of whether this player fled this dungeon or not

    /**
     * Generates a default player with lower end stats.
     */
    public Player() {
        super();
        success = true;
        isAtExit = false;
        fledThisDungeon = false;
    }

    /**
     * Generates a custom player with the inputted stats. This is used when importing already created characters.
     * @param name      The name of the Creature
     * @param life      The health points the Creature has
     * @param attack    How hard and how accurately the Creature hits
     * @param defense   How well the Creature resists attacks
     * @param speed     How likely the Creature is to go first in a fight
     * @param money     How much gold the Creature has
     * @param level     What level the Creature is
     */
    public Player(String name, int life, int attack, int defense, int speed, int money, int level) {
        super(name, life, attack, defense, speed, money, level);
        success = true;
        isAtExit = false;
        fledThisDungeon = false;
    }

    /**
     * Used to create a new custom character with an inputted name. This Player also starts with lower end stats.
     * @param name
     */
    public Player(String name){
        super();
        success = true;
        isAtExit = false;
        fledThisDungeon = false;
        setName(name);
    }

    @Override
    public void warCry() {
        System.out.println("You suuuck!");
    }

    public void setSuccess(boolean success){
        this.success = success;
    }

    public boolean wasSuccessful(){
        return success;
    }

    public void setIsAtExit(boolean isAtExit){
        this.isAtExit = isAtExit;
    }

    public boolean getIsAtExit(){
        return isAtExit;
    }

    public boolean getFledThisDungeon() {
        return fledThisDungeon;
    }

    public void setFledThisDungeon(boolean fledThisDungeon) {
        this.fledThisDungeon = fledThisDungeon;
    }
}
