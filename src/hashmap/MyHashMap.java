package hashmap;

/**
 * My implementation of a HashMap.
 * @param <E>
 */
public class MyHashMap<O, E> {
    //Keep track of both the objects and the keys, will keep the keys in a separate array
    private Object[] keys;
    private Object[] hashMapArray;
    private double loadFactor;
    private int arraySize;
    private int currentSize;
    private int keyIncrement;

    /**
     * Default constructor that makes an initial array of size 100 and a load factor of 0.75.
     */
    public MyHashMap(){
        arraySize = 100;
        hashMapArray = new Object[arraySize];
        keys = new Object[arraySize];
        loadFactor = 0.75;
        currentSize = 0;
        keyIncrement = 0;
    }

    /**
     * Constructor for a more custom HashMap with an inputted capacity and load factor.
     * @param arraySize  The initial size of the array
     * @param loadFactor The load factor of the HashMap
     */
    public MyHashMap(int arraySize, double loadFactor){
        this.arraySize = arraySize;
        hashMapArray = new Object[arraySize];
        this.loadFactor = loadFactor;
        currentSize = 0;
        keyIncrement = 0;
    }

    /**
     * Enter an element into the HashMap.
     * @param element   The element you want to add to the HashMap
     */
    public void set(O key, E element){
        int hashCode = key.hashCode() % arraySize;
        hashMapArray[hashCode] = element;
        keys[keyIncrement++] = key;
        currentSize++;

        //If the ratio from current size to array size is above the load factor, start up the rehash
        if ((double) currentSize / arraySize >= loadFactor){
            rehash();
        }
    }

    /**
     * Get a element back from the HashMap using its key.
     * @param key   The key of the element you want returned
     * @return      The key's corresponding element
     */
    public Object get(O key){
        return hashMapArray[key.hashCode() % arraySize];
    }

    /**
     * Replaces the array with a new one with double the capacity, rehashing all of its contents.
     */
    private void rehash(){
        //Make new array twice as large as the original
        int prevArraySize = arraySize;
        arraySize *= 2;
        Object[] newHashArray = new Object[arraySize];

        //Rehash each value and add them to the array
        for (int i = 0; i < keyIncrement; i++){
            newHashArray[keys[i].hashCode() % arraySize] = hashMapArray[keys[i].hashCode() % prevArraySize];
        }
        hashMapArray = newHashArray;

        //then extend keys too
        Object[] newKeys = new Object[arraySize];
        System.arraycopy(keys, 0, newKeys, 0, keys.length);
        keys = newKeys;
    }

    /**
     * Returns the entire set of keys in the order that they were placed in.
     * @return  The entire set of keys in the order that they were placed in
     */
    public Object[] getKeySet(){
        return keys;
    }
}
