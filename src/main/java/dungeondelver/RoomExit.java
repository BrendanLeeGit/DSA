package dungeondelver;

public class RoomExit extends DungeonRoom {

    RoomExit() {
        super("Exit", 40);
    }

    @Override
    public void runDungeon(PlayerContainer playerContainer){
        System.out.println("You have reached the exit room! Congratulations!");
        System.out.println("You will now move on to the next dungeon floor and receive 40 gold.");
        playerContainer.modifyMoney(40);
        playerContainer.getPlayer().setIsAtExit(true);
    }

    @Override
    public String toString(){
        return "an exit";
    }
}
