package dungeondelver;

public class PlayerCreator {
    public PlayerCreator(){}

    public Player createPlayer(){
        System.out.println("Hello! Welcome.");
        return new Player();
    }
}
