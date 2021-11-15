package warehouse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShelfTest {
    LinkedLists<Shelf> testList;

    @BeforeEach
    void setUp() {
        testList = new LinkedLists<>();
        testList.addElement(new Shelf("1a-a"));
    }

    @Test
    void getShelfNumber() {
        String number = testList.top.getContents().getShelfNumber();
        assertEquals("1a-a", number);
    }
}