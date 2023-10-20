package dungeondelver;

public class Creature {
    private String name;
    private int life;
    private int attack;
    private int defense;
    private int speed;
    private int money;
    private int level;
    private int maxHealth;

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

    public Creature() {
        name = "Default";
        life = 10;
        attack = 5;
        defense = 4;
        speed = 5;
        money = 0;
        level = 0;
        maxHealth = 10;
    }

    public void warCry(){
        System.out.println("Die!");
    }

    public void levelUp(){
        level++;
        life = (int) (life * 1.2);
        attack = (int) (attack * 1.2);
        defense = (int) (defense * 1.2);
        speed = (int) (speed * 1.2);
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
}
