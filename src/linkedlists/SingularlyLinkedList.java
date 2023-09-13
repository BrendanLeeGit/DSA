package linkedlists;

import java.util.Iterator;

/**
 * An implementation of a SingularlyLinkedList using generic types. It has its own built in Iterator and Node classes.
 * Features so far:
 *  - Tracks the size of the LinkedList
 *  - Can reverse itself
 * @param <E>   Whatever the LinkedList is supposed to be holding
 */
public class SingularlyLinkedList<E> {
    private Node head;
    private Node tail;
    private int size;

    /**
     * Constructs the LinkedList with one initial node.
     * @param value     The value you want the node to have
     */
    public SingularlyLinkedList(E value){
        head = new Node(value, null);
        tail = head;
        size = 1;
    }

    /**
     * Constructs a LinkedList with no initial nodes.
     */
    public SingularlyLinkedList(){
        //We make an empty node so the Iterator has something to point to
        head = new Node(null, null);
        tail = head;
        size = 0;
    }

    /**
     * Add element to the end of the linked list.
     * @param value     The element you want to add
     */
    public void addToEnd(E value){
        //If it's empty, need to adjust the initial node
        if (size == 0){
            head.data = value;
        }
        else{
            tail.next = new Node(value, null);
            tail = tail.next;
        }
        size++;
    }

    /**
     * Add element to the beginning of the linked list.
     * @param value     The element you want to add
     */
    public void addToBeginning(E value){
        //If it's empty, need to adjust the initial node
        if (size == 0){
            head.data = value;
        }
        else{
            head = new Node(value, head);
        }
        size++;
    }

    /**
     * Removes the node from the end of the LinkedList.
     */
    public void removeFromEnd(){
        //If size is 0, remove nothing
        if (size == 0){
            return;
        }

        //Get to second to last node and change its reference to null
        Node currentNode = head;
        while (currentNode.next.next != null){
            currentNode = currentNode.next;
        }
        tail = currentNode;
        tail.next = null;
        size--;
    }

    /**
     * Removes the node from the beginning of the LinkedList.
     */
    public void removeFromBeginning() {
        //If size is 0, remove nothing
        if (size == 0){
            return;
        }

        //Get rid of the head's link to the list and change the head to the second element
        Node headRef = head;
        head = head.next;

        //Remove the old head's reference to disconnect it from the list
        headRef.next = null;
        size--;
    }

    /**
     * Returns the size of the LinkedList.
     * @return  returns the size of the LinkedList
     */
    public int getSize(){
        return size;
    }

    /**
     * Returns a custom Iterator
     * @return
     */
    public LinkedListIterator getIterator(){
        return new LinkedListIterator();
    }

    /**
     * Reverse the linked list.
     */
    public void reverse(){
        Node currentNode = head;
        tail = head;
        while (currentNode.next != null) {
            //Create reference to next node
            Node nextNode = currentNode.next;
            //Set current node's reference to the next next node
            currentNode.next = nextNode.next;
            //Set the next node's reference to the head, and move the program along by setting the head to the next node
            nextNode.next = head;
            head = nextNode;
        }
    }

    /**
     * Private node class used for storing and linking the data in the LinkedList.
     */
    private class Node{
        E data;
        Node next;

        /**
         * Initializes the data and the reference to the next node.
         * @param data  The data you want the Node to have
         * @param next  The next Node that this Node will have a reference to
         */
        public Node(E data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    /**
     * Private Iterator class for, as you can imagine, iterating the LinkedList.
     */
    public class LinkedListIterator implements Iterator<E>{
        private Node currentNode;

        /**
         * Constructs the Iterator with an initial empty node that points to the head of the LinkedList.
         */
        private LinkedListIterator(){
            currentNode = new Node(null, head);
        }

        /**
         * Returns whether the LinkedList has another element after the current one or not.
         * @return  whether the LinkedList has another element after the current one or not
         */
        @Override
        public boolean hasNext() {
            return currentNode.next != null;
        }

        /**
         * Moves on to the next node and returns it.
         * @return  The data of the next Node
         */
        @Override
        public E next() {
            currentNode = currentNode.next;
            return currentNode.data;
        }

        /**
         * Moves the Iterator right back to the beginning of the LinkedList.
         */
        public void reset(){
            currentNode = new Node(null, head);
        }
    }
}
