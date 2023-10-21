package dungeondelver;


import slotmachine.MyIterable;

/**
 * Linked list made in DSA.
 * @param <E>
 */
public class DSACircularLinkedList<E> {
    private Node<E> head;
    private int size;

    /**
     * Constructs a linked list with size 0.
     */
    public DSACircularLinkedList(){
        size = 0;
    }

    /**
     * Clears the Linked List with the garbage collector and sets the size back to 0.
     */
    public void clear(){
        size = 0;
        head = null;
    }

    public MyIterator getIterator(){
        return new MyIterator();
    }

    /**
     * Returns the size of the LinkedList.
     * @return  The size of the LinkedList
     */
    public int getSize(){
        return size;
    }

    /**
     * Adds a new node to the end of the list with the inputted data.
     * @param data  The data the new node will contain
     */
    public void add(E data){
        //If the list is empty, initialize first node with the wanted data
        if (size == 0){
            head = new Node<>(data);
            head.prev = head;
            head.next = head;
        }

        //If there's only one node, then need to make sure the head node is set to it
        else if (size == 1){
            Node<E> newNode = new Node<>(data, head, head);
            head.next = newNode;
            head.prev = newNode;
        }
        else{
            //Keep reference to the prev of the head
            Node<E> tempHeadPrev = head.prev;

            //Set the tempHeadPrev's next to the new node, and configure the new node's next and prev
            tempHeadPrev.next = new Node<>(data, head, tempHeadPrev);

            //Set head's prev to the new node
            head.prev = tempHeadPrev.next;
        }
        size++;
    }

    /**
     * Add an element to the node at a specific position. Does not create a new node.
     * @param data      The data to be added to the Node
     * @param position  The position of the node where the data is added
     */
    public void setData(E data, int position){
        //TODO: Make more efficient by iterating backwards if the position is > half the size
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
        Node<E> nodeRef;
        //If the node to be removed is the head, then well we got this.
        if (position == 0){
            nodeRef = head.prev;
            nodeRef.next = head.next;
            head = nodeRef;
        }
        //If the position is in the first half of the list, iterate from front, else iterate from the back
        else{
            if (position < size/2){
                //Iterate to the intended node
                nodeRef = head;
                for (int i = 0 ; i < position; i++){
                    nodeRef = nodeRef.next;
                }
                //Set the previous node and next node's next and prev
                removeNode(nodeRef);
            }
            else {
                //Iterate backwards from the head :D
                nodeRef = head;
                for (int i = size; i > size - position; i--){
                    nodeRef = nodeRef.prev;
                }
                //Set the previous node and next node's next and prev
                removeNode(nodeRef);
            }
        }
    }

    /**
     * Removes a node in the circular list.
     * @param nodeRef   The node to be removed
     */
    private void removeNode(Node<E> nodeRef){
        Node<E> tempPrev = nodeRef.prev;
        Node<E> tempNext = nodeRef.next;
        tempPrev.next = tempNext;
        tempNext.prev = tempPrev;
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
        }

        public Node(V data, Node<V> next, Node<V> prev){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * Personal iterator for the linked list
     */
    public class MyIterator implements MyIterable<E> {
        private Node<E> currentNode;

        private MyIterator(){
            currentNode = new Node<>(null, head, head.prev);
        }

        @Override
        public E next() {
            currentNode = currentNode.next;
            return currentNode.data;
        }

        public E previous() {
            currentNode = currentNode.prev;
            return currentNode.data;
        }

        @Override
        public boolean hasNext() {
            return (currentNode.next != null);
        }

        public E getCurrentData(){
            return currentNode.data;
        }

        /**
         * Removes the current node and moves to the next Node.
         */
        public void removeCurrentNodeGoToRight(){
            Node<E> currentTemp = currentNode;
            next();
            removeNode(currentTemp);
        }

        /**
         * Removes the current node and moves to the previous Node.
         */
        public void removeCurrentNodeGoToLeft(){
            Node<E> currentTemp = currentNode;
            previous();
            removeNode(currentTemp);
        }

        /**
         * Returns  the String form of the data of the Node to the right of the current Node.
         * @return  the String form of the data of the Node to the right of the current Node
         */
        public String peakRight(){
            return currentNode.next.data.toString();
        }

        /**
         * Returns  the String form of the data of the Node to the left of the current Node.
         * @return  the String form of the data of the Node to the left of the current Node
         */
        public String peakLeft(){
            return currentNode.prev.data.toString();
        }
    }
}
