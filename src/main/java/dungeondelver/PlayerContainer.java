package dungeondelver;

public class PlayerContainer {
    private Player player;

    public PlayerContainer(Player player){
        this.player = player;
    }

    public boolean isAlive(){
        return (player.getLife() > 0);
    }

    public void modifyLife(int value){
        player.setLife(player.getLife() + value);
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

    public void levelUp(){
        player.levelUp();
    }

    public Player getPlayer(){
        return player;
    }
}
