package harrypotter;

import org.junit.Test;

import static org.junit.Assert.*;

public class HarryPotterBookstoreTest {
    @Test
    public void buyingOneBook_shouldReturn8() throws Exception {
        //given
        HarryPotterBookstore bookstore = new HarryPotterBookstore();
        Order order = new Order();
        order.addBook("Episoe1",1);

        //when
        double total = bookstore.buy(order);

        //then
        assertEquals(8,total,0);
    }

    @Test
    public void buyingTwoSameBooks_shouldReturn16() throws CloneNotSupportedException {
        HarryPotterBookstore bookstore = new HarryPotterBookstore();
        Order order = new Order();
        order.addBook("Episoe1",2);

        double total = bookstore.buy(order);

        assertEquals(16, total, 0);
    }

    @Test
    public void buyingTwoDifferentBooks_shouldReturn152() throws Exception {
        HarryPotterBookstore bookstore = new HarryPotterBookstore();
        Order order = new Order();
        order.addBook("Episoe1",1);
        order.addBook("Episoe2",1);
        double total = bookstore.buy(order);
        assertEquals(15.2, total, 0);
    }

    @Test
    public void buyingThreeBooksIfTwoSame_shouldReturn232() throws Exception {
        HarryPotterBookstore bookstore = new HarryPotterBookstore();
        Order order = new Order();
        order.addBook("Episoe1",2);
        order.addBook("Episoe2",1);
        double total = bookstore.buy(order);
        assertEquals(23.2, total, 0);
    }

    @Test
    public void buyingFiveBooksIfThreeDifferent_shouldReturn368() throws Exception {
        HarryPotterBookstore bookstore = new HarryPotterBookstore();
        Order order = new Order();
        order.addBook("Episoe1",2);
        order.addBook("Episoe2",2);
        order.addBook("Episoe3",1);
        double total = bookstore.buy(order);
        assertEquals(36.8, total, 0);
    }

    @Test
    public void buying8BooksIfFiveDifferent_shouldReturn516() throws Exception {
        HarryPotterBookstore bookstore = new HarryPotterBookstore();
        Order order = new Order();
        order.addBook("Episoe1",2);
        order.addBook("Episoe2",2);
        order.addBook("Episoe3",2);
        order.addBook("Episoe4",1);
        order.addBook("Episoe5",1);
        double total = bookstore.buy(order);
        assertEquals(51.6, total, 0);
    }
}