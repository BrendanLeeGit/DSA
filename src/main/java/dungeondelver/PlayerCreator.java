package dungeondelver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Handles Player creation, as well as the importing of already created characters. This class utilizes
 * text files from src/main/java/dungeondelver/characters.
 */
public class PlayerCreator {
    private Scanner scan;

    //This directory won't ever change and needs to be accessed when the player dies
    public static final File directory = new File("src/main/java/dungeondelver/characters");

    public PlayerCreator(){
        scan = new Scanner(System.in);
    }

    /**
     * Used to create the entity the user will play as for the entire game. The entity can be entirely new, or
     * taken from the saved text files.
     * @return  The generated entity.
     */
    public Player createPlayer(){
        //Prompt user for character name to make a new character or continue an already existing one
        System.out.println("Hello! Welcome. Enter in the name of your Character. If there's a file\n" +
                "for them already, that will be used. If not, we'll generate a new character.");
        System.out.println("Note, your character name must have no spaces whatsoever.");
        String name = scan.nextLine();
        File file = new File(directory, name + ".txt");
        if (file.exists()) {
            System.out.println("Character file found! Loading character...");
            String[] playerInfo = readFile(file);
            return new Player(playerInfo[0], Integer.parseInt(playerInfo[1]), Integer.parseInt(playerInfo[2]),
                    Integer.parseInt(playerInfo[3]), Integer.parseInt(playerInfo[4]), 0,
                    Integer.parseInt(playerInfo[6]));
        }
        else {
            return new Player(name);
        }
    }

    /**
     * Reads a .txt file and returns its contents in a String[].
     * @param file  The File that will be read from
     * @return      The resulting String[] of the file contents
     */
    private String[] readFile(File file){
        //Make a Scanner to parse the file
        Scanner scanFile;
        try {
            scanFile = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        //Build a String[] from the file's contents
        String[] info = new String[7];
        for (int i = 0; i < 7; i++){
            info[i] = scanFile.next();
        }
        return info;
    }

    /**
     * This method takes a Player and generates a .txt file with all of its information. This file can be later
     * loaded so the user can continue their progress another time. This is static so that it can be used anywhere in
     * the program. Additionally, the generated file is placed in src/main/java/dungeondelver/characters.
     * @param player    The Player whose information the resulting text file will contain.
     */
    public static void createPlayerFile(Player player){
        //Create a new file for the character or replace an old one
        try {
            File file = new File(directory, player.getName() + ".txt");
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(player.getName() + " " + player.getMaxHealth() + " " + player.getAttack() + " " +
                    player.getDefense() + " " + player.getSpeed() + " " + player.getMoney() + " " + player.getLevel());
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
