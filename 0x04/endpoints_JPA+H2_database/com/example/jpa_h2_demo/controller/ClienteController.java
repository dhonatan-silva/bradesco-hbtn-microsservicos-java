package com.example_jpa_h2_demo.jpa_h2_demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example_jpa_h2_demo.jpa_h2_demo.model.Cliente;
import com.example_jpa_h2_demo.jpa_h2_demo.repository.ClienteRepository;

@RestController
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@PostMapping("/addClient")
	public ResponseEntity<Cliente> addClient(@RequestBody Cliente cliente) {
		Cliente save = clienteRepository.save(cliente);
		return ResponseEntity.ok().body(save);
	}

	@GetMapping("/findAllClients")
	public ResponseEntity<List<Cliente>> findAllClients() {
		List<Cliente> all = clienteRepository.findAll();
		return ResponseEntity.ok().body(all);
	}

	@GetMapping("/findClientById/{id}")
	public ResponseEntity<Cliente> findClientById(@PathVariable("id") Long idClient) {
		Optional<Cliente> byId = clienteRepository.findById(idClient);
		return byId.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.ok().build());
	}

	@DeleteMapping("/removeClientById/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerCliente(@PathVariable("id") Long idClient) {
		Optional<Cliente> byId = clienteRepository.findById(idClient);

		if (byId.isPresent()) {
			clienteRepository.delete(byId.get());
		}
		ResponseEntity.noContent();
	}

	@PutMapping("/updateClientById/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
		Optional<Cliente> byId = clienteRepository.findById(id);

		if (byId.isPresent()) {
			Cliente clie = byId.get();
			clienteRepository.save(new Cliente(clie.getId(), cliente.getNome(), cliente.getIdade(), cliente.getEmail(),
					cliente.getTelefones(), cliente.getEnderecos()));
		}
		ResponseEntity.noContent();
	}
}
