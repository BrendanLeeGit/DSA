package dungeondelver;

/**
 * Class to represent any living creature in the game.
 */
public class Creature {
    private String name;
    private int life;
    private int attack;
    private int defense;
    private int speed;
    private int money;
    private int level;
    private int maxHealth;

    /**
     * Constructs a Creature with the inputted stats
     * @param name      The name of the Creature
     * @param life      The health points the Creature has
     * @param attack    How hard and how accurately the Creature hits
     * @param defense   How well the Creature resists attacks
     * @param speed     How likely the Creature is to go first in a fight
     * @param money     How much gold the Creature has
     * @param level     What level the Creature is
     */
    public Creature(String name, int life, int attack, int defense, int speed, int money, int level) {
        this.name = name;
        this.life = life + (int) (life * (level * .1));
        this.attack = attack + (int) (attack * (level * .1));
        this.defense = defense + (int) (defense * (level * .1));
        this.speed = speed + (int) (speed * (level * .1));
        this.money = money;
        this.level = level;
        maxHealth = this.life;
    }

    /**
     * Initializes a default creature with very minor stats.
     */
    public Creature() {
        name = "Default";
        life = 10;
        attack = 4;
        defense = 3;
        speed = 5;
        money = 0;
        level = 0;
        maxHealth = 10;
    }

    /**
     * Used for giving each Creature its own signature voice line.
     */
    public void warCry(){
        System.out.println("Die!");
    }

    /**
     * Levels up the creature, increasing all of its combat stats.
     */
    public void levelUp(){
        level++;
        life += (int) (life * (level * .1));
        attack += (int) (attack * (level * .1));
        defense += (int) (defense * (level * .1));
        speed += (int) (speed * (level * .1));
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxHealth(int value){
        maxHealth = value;
    }

    public int getMaxHealth(){
        return maxHealth;
    }

    public int getLevel(){
        return level;
    }
}
