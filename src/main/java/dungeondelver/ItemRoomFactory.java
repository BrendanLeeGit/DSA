package dungeondelver;

import java.util.Random;

/**
 * Used to generate different ItemRooms. Unlike the CreatureFactory, each room is its own class.
 */
public class ItemRoomFactory {
    private final String[] itemNames;

    /**
     * Initializes the ItemRoomFactory with a list of initial items.
     */
    public ItemRoomFactory(){
        itemNames = new String[]{"Health Potion", "Sword", "Shield", "Vitality Potion"};
    }

    /**
     * Creates and returns a RoomItem with the given name.
     * @param itemName  The name of the RoomItem wanted, such as "Health" for health potion room
     * @return          The generates RoomItem
     */
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
