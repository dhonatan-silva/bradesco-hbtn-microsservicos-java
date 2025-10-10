package com.example.calculator.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class Calculator {

	public Double sum(Double number1, Double number2) {
		// validação -> throw new NullPointerException("Número 1 e número 2 são
		// obrigatórios.");
		if (number1.equals(null) || number1.equals(null)) {
			throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
		}
		return number1 + number2;
	}

	public Double sub(Double number1, Double number2) {
		// validação -> throw new NullPointerException("Número 1 e número 2 são
		// obrigatórios.");
		if (number1.equals(null) || number1.equals(null)) {
			throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
		}
		return number1 - number2;
	}

	public Double divide(Double number1, Double number2) {
		// validação -> throw new NullPointerException("Número 1 e número 2 são
		// obrigatórios.");
		// validação -> throw new ArithmeticException("Divisão por zero não é
		// permitido.");
		if (number1.equals(null) || number1.equals(null)) {
			throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
		}

		if (number2.equals(0.0)) {
			throw new ArithmeticException("Divisão por zero não é permitido.");
		}
		return number1 / number2;
	}

	public Integer factorial(Integer factorial) {
		// validação -> throw new NullPointerException("Número é obrigatório.");

		Long resultado = 1L;
		for (int i = 2; i <= factorial; i++) {
			resultado *= i;
		}

		return resultado.intValue();
	}

	// Exemplos:
	// Integer = 1 -> Binary = 1
	// Integer = 5 -> Binary = 101
	// Integer = 20 -> Binary = 10100
	public Integer integerToBinary(Integer integer) {
		String binary = Integer.toBinaryString(integer);
		return Integer.parseInt(binary);
	}

	// Exemplos:
	// Integer = 1 -> Hexadecimal = "1"
	// Integer = 5 -> Hexadecimal = "37"
	// Integer = 170 -> Binary = "AA"
	public String integerToHexadecimal(Integer integer) {
		return Integer.toHexString(integer);
	}

	// Exemplos
	// Date 1 = LocalDate.of(2020, 3, 15);
	// Date 2 = LocalDate.of(2020, 3, 29)
	// Total de dias = 14
	public int calculeDayBetweenDate(LocalDate date1, LocalDate date2) {
		Long dias = ChronoUnit.DAYS.between(date1, date2);
		return dias.intValue();
	}
}
