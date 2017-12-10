package harrypotter;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class OrderTest {

    @Test
    public void shouldReturnOneBook() throws Exception {
        //given
        Order order = new Order();
        Map<String, Integer> expectedMaps = new HashMap<String, Integer>(){
            {
                put("Episode1", 1);
            }
        };

        //when
        order.addBook("Episode1", 1);

        //then
        assertEquals(expectedMaps, order.getBooks());
    }
}