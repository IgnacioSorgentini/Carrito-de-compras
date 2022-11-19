package com.example.demo.controller;

import java.util.List;

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

import com.example.demo.model.Carrito;
import com.example.demo.model.Pedido;
import com.example.demo.model.Producto;
import com.example.demo.services.CarritoServiceImpl;
import com.example.demo.services.PedidoServiceImpl;
import com.example.demo.services.ProductoServiceImpl;
import com.example.demo.services.UsuarioService;

@RestController
@RequestMapping("tpobd/carrito")
public class CarritoController {
	
	@Autowired
	private CarritoServiceImpl carritoService;
	
	@Autowired
	private ProductoServiceImpl productoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PedidoServiceImpl pedidoService;

	@GetMapping("/{id}")
	public  ResponseEntity<Carrito> find(@PathVariable Integer id) {
		//return carritoService.get(id);
		return new ResponseEntity<Carrito>(carritoService.get(id), HttpStatus.OK);
	}
	
	/*
	//ESTO SE USA?
	@PostMapping
	public ResponseEntity<Carrito> save(@RequestBody Carrito carrito) {
		Carrito c = carritoService.save(carrito);
		return new ResponseEntity<Carrito>(c, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Producto> delete(@PathVariable Integer id) {
		Producto producto = productoService.get(id);
		if (producto == null)
			return new ResponseEntity<Producto>(HttpStatus.NO_CONTENT);
		productoService.delete(id);	
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}
	*/
	//UTILIZA EL NOMBRE DE USUARIO, NO UN ID
	@PutMapping("/abrir")
	public ResponseEntity<Carrito> abrir(@RequestParam Integer id, String nombre) {
		Carrito carrito = new Carrito(id, usuarioService.findByNombre(nombre));
		carritoService.abrir(carrito, usuarioService.findByNombre(nombre));
		carritoService.save(carrito);
		return new ResponseEntity<Carrito>(carrito, HttpStatus.OK);
	}
	
	@PutMapping("/{id}/agregar")
	public ResponseEntity<Carrito> agregarProducto(@PathVariable Integer id, @RequestParam String idProducto, int cantidad) {
		carritoService.agregar(carritoService.get(id), productoService.get(idProducto), cantidad);
		return new ResponseEntity<Carrito>(HttpStatus.OK);
	}
	
	@PutMapping("/{id}/quitar")
	public ResponseEntity<Carrito> quitarProducto(@PathVariable Integer id, @RequestParam String idProducto, int cantidad) {
		carritoService.quitar(carritoService.get(id), productoService.get(idProducto), cantidad);
		return new ResponseEntity<Carrito>(HttpStatus.OK);
	}
	
	//----------------//
	//RECUPERAR ESTADO//
	//----------------//
	
	@PutMapping("/{id}/confirmar")
	public ResponseEntity<Carrito> confirmar(@PathVariable Integer id) {
		carritoService.confirmar(carritoService.get(id));
		Pedido p = carritoService.generarPedido(carritoService.get(id));
		pedidoService.save(p);
		return new ResponseEntity<Carrito>(HttpStatus.OK);
	}
	
	@GetMapping("/pedido/{id}")
	public ResponseEntity<Pedido> getPedido(@PathVariable Integer id) {
		Pedido p = pedidoService.get(id);
		return new ResponseEntity<Pedido>(p, HttpStatus.OK);
	}
	
}
