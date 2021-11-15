package warehouse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalletTest {
    LinkedLists<Pallet> testList;

    @BeforeEach
    void setUp() {
        testList = new LinkedLists<>();
        testList.addElement(new Pallet("1A-A1", "Bananas", 25,
                21,30, 12, 4));
    }

    @Test
    void getPalletID() {
        String palID = testList.top.getContents().getPalletID();
        assertEquals("1A-A1", palID);
    }

    @Test
    void getGoodsDescription() {
        String proDesc = testList.top.getContents().getGoodsDescription();
        assertEquals("Bananas", proDesc);
    }

    @Test
    void getNumberOfGoods() {
        int proQ = testList.top.getContents().getNumberOfGoods();
        assertEquals(25, proQ);
    }

    @Test
    void getMaxTemperature() {
        Double maxST = testList.top.getContents().getMaxTemperature();
        assertEquals(21, maxST);
    }

    @Test
    void getMinTemperature() {
        Double minST = testList.top.getContents().getMinTemperature();
        assertEquals(30, minST);
    }

    @Test
    void getPalletDepth() {
        int palPD = testList.top.getContents().getPalletDepth();
        assertEquals(12, palPD);
    }

    @Test
    void getPalletWidth() {
        int palPW = testList.top.getContents().getPalletWidth();
        assertEquals(4, palPW);
    }
}