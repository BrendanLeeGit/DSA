package Pokemon;

public class Rattata extends Pokemon implements LevelUpMethod {

    public Rattata(String name, String type, double health, double attack, double defense) {
        super(name, type, health, attack, defense);
    }

    @Override
    public void LevelUp() {
        //Get stats from superclass
        //I think this would be better without a subclass for each Pokemon tbh
        double[] stats = getStats();
        for (int i = 0; i < stats.length; i++){
            setStat(i, getStat(i) * 1.2);
        }
    }

    public void addAttacks(){
        addAttack("Bite");
    }

}
