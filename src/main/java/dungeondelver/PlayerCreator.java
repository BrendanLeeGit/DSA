package dungeondelver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PlayerCreator {
    private Scanner scan;

    //This directory won't ever change and needs to be accessed when the player dies
    public static final File directory = new File("src/main/java/dungeondelver/characters");

    public PlayerCreator(){
        scan = new Scanner(System.in);
    }

    public Player createPlayer(){
        //Prompt user for character name to make a new character or continue an already existing one
        System.out.println("Hello! Welcome. Enter in the name of your Character. If there's a file\n" +
                "for them already, that will be used. If not, we'll generate a new character.");
        String name = scan.next();
        File file = new File(directory, name + ".txt");
        if (file.exists()) {
            System.out.println("Character file found! Loading character...");
            String[] playerInfo = readFile(file);
            return new Player(playerInfo[0], Integer.parseInt(playerInfo[1]), Integer.parseInt(playerInfo[2]),
                    Integer.parseInt(playerInfo[3]), Integer.parseInt(playerInfo[4]), Integer.parseInt(playerInfo[5]),
                    Integer.parseInt(playerInfo[6]));
        }
        else {
            return new Player(name);
        }
    }

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
