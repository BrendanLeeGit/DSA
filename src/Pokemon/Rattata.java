package Pokemon;

public class Rattata extends Pokemon implements LevelUpMethod {

    public Rattata(String name, String type, double health, double attack, double defense) {
        super(name, type, health, attack, defense);
    }

    @Override
    public void LevelUp() {
        setHealth(getHealth() + 6);

    }


}
