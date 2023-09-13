package linkedlists;

/**
 * Just a test class to see if my implementation of the LinkedList works properly
 */
public class LinkedListTest {
    public static void main(String[] args){
        SingularlyLinkedList<Integer> singularlyLinkedList = new SingularlyLinkedList<>();
        for (int i = 0; i < 30; i++){
            singularlyLinkedList.addToEnd(i);
        }

        singularlyLinkedList.removeFromBeginning();
        singularlyLinkedList.removeFromEnd();

        singularlyLinkedList.reverse();

        SingularlyLinkedList<Integer>.LinkedListIterator linkedListIterator = singularlyLinkedList.getIterator();
        while (linkedListIterator.hasNext()){
            System.out.println(linkedListIterator.next());
        }

        //Time to test the doubly linked list
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        for (int i = 0; i < 30; i++){
            doublyLinkedList.addToEnd(i);
        }
        DoublyLinkedList<Integer>.LinkedListIterator linkedListIterator2 = doublyLinkedList.getIterator();
        while (linkedListIterator2.hasNext()){
            System.out.println(linkedListIterator2.next());
        }

        System.out.println("Test");
        doublyLinkedList.removeFromBeginning();
        doublyLinkedList.removeFromEnd();
        while (linkedListIterator2.hasPrev()) {
            System.out.println(linkedListIterator2.prev());
        }

    }
}
