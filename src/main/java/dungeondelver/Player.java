package dungeondelver;

public class Player extends Creature {

    Player() {
        super();
    }

    @Override
    public void warCry() {
        System.out.println("You suuuck!");
    }
}
