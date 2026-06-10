package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CartTest {

    @Test
    void addItemTest1() {
        Cart cart = new Cart();
        Item item = new Item(1, "醤油ラーメン", 780);

        cart.addItem(item);

        Assertions.assertEquals(1, cart.getCartItems().size());
        Assertions.assertEquals("醤油ラーメン", cart.getCartItems().get(0).getName());
        Assertions.assertEquals(1, cart.getCartItems().get(0).getQuantity());
    }

    @Test
    void addItemTest2() {
        Cart cart = new Cart();
        Item item = new Item(1, "醤油ラーメン", 780);

        cart.addItem(item);
        cart.addItem(item);

        Assertions.assertEquals(1, cart.getCartItems().size());
        Assertions.assertEquals(2, cart.getCartItems().get(0).getQuantity());
    }

    @Test
    void getCartItemsTest() {
        Cart cart = new Cart();

        Item item1 = new Item(1, "醤油ラーメン", 780);
        Item item2 = new Item(2, "味噌ラーメン", 850);

        cart.addItem(item1);
        cart.addItem(item2);

        Assertions.assertEquals(2, cart.getCartItems().size());
    }

    @Test
    void getTotalPrice() {
        Cart cart = new Cart();

        Item item1 = new Item(1, "醤油ラーメン", 780);
        Item item2 = new Item(2, "味噌ラーメン", 850);

        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item2); // 味噌ラーメン2個

        // 780 + 850*2 = 2480
        Assertions.assertEquals(2480, cart.getTotalPrice());
    }

}