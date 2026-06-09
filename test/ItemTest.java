import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    @Test
    void test1() {
        int expectedId = 1;
        int expectedPrice = 750;
        String expectedName = "醬油ラーメン";
        Item ci = new Item(expectedId, expectedName, expectedPrice);
        assertEquals(expectedId, ci.getId());
        assertEquals(expectedName, ci.getName());
        assertEquals(expectedPrice, ci.getPrice());
    }

    @Test
    void test2() {
        Item ci = new Item(0, "初期名前", 100);
        ci.setId(2);
        ci.setName("塩ラーメン");
        ci.setPrice(1000);
        assertEquals(1000, ci.getPrice());
        assertEquals("塩ラーメン", ci.getName());
        assertEquals(2, ci.getId());
    }
}