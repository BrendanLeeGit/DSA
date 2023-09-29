package linkedlists;

/**
 * Linked list made in DSA.
 * @param <E>
 */
public class DSALinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    /**
     * Constructs a linked list with size 0.
     */
    public DSALinkedList(){
        size = 0;
    }

    /**
     * Adds a new node to the end of the list with the inputted data.
     * @param data  The data the new node will contain
     */
    public void add(E data){
        //If the list is empty, initialize first node with the wanted data
        if (size == 0){
            head = new Node<>(data);
            tail = head;
        }
        else{
            //Otherwise, just add a new node to the tail and update the tail reference
            Node<E> newNode = new Node<>(data);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**
     * Add an element to the node at a specific position. Does not create a new node.
     * @param data      The data to be added to the Node
     * @param position  The position of the node where the data is added
     */
    public void add(E data, int position){
        Node<E> tempRef = head;

        //Iterate through the list till the desired position and set the data
        for (int i = 0; i < position; i++){
            tempRef = tempRef.next;
        }
        tempRef.data = data;
    }

    /**
     * Removes a node from the inputted position in the LinkedList.
     * @param position
     */
    public void remove(int position){
        //If the node to be removed is the head, then well we got this.
        if (position == 0){
            head = head.next;
            size--;
        }
        //If the position is in the first half of the list, iterate from front, else iterate from the back
        else{
            if (position < size/2){
                //Iterate to position right before the intended node
                Node<E> nodeRef = head;
                for (int i = 0 ; i < position - 1; i++){
                    nodeRef = nodeRef.next;
                }

                //Remove it by setting new next
                nodeRef.next = nodeRef.next.next;
            }
            else {
                //Iterate backwards from the tail :D
                Node<E> nodeRef = tail;
                for (int i = size; i > position; i--){

                }
            }
        }
    }

    /**
     * Removes a node from the end of the list.
     */
    public void removeFromEnd(){
        //TODO: Finish this function bruh
    }

    /**
     * Return the data located at the indicated position in the LinkedList.
     * @param pos   The location of the Node to get data from
     * @return      Returns the data from the inputted Node
     */
    public E get(int pos){
        //Cycle to specified node position and return its data
        Node<E> nodeRef = head;
        for (int i = 0; i < pos; i++){
            nodeRef = nodeRef.next;
        }
        return nodeRef.data;
    }

    /**
     * Print out the entire set of the LinkedList's values.
     */
    public void printList(){
        Node<E> localRef = head;
        while (localRef != null){
            System.out.println(localRef.data);
            localRef = localRef.next;
        }
    }

    /**
     * Node implementation
     * @param <V>
     */
    private class Node<V> {
        private V data;
        private Node<V> next;
        private Node<V> prev;

        public Node(V data){
            this.data = data;
            next = null;
        }

        public Node(V data, Node<V> next){
            this.data = data;
            this.next = next;
        }
    }
}
