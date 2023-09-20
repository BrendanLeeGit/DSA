package Pokemon;

import java.util.ArrayList;

/**
 * Singleton class for creating the attacks from the text file. Grab an instance of this class for getting attack info.
 * Static is used since it only needs to be created once, and creating it several times in different points is a waste
 * of resources.
 */
public class AttackCompilation {
    private ArrayList<Attack> attackList;
    private FileReader fileReader;
    private static AttackCompilation attackCompilation;

    /**
     * Initializes the class but does NOT read the files yet. Private since we only ever want one instance of this to
     * be created.
     */
    private AttackCompilation(){
        fileReader = new FileReader();
        attackList = new ArrayList<>();
    }

    /**
     * Returns an instance of AttackCompilation for use anywhere.
     * @return  an instance of AttackCompilation
     */
    public static AttackCompilation getAttackCompilation() {
        //If it's still null, create a new one. Otherwise, return existing one
        if (attackCompilation == null){
            attackCompilation = new AttackCompilation();
        }
        return attackCompilation;
    }

    /**
     * Compiles the information from the attack file
     */
    public void compileAttacks(){
        //Get information from the file reader
        fileReader.readFile();
        ArrayList<String[]> fileValues = fileReader.getValues();

        //start creating the attacks with the file contents :D
        for (String[] fileValue : fileValues) {
            attackList.add(new Attack(fileValue[0], Integer.parseInt(fileValue[1]),
                    fileValue[2]));
        }
    }

    public Attack getAttack(String attackName){
        for (int i = 0; i < attackList.size(); i++){
            if (attackList.get(i).getName().equals(attackName)){
                return attackList.get(i);
            }
        }
        //TODO: Throw exception for if name doesn't match :D
        System.out.println("Attack not found");
        System.out.println(attackName);

        return null;
    }

}
