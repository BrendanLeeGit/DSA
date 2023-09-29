package linkedlists;

public class DSALinkedListRun {

    public static void main(String[] args){
        DSALinkedList<Integer> linkedList = new DSALinkedList<>();
        for (int i = 0; i < 10; i++){
            linkedList.add(i);
        }
        linkedList.remove(2);
        linkedList.printList();
    }


}
