package SortingAlgorithms;

import java.util.ArrayList;

public class SortTest {
    int[][] valuesArray;
    ArrayList<Long> runTimes;
    Sorter sorter;

    public SortTest(int[][] valuesArray){
        this.valuesArray = valuesArray;
        runTimes = new ArrayList<>();
        sorter = new Sorter();
    }

    public SortTest(){
        sorter = new Sorter();

        //Hold the subArrays
        valuesArray = new int[20][];

        //Populate the bigArray with populated subArrays
        for (int i = 1; i < valuesArray.length + 1; i++){
            int[] subArray = sorter.generateRandomArrayOfIntegers(i * 10000, 3000);
            valuesArray[i - 1] = subArray;
        }
        runTimes = new ArrayList<>();
    }

    public void run() {

        long initialTime;
        for (int[] arr : valuesArray){
            initialTime = System.currentTimeMillis();
            sorter.bubbleSortAscending(arr);
            runTimes.add(initialTime - System.currentTimeMillis());
            System.out.println(initialTime - System.currentTimeMillis());
        }
        for (int i = 0; i < runTimes.size(); i++){
            System.out.println(runTimes.get(i));
        }
    }
}