package dungeondelver;

import java.util.Random;

public class ItemRoomFactory {
    private final String[] itemNames;

    public ItemRoomFactory(){
        itemNames = new String[]{"Health Potion", "Sword", "Shield", "Vitality Potion"};
    }

    public RoomItem getItem(String itemName){
        if (itemName.equals("Health")){
            return new RoomItemHealthPotion();
        }
        else if (itemName.equals("Sword")){
            return new RoomItemShield();
        }
        else if (itemName.equals("Shield")){
            return new RoomItemShield();
        }
        else if (itemName.equals("Vitality Potion")){
            return new RoomItemShield();
        }
        return getRandomItem();
    }

    /**
     * Returns a random item of the bunch.
     * @return      The randomly created creature
     */
    public RoomItem getRandomItem(){
        Random rand = new Random();
        return getItem(itemNames[rand.nextInt(2)]);
    }
}
