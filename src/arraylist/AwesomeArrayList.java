package arraylist;

/**
 * My own implementation of an ArrayList with as little guidance as possible. Oh boi.
 * @param <E> Random element idk
 */
public class AwesomeArrayList<E> {
    private Object[] array;
    private int size;           //The current # of elements in the ArrayList
    private int capacity;       //Maximum capacity of the current ArrayList

    /**
     * Constructs the ArrayList with an inputted capacity.
     * @param capacity  The initial capacity of the ArrayList
     */
    public AwesomeArrayList(int capacity){
        this.capacity = capacity;
        size = 0;
        array = new Object[capacity];
    }

    /**
     * Constructs the ArrayList with a default capacity of 50.
     */
    public AwesomeArrayList(){
        capacity = 50;
        size = 0;
        array = new Object[capacity];
    }

    /**
     * Adds an element to the ArrayList.
     * @param element   The element to be added to the ArrayList.
     */
    public void add(E element){
        //If we're out of room, double the array capacity
        if (size == capacity){
            reArraynge();
        }
        array[size++] = element;
    }

    /**
     * Set's the inputted index in the ArrayList to the inputted element.
     * @param index     The index of the ArrayList where the element will be placed
     * @param element   The element that will be placed in the specified index
     */
    public void set(int index, E element){
        array[index] = element;
    }

    /**
     * Creates a new array with double the capacity and copies the old array's contents to the new one. The new one
     * replaces the old one of course. Also this method name is beautiful.
     */
    private void reArraynge(){
        //Create a new array and copy over all the data
        Object[] newArray = new Object[capacity*2];
        System.arraycopy(array, 0, newArray, 0, array.length);

        //Replace the old array with the new one
        array = newArray;
    }
}
