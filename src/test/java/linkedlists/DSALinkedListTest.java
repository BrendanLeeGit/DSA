package linkedlists;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DSALinkedListTest {
    DSALinkedList<String> list;

    @Before
    public void setUp() throws Exception {
        list = new DSALinkedList<>();
    }

    @Test
    public void add() {
        list.add("Test");
        list.add("Pest");
        assertEquals("Input- Test: ", "Test", list.get(0));
        assertEquals("Input- Pest: ", "Pest", list.get(1));
    }

    @Test
    public void testAdd() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void removeFromEnd() {
    }

    @Test
    public void get() {
    }

    @Test
    public void printList() {
    }
}