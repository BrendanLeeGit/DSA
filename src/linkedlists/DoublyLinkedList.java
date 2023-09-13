package linkedlists;

import java.util.Iterator;

/**
 * An implementation of a DoublyLinkedList using generic types. It has its own built in Iterator and Node classes.
 * Features so far:
 *  - Tracks the size of the LinkedList
 *  - Can reverse itself
 * @param <E>   Whatever the LinkedList is supposed to be holding
 */
public class DoublyLinkedList<E> {
    private Node head;
    private Node tail;
    private int size;

    /**
     * Constructs the LinkedList with one initial node.
     * @param value     The value you want the node to have
     */
    public DoublyLinkedList(E value){
        head = new Node(value, null, null);
        tail = head;
        size = 1;
    }

    /**
     * Constructs a LinkedList with no initial nodes.
     */
    public DoublyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Add element to the end of the linked list.
     * @param value     The element you want to add
     */
    public void addToEnd(E value){

        //If it's empty, need to construct an initial node
        if (size == 0){
            head = new Node(value, null, null);
            tail = head;
        }
        else{
            tail.next = new Node(value, null, tail);
            tail = tail.next;
        }
        size++;
    }

    /**
     * Add element to the beginning of the linked list.
     * @param value     The element you want to add
     */
    public void addToBeginning(E value){

        //If it's empty, need to construct an initial node
        if (size == 0){
            head = new Node(value, null, null);
            tail = head;
        }
        else{
            head = new Node(value, head, null);
        }
        size++;
    }

    /**
     * Removes the node from the end of the LinkedList.
     */
    public void removeFromEnd(){
        //Get to second to last node and change its reference to null
        Node secondToLast = tail.prev;
        secondToLast.next = null;
        tail = secondToLast;
    }

    /**
     * Removes the node from the beginning of the LinkedList.
     */
    public void removeFromBeginning(){
        //Get rid of the head's link to the list and change the head to the second element
        head = head.next;
        head.next = null;
        head.prev = null;
    }

    /**
     * Returns the size of the LinkedList.
     * @return  returns the size of the LinkedList
     */
    public int getSize(){
        return size;
    }

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
        Node prev;

        /**
         * Initializes the data and the reference to the next node.
         * @param data  The data you want the Node to have
         * @param next  The next Node that this Node will have a reference to
         */
        public Node(E data, Node next, Node prev){
            this.data = data;
            this.next = next;
            this.prev = prev;
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
            currentNode = new Node(null, head, null);
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
         * Returns whether the LinkedList has another element before the current one or not.
         * @return  whether the LinkedList has another element before the current one or not
         */
        public boolean hasPrev(){
            return currentNode.prev != null;
        }

        /**
         * Moves on to the next node and returns it.
         * @return  The next Node in the Linked List
         */
        @Override
        public E next() {
            currentNode = currentNode.next;
            return currentNode.data;
        }

        /**
         * Moves back to the previous node and returns it.
         * @return  The next Node in the Linked List
         */
        public E prev(){
            currentNode = currentNode.prev;
            return currentNode.data;
        }

        /**
         * Moves the Iterator right back to the beginning of the LinkedList.
         */
        public void reset(){
            currentNode = new Node(null, head, null);
        }
    }
}
