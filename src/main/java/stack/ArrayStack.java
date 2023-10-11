package stack;

/**
 * Implementation of a stack using an internal array.
 * @param <E>
 */
public class ArrayStack <E> {
    private Object[] innerArray;
    private int currentIndex;

    /**
     * Constructs the stack with an initial capacity of 30.
     */
    public ArrayStack(){
        innerArray = new Object[30];
        currentIndex = -1;                      //Note, if you want the ACTUAL size then add 1 to current index :D
    }

    /**
     * Places an inputted element onto the end of the stack, AKA push :D.
     * @param data  The element to be pushed on the stack.
     */
    public void push(E data){
        if (currentIndex == innerArray.length - 1){
            extendArray();
        }
        currentIndex++;
        innerArray[currentIndex] = data;
    }

    /**
     * Pops the top element, returning it and removing it from the stack.
     * @return  The popped element
     */
    public Object pop(){
        return innerArray[currentIndex--];
    }

    public Object peek(){
        return innerArray[currentIndex];
    }

    public void empty(){
        currentIndex = -1;
    }

    /**
     * This method uses array indices.
     * @param data  The item you want the index of
     * @return  The index of the item
     */
    public int search(E data){
        for (int i = 0; i < innerArray.length; i++){
            if (innerArray[i].equals(data)){
                return i;
            }
        }
        //If it doesn't exist in the array, return -1
        return -1;
    }

    /**
     * Searches with the use of pops and pushes.
     * @param data
     * @return
     */
    public int searchWeird(E data){
        int indexFound = -1;
        int originalSize = size();
        ArrayStack<E> arrayStack = new ArrayStack<>();
        for (int i = 0; i < originalSize; i++){
            Object poppedValue = pop();
            arrayStack.push((E)poppedValue);

            if (poppedValue.equals(data)){
                indexFound = originalSize - i;
                break;
            }
        }

        int otherArrayOriginalSize = arrayStack.size();
        for (int i = 0; i < otherArrayOriginalSize; i++){
            push((E)arrayStack.pop());
        }
        return indexFound;
    }

    public ArrayStack<E> cloneArrayStack(){
        ArrayStack<E> clonedArrayStack = new ArrayStack<>();
        for (Object o : innerArray){
            clonedArrayStack.push((E)o);
        }
        return clonedArrayStack;
    }

    public void printStack(){
        for (int i = 0; i < currentIndex + 1; i++){
            System.out.println(innerArray[i]);
        }
    }

    public int size(){
        return currentIndex + 1;
    }

    /**
     * Doubles the capacity of the built-in array.
     */
    private void extendArray(){
        //Create a new array with the double the size and fill it with the original array's values
        Object[] newArray = new Object[innerArray.length*2];
        if (currentIndex >= 0) System.arraycopy(innerArray, 0, newArray, 0, currentIndex);

        //Set the old array to the new array and adjust capacity global variable
        innerArray = newArray;
    }
}
