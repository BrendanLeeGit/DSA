package Pokemon;

/**
 * Pokemon subclass just for the Onyx.
 */
public class Onyx extends Pokemon implements LevelUpMethod {

    public Onyx(String name, String type, double health, double attack, double defense) {
        super(name, type, health, attack, defense);
    }

    public void levelUp() {
        //Get stats from superclass
        //I think this would be better without a subclass for each Pokemon tbh
        double[] stats = getStats();
        for (int i = 0; i < stats.length; i++){
            setStat(i, getStat(i) * 1.2);
        }
    }

    public void addAttacks(){
        addAttack("Heavy Slam");
    }

}
