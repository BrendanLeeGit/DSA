package Pokemon;

import java.util.ArrayList;

/**
 * The battleground for the Pokemon. Handles the actual battle systems and mechanics.
 */
public class BattleField {
    private ArrayList<Pokemon> participants;
    private ArrayList<Double> participantHp;
    private AttackCompilation attackCompilation;
    private int participantInt;

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
        double damageDealt = currentAttack.getDamage()/defender.getStat(2);

        //Adjust the defender's hp
        participantHp.set(participantIndexTwo, participantHp.get(participantIndexTwo) - damageDealt);

        //Announce HP
        System.out.println(defender.getName() + " has " + Math.ceil(participantHp.get(participantIndexTwo)) + " HP!\n");
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
        participantInt = 0;
        //Begin a loop as the Pokemon begin to hit each other with random abilities
        for(;;){
            attackProcess((participantInt % 2), (participantInt + 1) % 2);
            if (isThereWinner()){
                System.out.println(participants.get(participantInt % 2).getName() + " is the winner!");
                break;
            }
            participantInt++;
        }
    }
}
