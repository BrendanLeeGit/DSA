package queue;

import linkedlists.DSALinkedList;

public class Queue <E>{
    DSALinkedList<E> linkedList;

    public Queue(){
        linkedList = new DSALinkedList<>();
    }

    public void offer(E data){
        linkedList.add(data);
    }

    public E poll(){
        return linkedList.removeFromBeginning();
    }

    public E peek(){
        return linkedList.getHeadData();
    }

    public void printQueue(){
        System.out.println("/---Queue---\\");
        linkedList.printList();
        System.out.println("\\-----------/");
    }
}
