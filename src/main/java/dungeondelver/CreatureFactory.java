package dungeondelver;

public class CreatureFactory {
    int monsterLevels;

    public CreatureFactory(){}

    public Creature getCreature(String creatureName){
        return new Creature();
    }
}
