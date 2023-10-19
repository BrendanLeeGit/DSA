package dungeondelver;

import java.util.Scanner;

/**
 * Used to navigate the dungeons properly. :D
 */
public class DungeonNavigator {
    private Dungeon dungeon;
    private Player player;
    private Scanner scan;

    public DungeonNavigator(Player player){
        this.dungeon = new Dungeon();
        this.player = player;
        this.scan = new Scanner(System.in);
    }

    public void runDungeonNavigator(){
        //Build a very random dungeon
        dungeon.buildRandomDungeon(player);

        //Prompt user for directions and interpret them
        System.out.println("Enter \"right\" to go right or \"left\" to go left");
        String choice = scan.next();
        if (choice.equals("right")) {
            dungeon.goRight();
        }
        else if (choice.equals("left")){
            dungeon.goLeft();
        }
    }
}
