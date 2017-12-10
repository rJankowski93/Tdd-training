package fizzbuzz;

/**
 * Created by Rafi on 04/11/2017.
 */
public class FizzBuzz {
    public static String FIZZ = "Fizz";
    public static String BUZZ = "Buzz";

    final Long fizz;
    final Long buzz;

    public FizzBuzz(Long fizz, Long buzz) {
        this.fizz = fizz;
        this.buzz = buzz;
    }

    public FizzBuzz() {
        this(3L,5L);
    }

    protected String check(Long number) {
        StringBuilder response = new StringBuilder();
        fizz(number, response);
        buzz(number, response);
        number(number, response);
        return response.toString();
    }

    private void number(Long number, StringBuilder response) {
        if (response.length() == 0) {
            response.append(number);
        }
    }

    private void buzz(Long number, StringBuilder response) {
        if (number % buzz == 0) {
            response.append(BUZZ);
        }
    }

    private void fizz(Long number, StringBuilder response) {
        if (number % fizz == 0) {
            response.append(FIZZ);
        }
    }
}
