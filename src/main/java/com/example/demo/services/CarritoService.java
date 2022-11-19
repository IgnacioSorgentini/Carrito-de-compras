package com.example.demo.services;

import com.example.demo.commons.GenericService;
import com.example.demo.model.Carrito;
import com.example.demo.model.Pedido;
import com.example.demo.model.Producto;
import com.example.demo.model.Usuario;

public interface CarritoService extends GenericService<Carrito, Integer> {

	public void abrir(Carrito carrito, Usuario usuario);
	
	public void agregar(Carrito carrito, Producto producto, int cantidad);
	
	public void quitar(Carrito carrito, Producto producto);
	
	public void confirmar(Carrito carrito);
	
	public Pedido generarPedido(Carrito carrito);
	
}
