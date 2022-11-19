package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.demo.commons.GenericServiceImpl;
import com.example.demo.model.Carrito;
import com.example.demo.model.Pedido;
import com.example.demo.model.Producto;
import com.example.demo.model.Usuario;
import com.example.demo.repositories.CarritoRepository;

@Service
public class CarritoServiceImpl extends GenericServiceImpl<Carrito, Integer> {

	@Autowired
	CarritoRepository carritoRepository;
	
	@Override
	public CrudRepository<Carrito, Integer> getDao() { return carritoRepository; }
	
	public void abrir(Carrito carrito, Usuario usuario) { carrito.abrir(usuario); }
	
	public void agregar(Carrito carrito, Producto producto, int cantidad) { carrito.agregar(producto, cantidad); }
	
	public void quitar(Carrito carrito, Producto producto, int cantidad) { carrito.quitar(producto, cantidad); }
	
	public void confirmar(Carrito carrito) { carrito.confirmar(); }
	
	public Pedido generarPedido(Carrito carrito) { return carrito.generarPedido(); }
	
}
