package dungeondelver;

public class Testing {
    public static void main(String[] args){
        CreatureFactory creatureFactory = new CreatureFactory();
        Creature goblin = creatureFactory.getCreature("Goblin", 3);
        goblin.warCry();
        System.out.println(goblin.getAttack());
    }
}
