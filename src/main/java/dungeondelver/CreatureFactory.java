package dungeondelver;

public class CreatureFactory {
    int monsterLevels;

    public CreatureFactory(){}

    public Creature getCreature(String creatureName, int level){
        if (creatureName.equals("Goblin")){
            return new Creature("Goblin", 10, 4, 2, 10, 5, level) {
                @Override
                public void warCry() {
                    System.out.println("I'll use your intestines as a scarf!");
                }
            };
        }
        else if (creatureName.equals("Bugbear")){
            return new Creature("Bugbear", 25, 5, 3, 5, 20, level) {
                @Override
                public void warCry() {
                    System.out.println("Surprise! Get screwed!");
                }
            };
        }
        return null;
    }

    /**
     * Returns a String[] with all the current monster names.
     * @return  the String[] with all the current monster names
     */
    public static String[] getMonsterNames(){
        return new String[]{"Goblin", "Bugbear"};
    }
}
