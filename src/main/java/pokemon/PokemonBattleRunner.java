package pokemon;

/**
 * Initializes all the needed systems and gets them running
 */
public class PokemonBattleRunner {
    public void run() {
        //Read file and get attacks
        AttackCompilation attackCompilation = AttackCompilation.getAttackCompilation();
        attackCompilation.compileAttacks();

        //Create participants and add their attacks
        //Rattata rat = new Rattata("Rattata", "Normal", 12, 2, 2);
        Rattata rat = new Rattata();
        rat.addAttacks();
        //Onyx onyx = new Onyx("Onyx", "Normal", 20, 2, 4);
        Onyx onyx = new Onyx();
        onyx.addAttacks();

        //Level up Rattata bc he's hella outmatched
        for (int i = 0; i < 3; i++){
            rat.levelUp();
        }

        //Set up and run battlefield
        BattleField battleField = new BattleField();
        battleField.addPokemon(rat);
        battleField.addPokemon(onyx);
        battleField.runCombat();
    }
}