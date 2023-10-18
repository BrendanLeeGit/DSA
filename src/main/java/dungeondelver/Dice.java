package dungeondelver;

import java.util.Random;

/**
 * My dice rolling class.
 */
public class Dice {
    private static final Random random = new Random();   //I want to keep things static but only want to make one random

    /**
     * Returns a result from rolling dice with the inputted amount of faces.
     * @param max   A poor simulated result of a dice roll
     * @return      The result of the dice roll
     */
    public static int rollDice(int max){
        return random.nextInt(max) + 1;
    }

    /**
     * Returns a result from rolling dice but with Strings! Like in DnD, use smt like "1d6" to roll 1 d6.
     * @param diceRepresentation   A poor simulated result of a dice roll
     */
    public static int rollDice(String diceRepresentation){
        int diceResult = 0;

        //Interpret the String as dice rolls and add it all up
        String[] split = diceRepresentation.split("d");
        for (int i = 0; i < Integer.parseInt(split[0]); i++){
            diceResult += rollDice(split[1]);
        }
        return diceResult;
    }
}
