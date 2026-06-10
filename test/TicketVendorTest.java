import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TicketVendorTest {
    @Test
    void showItemsTest() {
        Item item=new Item(1,"醤油ラーメン",750);
        List<Item> itemList=new ArrayList<>();
        itemList.add(item);
        TicketVendor ticketVendor=new TicketVendor(itemList);
        PrintStream defaultPrintStream = System.out;
        ByteArrayOutputStream stdOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stdOut));
        String lineSeparator = System.getProperty("line.separator");
        ticketVendor.showItems();
        String expected="商品　　　　　金額" + lineSeparator+"1.醤油ラーメン　750円"+lineSeparator;
        assertEquals(expected, stdOut.toString());
        System.setOut(defaultPrintStream);
    }

    @Test
    void addItemToCartTest1() {
        Item item=new Item(1,"醤油ラーメン",750);
        List<Item> itemList=new ArrayList<>();
        itemList.add(item);
        TicketVendor ticketVendor=new TicketVendor(itemList);
        ticketVendor.addItemToCart(1);
        PrintStream defaultPrintStream = System.out;
        ByteArrayOutputStream stdOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stdOut));
        String lineSeparator = System.getProperty("line.separator");
        ticketVendor.showCartItems();
        String expected="商品　　　　　　　　数量" + lineSeparator+"醤油ラーメン  1"+lineSeparator+"合計750円です。"+lineSeparator;
        assertEquals(expected, stdOut.toString());
        System.setOut(defaultPrintStream);
    }

    @Test
    void addItemToCartTest2() {
        Item item=new Item(1,"醤油ラーメン",750);
        List<Item> itemList=new ArrayList<>();
        itemList.add(item);
        TicketVendor ticketVendor=new TicketVendor(itemList);
        ticketVendor.addItemToCart(1);
        ticketVendor.addItemToCart(1);
        PrintStream defaultPrintStream = System.out;
        ByteArrayOutputStream stdOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stdOut));
        String lineSeparator = System.getProperty("line.separator");
        ticketVendor.showCartItems();
        String expected="商品　　　　　　　　数量" + lineSeparator+"醤油ラーメン  2"+lineSeparator+"合計1500円です。"+lineSeparator;
        assertEquals(expected, stdOut.toString());
        System.setOut(defaultPrintStream);
    }

    @Test
    void showCartItemsTest() {
        Item item=new Item(1,"醤油ラーメン",750);
        List<Item> itemList=new ArrayList<>();
        itemList.add(item);
        TicketVendor ticketVendor=new TicketVendor(itemList);
        ticketVendor.addItemToCart(1);
        PrintStream defaultPrintStream = System.out;
        ByteArrayOutputStream stdOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stdOut));
        String lineSeparator = System.getProperty("line.separator");
        ticketVendor.showCartItems();
        String expected="商品　　　　　　　　数量" + lineSeparator+"醤油ラーメン  1"+lineSeparator+"合計750円です。"+lineSeparator;
        assertEquals(expected, stdOut.toString());
        System.setOut(defaultPrintStream);
    }

    @Test
    void showChangeTest1() {
        Item item=new Item(1,"醤油ラーメン",750);
        List<Item> itemList=new ArrayList<>();
        itemList.add(item);
        TicketVendor ticketVendor=new TicketVendor(itemList);
        ticketVendor.addItemToCart(1);
        boolean expected=false;
        boolean actual=ticketVendor.showChange(500);
        assertEquals(expected,actual);
    }

    @Test
    void showChangeTest2() {
        Item item=new Item(1,"醤油ラーメン",750);
        List<Item> itemList=new ArrayList<>();
        itemList.add(item);
        TicketVendor ticketVendor=new TicketVendor(itemList);
        ticketVendor.addItemToCart(1);
        boolean expected=false;
        boolean actual=ticketVendor.showChange(749);
        assertEquals(expected,actual);
    }

    @Test
    void showChangeTest3() {
        Item item=new Item(1,"醤油ラーメン",750);
        List<Item> itemList=new ArrayList<>();
        itemList.add(item);
        TicketVendor ticketVendor=new TicketVendor(itemList);
        ticketVendor.addItemToCart(1);
        boolean expected=true;
        boolean actual=ticketVendor.showChange(750);
        assertEquals(expected,actual);
    }

    @Test
    void showChangeTest4() {
        Item item=new Item(1,"醤油ラーメン",750);
        List<Item> itemList=new ArrayList<>();
        itemList.add(item);
        TicketVendor ticketVendor=new TicketVendor(itemList);
        ticketVendor.addItemToCart(1);
        boolean expected=true;
        boolean actual=ticketVendor.showChange(1000);
        assertEquals(expected,actual);
    }
}