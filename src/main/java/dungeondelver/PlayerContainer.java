package dungeondelver;

/**
 * Other than containing helpful methods for manipulating the contained Player, the main bonus is allowing
 * the Player to be passed around the program and manipulated by different areas. Without the Container,
 * the Player wouldn't keep the changes it undergoes from different classes when passed as a parameter.
 */
public class PlayerContainer {
    private Player player;

    public PlayerContainer(Player player){
        this.player = player;
    }

    /**
     * Checks if the player's current health is above 0.
     * @return  Whether the player's current health is above 0 or not
     */
    public boolean isAlive(){
        return (player.getLife() > 0);
    }

    public void modifyLife(int value){
        //Health needs extra care, as it can't go above max and can't go below 0
        player.setLife(player.getLife() + value);
        if (player.getLife() > player.getMaxHealth()){
            player.setLife(player.getMaxHealth());
        }
        else if (player.getLife() < 0){
            player.setLife(0);
        }
    }

    public void modifyAttack(int value){
        player.setAttack(player.getAttack() + value);
    }

    public void modifyDefense(int value){
        player.setDefense(player.getDefense() + value);
    }

    public void modifySpeed(int value){
        player.setSpeed(player.getSpeed() + value);
    }

    public void modifyMaxHealth(int value){
        player.setMaxHealth(player.getMaxHealth() + value);
    }

    public void modifyMoney(int value){
        player.setMoney(player.getMoney() + value);
    }

    public void levelUp(){
        player.levelUp();
    }

    public Player getPlayer(){
        return player;
    }
}
