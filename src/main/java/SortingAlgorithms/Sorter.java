package SortingAlgorithms;

import java.util.Random;

public class Sorter {

    public Sorter(){

    }

    /**
     * Inefficient bubble sort that sorts through an integer array by swapping neighboring indices.
     * @param arrayToSort
     * @return
     */
    public int[] bubbleSortDesc(int[] arrayToSort){
        //int counter = 0;

        //Swapped will track if the array did any swaps
        boolean swapped = true;
        while (swapped){
            swapped = false;
            for (int i = 0; i < arrayToSort.length - 1; i++){
                if (arrayToSort[i] < arrayToSort[i + 1]){

                    //Swap values
                    int temp = arrayToSort[i];
                    arrayToSort[i] = arrayToSort[i + 1];
                    arrayToSort[i + 1] = temp;
                    swapped = true;
                }
                //counter++;
            }
        }
        //System.out.println(counter);
        return arrayToSort;
    }

    /**
     * Inefficient bubble sort that sorts through an integer array by swapping neighboring indices.
     * @param arrayToSort
     * @return
     */
    public int[] bubbleSortAscending(int[] arrayToSort){
        //int counter = 0;
        //Swapped will track if the array did any swaps
        boolean swapped = true;
        while (swapped){
            swapped = false;
            for (int i = 0; i < arrayToSort.length - 1; i++){
                if (arrayToSort[i] > arrayToSort[i + 1]){
                    int temp = arrayToSort[i];
                    arrayToSort[i] = arrayToSort[i + 1];
                    arrayToSort[i + 1] = temp;
                    swapped = true;
                }
                //counter++;
            }
        }
        //System.out.println(counter);
        return arrayToSort;
    }

    /**
     * Generates and returns an array of integers from java.util.Random.
     * @param sizeOfArray       The size of the generated array
     * @param boundOfIntegers   The bound for the randomly generated integers
     * @return                  The generates array of randomly generated integers
     */
    public int[] generateRandomArrayOfIntegers(int sizeOfArray, int boundOfIntegers){
        //Use Random to create an array of random integers
        Random rand = new Random();
        int[] generatedArray = new int[sizeOfArray];
        for (int i = 0; i < sizeOfArray; i++){
            generatedArray[i] = rand.nextInt(boundOfIntegers);
        }
        return generatedArray;
    }
}
