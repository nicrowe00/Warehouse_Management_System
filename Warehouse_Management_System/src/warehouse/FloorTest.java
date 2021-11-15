package warehouse;

import static org.junit.jupiter.api.Assertions.*;

class FloorTest {
    LinkedLists<Floor> testList;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        testList = new LinkedLists<>();
        testList.addElement(new Floor(1, "high", 21.00));
    }

    @org.junit.jupiter.api.Test
    void getFloorNumber() {
        int fNumber = testList.top.getContents().getFloorNumber();
        assertEquals(1, fNumber);
    }

    @org.junit.jupiter.api.Test
    void getSecurityLevel() {
        String secLvl = testList.top.getContents().getSecurityLevel();
        assertEquals("high", secLvl);
    }


    @org.junit.jupiter.api.Test
    void getFloorTemperature() {
        Double fTemp = testList.top.getContents().getFloorTemperature();
        assertEquals(21.00, fTemp);
    }
    }


