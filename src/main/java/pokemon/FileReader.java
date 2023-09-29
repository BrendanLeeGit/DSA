package pokemon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
    private File file;
    private Scanner scan;
    private ArrayList<String[]> values;

    public FileReader(){
        values = new ArrayList<>();
    }

    /**
     * Reads through the file and builds the values ArrayList with its contents.
     */
    public void readFile(){
        //Almost like a mini constructor here since we need file name before we initialize variables
        file = new File("C:\\Users\\brend\\IdeaProjects\\DSAProject\\src\\Pokemon\\Attacks.txt");
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        //Split the contents of the file and record them in values
        int i = 0;
        while (scan.hasNextLine()){
            String lineContent = scan.nextLine();
            values.add(lineContent.split(","));
        }
    }

    //TODO: way to reset arraylist in order to update attacks at runtime or read different files

    public ArrayList<String[]> getValues(){
        return values;
    }
}
