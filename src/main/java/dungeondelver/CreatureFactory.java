package dungeondelver;

public class CreatureFactory {
    int monsterLevels;

    public CreatureFactory(){}

    public Creature getCreature(String creatureName){
        if (creatureName.equals("Goblin")){
            return new Creature("Goblin", 10, 4, 2, 10, 5) {
                @Override
                public void warCry() {
                    System.out.println("I'll use your intestines as a scarf!");
                }
            };
        }
        else if (creatureName.equals("Bugbear")){
            return new Creature("Bugbear", 25, 5, 3, 5, 20) {
                @Override
                public void warCry() {
                    System.out.println("Surprise! Get screwed!");
                }
            };
        }
        return null;
    }
}
