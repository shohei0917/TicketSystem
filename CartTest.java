import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    @Test
    void addItem() {
        Cart cart = new Cart();
        Item item = new Item(2, "醤油ラーメン", 780);

        cart.addItem(item);

        assertEquals(1, cart.getCartItems().size());
        assertEquals("醤油ラーメン", cart.getCartItems().get(0).getName());
        assertEquals(1, cart.getCartItems().get(0).getQuantity());

    }
    @Test
    void getCartItem() {
        Cart cart = new Cart();

        cart.addItem(new Item(1, "特製ラーメン", 1000));
        cart.addItem(new Item(2, "醤油ラーメン", 780));

        assertEquals(2, cart.getCartItems().size());

    }

    @Test
    void getTotalPrice() {
        Cart cart = new Cart();

        cart.addItem(new Item(1, "特製ラーメン", 1000));
        cart.addItem(new Item(2, "醤油ラーメン", 780));
        cart.addItem(new Item(1, "特製ラーメン", 1000));

        assertEquals(2780, cart.getTotalPrice());
    }
}