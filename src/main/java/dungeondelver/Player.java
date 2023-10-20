package dungeondelver;

public class Player extends Creature {
    private boolean success;   //This is used to keep track of if the player ran from the dungeon room or not
    private boolean isAtExit;   //Keeps track of if the player is currently in the exit room

    Player() {
        super();
        success = true;
        isAtExit = false;
    }

    Player(String name, int life, int attack, int defense, int speed, int money, int level) {
        super(name, life, attack, defense, speed, money, level);
        success = true;
        isAtExit = false;
    }

    @Override
    public void warCry() {
        System.out.println("You suuuck!");
    }

    public void setSuccess(boolean success){
        this.success = success;
    }

    public boolean wasSuccessful(){
        return success;
    }

    public void setIsAtExit(boolean isAtExit){
        this.isAtExit = isAtExit;
    }

    public boolean getIsAtExit(){
        return isAtExit;
    }
}
