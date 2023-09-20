package Pokemon;

/**
 * Pokemon subclass just for the Onyx.
 */
public class Onyx extends Pokemon implements LevelUpMethod {

    /**
     * Builds an onyx with input stats and stuff. A custom onyx I suppose.
     * @param name
     * @param type
     * @param health
     * @param attack
     * @param defense
     */
    public Onyx(String name, String type, double health, double attack, double defense, double speed) {
        super(name, type, health, attack, defense, speed);
    }

    /**
     * Make a default onyx with default stats.
     */
    public Onyx() {
        super("Onyx", "Normal", 20, 2, 4, 6);
    }

    /**
     * The title shoould be self-explanatory.
     */
    public void levelUp() {
        //Get stats from superclass
        //I think this would be better without a subclass for each Pokemon tbh
        double[] stats = getStats();
        for (int i = 0; i < stats.length; i++){
            setStat(i, getStat(i) * 1.2);
        }
    }

    /**
     * Adds the pokemon's attacks to their arsenal :D. These attacks of course must bei in Attacks.txt
     */
    public void addAttacks(){
        addAttack("Heavy Slam");
    }

}
