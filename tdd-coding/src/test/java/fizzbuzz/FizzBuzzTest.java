package fizzbuzz;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {


    @Test
    public void shouldReturn1WhenNumberIs1() {
        //given
        Long number = 1L;
        FizzBuzz fizzBuzz = new FizzBuzz();

        //when
        String response = fizzBuzz.check(number);

        //then
        assertEquals("1", response);
    }

    @Test
    public void shouldReturn2WhenNumberIs2() throws Exception {
        //given
        Long number = 2L;
        FizzBuzz fizzBuzz = new FizzBuzz();


        //when
        String response = fizzBuzz.check(number);

        //then
        assertEquals("2", response);
    }

    @Test
    public void shouldReturnFizzWhenNumberIs3() throws Exception {
        //given
        Long number = 3L;
        FizzBuzz fizzBuzz = new FizzBuzz();


        //when
        String response = fizzBuzz.check(number);

        //then
        assertEquals("Fizz", response);
    }

    @Test
    public void shouldReturnFizzWhenNumberIs6() throws Exception {
        //given
        Long number = 6L;
        FizzBuzz fizzBuzz = new FizzBuzz();


        //when
        String response = fizzBuzz.check(number);

        //then
        assertEquals("Fizz", response);
    }

    @Test
    public void shouldReturnBuzzWhenNumberIs5() throws Exception {
        //given
        Long number = 5L;
        FizzBuzz fizzBuzz = new FizzBuzz();


        //when
        String response = fizzBuzz.check(number);

        //then
        assertEquals("Buzz", response);
    }

    @Test
    public void shouldReturnFizzBuzzWhenNumberIs15() throws Exception {
        //given
        Long number = 15L;
        FizzBuzz fizzBuzz = new FizzBuzz();


        //when
        String response = fizzBuzz.check(number);

        //then
        assertEquals("FizzBuzz", response);
    }

    @Test
    public void shouldReturnFizzWhenNumberIs4() throws Exception {
        //given
        Long number = 4L;
        FizzBuzz fizzBuzz = new FizzBuzz(4L, 7L);


        //when
        String response = fizzBuzz.check(number);

        //then
        assertEquals("Fizz", response);
    }


}
