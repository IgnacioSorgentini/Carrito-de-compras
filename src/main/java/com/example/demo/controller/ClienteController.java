/*package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Cliente;
import com.example.demo.services.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public List<Cliente> getAll() { return clienteService.getAll(); }
	
	@GetMapping("/{id}")
	public Cliente find(@PathVariable Integer id) { return clienteService.get(id); }
	
	@PostMapping
	public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
		Cliente c = clienteService.save(cliente);
		return new ResponseEntity<Cliente>(c, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Cliente> delete(@PathVariable Integer id) {
		Cliente cliente = clienteService.get(id);
		if (cliente == null)
			return new ResponseEntity<Cliente>(HttpStatus.NO_CONTENT);
		clienteService.delete(id);	
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Cliente cliente) {
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Integer id) {
		Optional<Cliente> oCliente = clienteService.get(id);
		if (!oCliente.isPresent())
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(oCliente);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Integer id) {
		if (!clienteService.get(id).isPresent())
			return ResponseEntity.notFound().build();
		clienteService.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<Cliente> readAll() {
		List<Cliente> clientes = StreamSupport
				.stream(clienteService.getAll().spliterator(), false)
				.collect(Collectors.toList());
		return clientes;
	}
	
}
*/