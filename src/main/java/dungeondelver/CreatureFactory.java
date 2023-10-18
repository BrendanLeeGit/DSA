package dungeondelver;

import java.util.Random;

public class CreatureFactory {
    String[] monsterNames;

    public CreatureFactory(){
        monsterNames = new String[]{"Goblin", "Bugbear"};
    }

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
     * Returns a random creature of the bunch.
     * @param level The level of the creature that will be returned
     * @return      The randomly created creature
     */
    public Creature getRandomCreature(int level){
        Random rand = new Random();
        return getCreature(monsterNames[rand.nextInt(2)], level);
    }
}
