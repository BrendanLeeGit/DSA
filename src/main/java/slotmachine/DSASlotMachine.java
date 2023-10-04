package slotmachine;

import java.util.Random;

/**
 * Slot machine used to implement the iterable interface.
 */
public class DSASlotMachine implements MyIterable<Integer>{
    private int coins;
    private int gamesPlayed;
    private final Random rand;

    /**
     * Constructs the slot machine with an initial 1000 coins and 0 games played.
     */
    public DSASlotMachine(){
        coins = 1000;
        gamesPlayed = 0;
        rand = new Random();
    }

    /**
     * Runs the machine until failure.
     */
    public void playMachine(){
        while (hasNext()) {
            next();
            gamesPlayed++;
        }
        failWords();
    }

    /**
     * Displays end message with the final results.
     */
    public void failWords(){
        System.out.println("You failed miserably!");
        System.out.println("Games played: " + gamesPlayed);
    }

    /**
     * Has about a 40% chance to break even and 60% chance to lose one coin each spin.
     * @return  The number of coins remaining
     */
    @Override
    public Integer next() {
        //Consume one coin
        coins--;

        //Random chance to gain one coin
        if (rand.nextInt(100) > 60){
            coins++;
        }
        return coins;
    }

    /**
     * Returns if there are coins remaining.
     * @return  True if there are coins left
     */
    @Override
    public boolean hasNext() {
        return (coins > 0);
    }
}
