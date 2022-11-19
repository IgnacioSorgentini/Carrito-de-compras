package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Usuario;
import com.example.demo.services.UsuarioService;

@RestController
@RequestMapping("tpobd/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	/*
	@GetMapping
	public List<Usuario> getAll() { return usuarioService.findAll(); }
	*/
	@GetMapping("/{id}")
	public Usuario find(@PathVariable String id) { return usuarioService.findByNombre(id); }
	
	@PostMapping
	public ResponseEntity<Usuario> save(@RequestBody Usuario usuario) {
		Usuario u = usuarioService.save(usuario);
		return new ResponseEntity<Usuario>(u, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Usuario> delete(@PathVariable String id) {
		Usuario usuario = usuarioService.findByNombre(id);
		if (usuario == null)
			return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
		usuarioService.delete(id);	
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
}
