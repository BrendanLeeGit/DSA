package Pokemon;

import java.util.ArrayList;

/**
 * The battleground for the Pokemon
 */
public class BattleField {
    private ArrayList<Pokemon> participants;
    private ArrayList<Double> participantHp;
    private AttackCompilation attackCompilation;

    public BattleField(){
        participants = new ArrayList<>();
        participantHp = new ArrayList<>();
        attackCompilation = AttackCompilation.getAttackCompilation();
    }

    public void addPokemon(Pokemon pokemon){
        participants.add(pokemon);
        participantHp.add(pokemon.getStat(0));
    }

    private void attackProcess(int participantIndex, int participantIndexTwo){
        //Assign attacker and defender
        Pokemon attacker = participants.get(participantIndex);
        Pokemon defender = participants.get(participantIndexTwo);

        //Pick an attack
        Attack currentAttack = attackCompilation.getAttack(attacker.chooseRandomAttack());

        //Announce with print lines:
        System.out.println(attacker.getName() + " uses " + currentAttack.getName() + "!");

        //Compute damage and change health accordingly
        //Damage calculation shall be as follows:
        //  originalAttackDamage * attackerAttackDmg / defenderDefense
        double damageDealt = currentAttack.getDamage();

        //Adjust the defender's hp
        participantHp.set(participantIndexTwo, participantHp.get(participantIndexTwo) - damageDealt);
    }

    private boolean isThereWinner(){
        for (int i = 0; i < participantHp.size(); i++){
            if (participantHp.get(i) <= 0){
                return true;
            }
        }
        return false;
    }

    /**
     * This is only for two person combat for now
     */
    public void runCombat(){
        int i = 0;
        //Begin a loop as the Pokemon begin to hit each other with random abilities
        for(;;){
            attackProcess((i % 2), (i + 1) % 2);
            i++;

            if (isThereWinner()){
                System.out.println("There is a winner!");
                break;
            }
        }
    }
}
