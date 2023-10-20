package dungeondelver;

public class RoomExit extends DungeonRoom {

    RoomExit() {
        super("Exit", 20);
    }

    @Override
    public void runDungeon(PlayerContainer playerContainer){
        System.out.println("You have reached the exit room! Congratulations!");
        System.out.println("You will now move on to the next dungeon floor.");
        playerContainer.getPlayer().setIsAtExit(true);
    }
}
