package linkedlists;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class SingularlyLinkedListTest {
    SingularlyLinkedList<String> sll = new SingularlyLinkedList<>();

    @Test
    public void givenEmptyLinkedList_whenRemoveFromBeginning_thenNullError(){

    }

    @Test
    public void givenEmptyLinkedList_whenAddToBeginning_thenSuccessfulAdd(){
        SingularlyLinkedList<String>.LinkedListIterator lli = sll.getIterator();
        sll.addToBeginning("Hello");

        String actualString = lli.next();
        String expectedString = "Hello";
        Assert.assertEquals(expectedString, actualString);
    }



}
