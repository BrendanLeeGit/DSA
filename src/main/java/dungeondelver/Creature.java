package dungeondelver;

public abstract class Creature {
    private String name;
    private int life;
    private int attack;
    private int defense;
    private int speed;
    private int money;

    public Creature(String name, int life, int attack, int defense, int speed, int money) {
        this.name = name;
        this.life = life;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.money = money;
    }

    public Creature() {
        name = "Default";
        life = 10;
        attack = 5;
        defense = 4;
        speed = 5;
        money = 5;
    }

    public void warCry(){
        System.out.println("Die!");
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
}
