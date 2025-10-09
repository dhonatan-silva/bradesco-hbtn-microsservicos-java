package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.CPFException;
import com.example.demo.exception.UserIdException;
import com.example.demo.exception.UserNameException;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@GetMapping("/user-id/{id}")
	public String findUserById(@PathVariable int id) {
		String msg = "";
		if (id > 0 && id < 100) {
			msg = "You have entered valid ID";
		} else {
			throw new UserIdException("ID inválido");
		}
		return msg;
	}

	@GetMapping("/user-name/{username}")
	public String findUserByUserName(@PathVariable String username) {
		String msg = "";
		if (username.length() > 3 && username.length() < 15) {
			msg = "You have entered valid USERNAME";
		} else {
			throw new UserNameException("Nome inválido");
		}

		return msg;
	}

	@GetMapping("/user-cpf/{cpf}")
	public String findUserByCPF(@PathVariable String cpf) {
		String msg = "";
		if (isCPF(cpf)) {
			msg = "You have entered valid CPF";
		} else {
			throw new CPFException("error");
		}
		return msg;
	}

	public boolean isCPF(@PathVariable String CPF) {
		if (CPF.length() > 3 && CPF.length() < 15) {
			return true;
		}
		return false;
	}

}
