package Pokemon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
    private File file;
    private Scanner scan;
    private ArrayList<String[]> values;

    public FileReader(){
        file = new File("Attacks.txt");
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void readFile(){
        int i = 0;
        while (scan.hasNextLine()){
            String lineContent = scan.nextLine();
            values.add(lineContent.split(" "));
        }
    }

    //TODO: way to reset arraylist

    public ArrayList<String[]> getValues(){
        return values;
    }
}
