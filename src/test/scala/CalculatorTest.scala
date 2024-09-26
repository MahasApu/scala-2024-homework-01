import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions._


class CalculatorTest {

	@Test def sum(): Unit = {
		assertEquals(42, Calculator.calculate("22", "20", "+"))
	}

	@Test def minus(): Unit = {
		assertEquals(2, Calculator.calculate("22", "20", "-"))
	}

	@Test def swapMinus(): Unit = {
		assertEquals(-2, Calculator.calculate("22", "20", "swap", "-"))
	}

	@Test def plusAcc(): Unit = {
		assertEquals(42, Calculator.calculate("20", "20", "+", "acc", "2", "+"))
	}

	@Test def divAcc(): Unit = {
		assertEquals(20, Calculator.calculate("20", "20", "+", "acc", "2", "/"))
	}

	@Test def mult(): Unit = {
		assertEquals(40, Calculator.calculate("20", "2", "*"))
	}

	@Test def div(): Unit = {
		assertEquals(0, Calculator.calculate("22", "0", "/"))
	}

	@Test def blink(): Unit = {
		assertEquals(-1, Calculator.calculate("blink", "1", "-"))
	}

	@Test def breakPlus(): Unit = {
		assertEquals(0, Calculator.calculate("break", "1", "2", "+", "3", "4", "+"))
	}

	@Test def break(): Unit = {
		assertEquals(3, Calculator.calculate("1", "2", "+", "break", "acc", "0", "/"))
	}
}