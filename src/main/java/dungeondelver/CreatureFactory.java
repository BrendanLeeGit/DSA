package dungeondelver;

public class CreatureFactory {
    int monsterLevels;

    public CreatureFactory(){}

    public Creature getCreature(String creatureName){
        if (creatureName.equals("Goblin")){
            return new Goblin();
        }
        else if (creatureName.equals("Bugbear")){
            //TODO: Make a player ofc!

        }

        return null;
    }
}
