package example.presentation.mutation;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class CalculatorTest {

	@Test
	public void shouldReturn4() throws Exception {
		Calculator calculator = new Calculator();
		Integer a = 5;
		Integer b = 13;
		Integer total = calculator.sum(a, b);
	}
}
