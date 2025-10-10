package com.example.calculator.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import com.example.calculator.model.Calculator;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {

	@Autowired
	private MockMvc mvc;

	@Mock
	Calculator calculator;

	@Test
	void messageWelcome() throws Exception {
		RequestBuilder request = get("/calculator/welcome");
		MvcResult result = mvc.perform(request).andReturn();
		assertEquals("Bem vindo à CALCULATOR API REST.", result.getResponse().getContentAsString());
	}

	@Test
	void addNumbers() throws Exception {
		RequestBuilder request = get("/calculator/addNumbers?number1=10&number2=5");
		MvcResult result = mvc.perform(request).andReturn();
		assertEquals("15.0", result.getResponse().getContentAsString());
	}

	@Test
	void subNumbers() throws Exception {
		RequestBuilder request = get("/calculator/subNumbers?number1=10&number2=5");
		MvcResult result = mvc.perform(request).andReturn();
		assertEquals("5.0", result.getResponse().getContentAsString());
	}

	@Test
	void divideNumbers() throws Exception {
		RequestBuilder request = get("/calculator/divideNumbers?number1=10&number2=5");
		MvcResult result = mvc.perform(request).andReturn();
		assertEquals("2.0", result.getResponse().getContentAsString());
	}

	@Test
	void factorial() throws Exception {
		RequestBuilder request = get("/calculator/factorial?factorial=10");
		MvcResult result = mvc.perform(request).andReturn();
		assertEquals("3628800", result.getResponse().getContentAsString());
	}

	@Test
	void calculeDayBetweenDate() throws Exception {
		RequestBuilder request = get("/calculator/calculeDayBetweenDate?localDate1=2025-01-01&localDate2=2025-01-31");
		MvcResult result = mvc.perform(request).andReturn();
		assertEquals("30", result.getResponse().getContentAsString());
	}

	@Test
	void integerToBinary() throws Exception {
		RequestBuilder request = get("/calculator/integerToBinary?number1=10");
		MvcResult result = mvc.perform(request).andReturn();
		assertEquals("1010", result.getResponse().getContentAsString());
	}

	@Test
	void integerToHexadecimal() throws Exception {
		RequestBuilder request = get("/calculator/integerToHexadecimal?number1=1500");
		MvcResult result = mvc.perform(request).andReturn();
		assertEquals("5dc", result.getResponse().getContentAsString());
	}

}