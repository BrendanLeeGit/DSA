package Pokemon;

public class Pokemon {
    private String name;
    private String type;
    private double health;
    private double attackDamage;
    private double defense;

    public Pokemon(String name, String type, double health, double attackDamage, double defense){
        this.name = name;
        this.type = type;
        this.health = health;
        this.attackDamage = attackDamage;
        this.defense = defense;
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

    public double getHealth(){
        return health;
    }

    public void setHealth(double health){
        this.health = health;
    }

    public double getAttackDamage(){
        return attackDamage;
    }

    public void setAttackDamage(double attackDamage){
        this.attackDamage = attackDamage;
    }

    public double getDefense(){
        return defense;
    }

    public void setDefense(double defense){
        this.defense = defense;
    }

}
