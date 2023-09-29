package arraylist;

/**
 * Custom Array List :D
 * @param <E>   The type of value it'll hold ezpz
 */
public class DSAArrayList<E>{
    private Object[] originArray;
    private int size;

    /**
     * Construct Array List with a default capacity of 10.
     */
    public DSAArrayList(){
        originArray = new Object[10];
    }

    /**
     * Construct an Array List with an inputted and customized size.
     * @param capacity The initial capacity the created Array List will have
     */
    public DSAArrayList(int capacity){
        originArray = new Object[capacity];
    }

    /**
     * Adds the inputted data into the Array List.
     * @param data  The data to be added to the list
     */
    public void add(E data){
        //If the list is full, extend the capacity
        if (size == originArray.length){
            extendArray();
        }
        originArray[size++] = data;
    }

    /**
     * Add an element to a specific index in the ArrayList.
     * @param index Where the data will be stored in the ArrayList
     * @param data  The data that will be stored
     */
    public void add(int index, E data){
        //Check size and extend if needed
        if (size == originArray.length){
            extendArray();
        }
        //Move all the elements starting at specified index to the right
        for (int i = size; i > index; i--){
            originArray[i] = originArray[i - 1];
        }
        //Set intended index to inputted data
        originArray[index] = data;
        size++;
    }

    /**
     * Clears the ArrayList of data, though it doesn't change the capacity.
     */
    public void clear(){
        //Set all values to null and set size to 0
        for (int i = 0; i < size; i++){
            originArray[i] = null;
        }
        size = 0;
    }

    /**
     * Return an array that contains all the filled values in the origin array.
     * @return  The clone of the origin array with all its filled values
     */
    public Object[] deepClone(){
        //Instantiate new array with current size
        Object[] newArray = new Object[size];

        //Fill the new array with the old arrays values and return it
        System.arraycopy(originArray, 0, newArray, 0, size);
        return newArray;
    }

    /**
     * Returns true if ArrayList contains the inputted value and false if not.
     * @param data  The data being checked for in the ArrayList
     * @return  Whether the ArrayList contains the data
     */
    public boolean contains(E data){
        for (int i = 0; i < size; i++){
            if (data.equals(originArray[i])){
                return true;
            }
        }
        return false;
    }

    /**
     * Removes any instances of the inputted data in the ArrayList.
     * @param data  The data you would like removed from the ArrayList
     */
    public void removeElement(E data){
        //Check list for data, and if it's there then remove data at that index
        for (int i = 0; i < size; i++){
            if (data.equals(originArray[i])){
                remove(i);
            }
        }
        //Do NOT remove since the remove method already removes a size
    }

    /**
     * Removes the last element in the ArrayList.
     */
    public void removeLast(){
        originArray[size--] = null;
    }

    /**
     * Remove an element at the specified index from the Array List.
     * @param index The index of the element specified for removal
     */
    public void remove(int index){
        //Move all the elements on the right of the index to the left
        for (int i = index; i < size - 1; i++){
            originArray[i] = originArray[i + 1];
        }
        size--;
    }

    /**
     * Doubles the capacity of the built-in array.
     */
    private void extendArray(){
        //Create a new array with the double the size and fill it with the original array's values
        Object[] newArray = new Object[originArray.length*2];
        if (size >= 0) System.arraycopy(originArray, 0, newArray, 0, size);

        //Set the old array to the new array and adjust capacity global variable
        originArray = newArray;
    }

    /**
     * Returns size of the Array List, aka how many elements are currently inside of it.
     * @return  The current number of items in the Array List
     */
    public int getSize(){
        return size;
    }

    /**
     * Returns the value at the specified index.
     * @param index The index of the value that's being returned
     * @return  The value at the specified index
     */
    public Object get(int index){
        return originArray[index];
    }

    /**
     * Print the contents of the ArrayList.
     */
    public void printAll(){
        for (int i = 0; i < size; i++){
            System.out.println(i + ": " + originArray[i].toString());
        }
    }
}
