package com.example.calculator.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

	Calculator calculator = new Calculator();

	@Test
	void sumTest() {
		Double result = calculator.sub(10.0, 5.0);
		assertEquals(5.0, result);
	}

	@Test
	public void numbersNullSumTest() {
		assertThrows(NullPointerException.class, () -> {
			calculator.sum(null, null);
		});
	}

	@Test
	void subTest() {
		Double result = calculator.sub(10.0, 5.0);
		assertEquals(5.0, result);
	}

	@Test
	void divideTest() {
		Double result = calculator.divide(10.0, 5.0);
		assertEquals(2.0, result);
	}

	@Test
	public void divisionByZeroTest() {
		assertThrows(ArithmeticException.class, () -> {
			calculator.divide(10.0, 0.0);
		});
	}

	@Test
	void factorialTest() {
		Integer result = calculator.factorial(10);
		assertEquals(3628800, result);
	}

	@Test
	void integerToBinaryTest() {
		Integer result = calculator.integerToBinary(10);
		assertEquals(1010, result);
	}

	@Test
	void integerToHexadecimalTest() {
		String result = calculator.integerToHexadecimal(1500);
		assertEquals("5dc", result);
	}

	@Test
	void calculeDayBetweenDateTest() {
		int result = calculator.calculeDayBetweenDate(LocalDate.parse("2025-01-01"), LocalDate.parse("2025-01-31"));
		assertEquals(30, result);
	}
}
