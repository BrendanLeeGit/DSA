package arraylist;

public class ArrayListTest {
    public void runTest(){
        //Create arraylist
        OtherArrayList<Integer> oAL = new OtherArrayList<>();
        for (int i = 0; i < 98; i++){
            oAL.add(i);
        }

        //Test removal and adds
        System.out.println("Remove second index");
        oAL.remove(1);
        oAL.add(1, 429);
        oAL.removeElement(3);
        oAL.removeLast();
        System.out.println("Remaining Size: " + oAL.getSize());

        //Print out changed array
        oAL.printAll();

        //Test deep clone
        System.out.println("Clone time :D");
        Object[] cloneTestArray = oAL.deepClone();
        for (Object o : cloneTestArray) {
            System.out.println(o);
        }

        //Test contains
        System.out.println("Contains 99?: " + oAL.contains(99));

        //Clear test
        oAL.clear();

        //Print elements again :D
        System.out.println("The cleared array contents:");
        oAL.printAll();
    }
}
