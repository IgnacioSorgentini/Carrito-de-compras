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

import com.example.demo.model.Producto;
import com.example.demo.services.ProductoService;
import com.example.demo.services.ProductoServiceImpl;

@RestController
@RequestMapping("tpobd/productos")
public class ProductoController {
	
	@Autowired
	private ProductoServiceImpl productoService;
	
	@GetMapping
	public List<Producto> getAll() { return productoService.getAll(); }
	
	@GetMapping("/{id}")
	public Producto find(@PathVariable String id) { return productoService.get(id); }
	
	@PostMapping
	public ResponseEntity<Producto> save(@RequestBody Producto producto) {
		Producto p = productoService.save(producto);
		return new ResponseEntity<Producto>(p, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Producto> delete(@PathVariable String id) {
		Producto producto = productoService.get(id);
		if (producto == null)
			return new ResponseEntity<Producto>(HttpStatus.NO_CONTENT);
		productoService.delete(id);	
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}
}
