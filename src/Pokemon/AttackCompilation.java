package Pokemon;

import java.util.ArrayList;

public class AttackCompilation {
    private ArrayList<Attack> attackList;
    private FileReader fileReader;

    public AttackCompilation(){
        fileReader = new FileReader();
        attackList = new ArrayList<Attack>();
    }

    public void compileAttacks(){
        //Get information from the file reader
        fileReader.readFile();
        ArrayList<String[]> fileValues = fileReader.getValues();

        //start creating the attacks :D
        for (int i = 0; i < fileValues.size(); i++){
            attackList.add(new Attack(//put in the index of the string of stuff like ,get(i)[0) or smt])));
        }
    }
}
