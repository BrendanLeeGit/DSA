package Pokemon;

import java.util.ArrayList;
import java.util.Random;

public class Pokemon {
    private String name;
    private String type;
    private Random rand;

    //Stats are in the following order:
    //     - health, attackDamage, defense
    //And all doubles :D
    private double[] stats;

    //Used to record the attacks the Pokemon is able to use
    private ArrayList<String> attackChoices;

    public Pokemon(String name, String type, double health, double attackDamage, double defense){
        this.name = name;
        this.type = type;
        this.stats = new double[]{health, attackDamage, defense};
        attackChoices = new ArrayList<>();
        rand = new Random();
    }

    public void setStat(int statIndex, double valueToSetTo){
        stats[statIndex] = valueToSetTo;
    }

    public void changeStat(int statIndex, double valueToAdd){
        stats[statIndex] += valueToAdd;
    }

    public double[] getStats(){
        return stats;
    }

    public double getStat(int statIndex){
        return stats[statIndex];
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public void addAttack(String attackName){
        attackChoices.add(attackName);
    }

    public String chooseRandomAttack(){
        int randAttackIndex = rand.nextInt(attackChoices.size());
        return attackChoices.get(randAttackIndex);
    }
}
