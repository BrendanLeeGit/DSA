package linkedlists;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class DSALinkedListTest {
    DSALinkedList<String> list;

    @Before
    public void setUp() throws Exception {
        list = new DSALinkedList<>();
        list.add("1");
        list.add("2");
    }

    @Test
    public void add() {
        list.add("Test");
        list.add("Pest");
        assertEquals("Input- Test: ", "Test", list.get(2));
        assertEquals("Input- Pest: ", "Pest", list.get(3));
    }

    @Test
    public void setData() {
        list.setData("Bloop", 1);
        assertEquals("Add data to second position node- Bloop: ", "Bloop", list.get(1));
    }

    @Test
    public void remove() {
        list.remove(0);
        assertEquals("Removing first item from list: ", "2", list.get(0));
    }

    @Test
    public void removeFromEnd() {
        list.removeFromEnd();
        assertEquals("Remove from end: ", "1", list.get(0));
        assertEquals("Check size is 1: ", 1, list.getSize());
    }

    @Test
    public void get() {
    }

    @Test
    public void printList() {
    }
}
