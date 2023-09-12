package Pokemon;

/**
 * Initializes all the needed systems and gets them running
 */
public class PokemonBattleRunner {
    public void run() {
        //Read file and get attacks
        AttackCompilation attackCompilation = AttackCompilation.getAttackCompilation();
        attackCompilation.compileAttacks();

        //Create participants and add their attacks
        Rattata rat = new Rattata("Rattata", "Normal", 12, 2, 3);
        rat.addAttacks();
        Rattata rat2 = new Rattata("Rattata", "Normal", 12, 2, 3);
        rat2.addAttacks();

        //Set up and run battlefield
        BattleField battleField = new BattleField();
        battleField.addPokemon(rat);
        battleField.addPokemon(rat2);
        battleField.runCombat();
    }
}