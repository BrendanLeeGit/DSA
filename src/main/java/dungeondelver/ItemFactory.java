package dungeondelver;

import java.util.Random;

public class ItemFactory {
    private final String[] itemNames;

    public ItemFactory(){
        itemNames = new String[]{"Health Potion", "Sword", "Shield", "Vitality Potion"};
    }

    public Item getItem(String itemName){
        if (itemName.equals("Health")){
            return new ItemHealthPotion();
        }
        else if (itemName.equals("")){
            return null;
        }
        return getRandomItem();
    }

    /**
     * Returns a random item of the bunch.
     * @return      The randomly created creature
     */
    public Item getRandomItem(){
        Random rand = new Random();
        return getItem(itemNames[rand.nextInt(2)]);
    }
}
