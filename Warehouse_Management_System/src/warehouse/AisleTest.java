package warehouse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AisleTest {
    LinkedLists<Aisle> testList;

    @BeforeEach
    void setUp() {
        testList = new LinkedLists<>();
        testList.addElement(new Aisle("1A", 12,4));
    }

    @Test
    void getAisleIdentifier() {
        String aisleID = testList.top.getContents().getAisleIdentifier();
        assertEquals("1A", aisleID);
    }

    @Test
    void getAisleDepth() {
        int aW = testList.top.getContents().getAisleWidth();
        assertEquals(4, aW);
    }

    @Test
    void getAisleWidth() {
        int aD = testList.top.getContents().getAisleDepth();
        assertEquals(12, aD);
    }
}