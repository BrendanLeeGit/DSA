package dungeondelver;

public class Testing {
    public static void main(String[] args){
        CreatureFactory creatureFactory = new CreatureFactory();
        Creature goblin = creatureFactory.getCreature("Goblin");
        goblin.warCry();
    }
}
