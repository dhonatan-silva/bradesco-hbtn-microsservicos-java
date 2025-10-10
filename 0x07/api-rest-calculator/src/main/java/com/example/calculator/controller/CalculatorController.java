package com.example.calculator.controller;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.calculator.model.Calculator;

@RestController
@RequestMapping(value = "/calculator")
public class CalculatorController {

	private Calculator calculator = new Calculator();

	@GetMapping("/welcome")
	public String messageWelcome() {
		return "Bem vindo à CALCULATOR API REST.";
	}

	@GetMapping("/addNumbers")
	public String addNumbers(@RequestParam(name = "number1") Double n1, @RequestParam(name = "number2") Double n2) {
		Double sum = calculator.sum(n1, n2);
		return sum.toString();

	}

	@GetMapping("/subNumbers")
	public String subNumbers(@RequestParam(name = "number1") Double n1, @RequestParam(name = "number2") Double n2) {
		Double result = calculator.sub(n1, n2);
		return result.toString();
	}

	@GetMapping("/divideNumbers")
	public String divideNumbers(@RequestParam(name = "number1") Double n1, @RequestParam(name = "number2") Double n2) {
		Double divide = calculator.divide(n1, n2);
		return divide.toString();
	}

	@GetMapping("/factorial")
	public String factorial(@RequestParam(name = "factorial") Integer factorial) {
		Integer facto = calculator.factorial(factorial);
		return facto.toString();

	}

	@GetMapping("/calculeDayBetweenDate")
	public String calculeDayBetweenDate(
			@RequestParam("localDate1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate1,
			@RequestParam("localDate2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate2) {

		Integer dias = calculator.calculeDayBetweenDate(localDate1, localDate2);

		return dias.toString();
	}

	@GetMapping("/integerToBinary")
	public String integerToBinary(@RequestParam(name = "number1") Integer n1) {
		Integer binary = calculator.integerToBinary(n1);
		return binary.toString();
	}

	@GetMapping("/integerToHexadecimal")
	public String integerToHexadecimal(@RequestParam(name = "number1") Integer n1) {
		String hexa = calculator.integerToHexadecimal(n1);
		return hexa.toString();
	}
}
