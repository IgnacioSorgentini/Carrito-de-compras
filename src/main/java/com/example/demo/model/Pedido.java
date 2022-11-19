package com.example.demo.model;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("pedidos")
public class Pedido {

	@Id
	//Se puede esto en mongo???
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nroPedido;
    private Carrito carrito;
    private Date fecha;

    public Pedido() {}
    
    public Pedido(Carrito carrito, Date fecha) {
        this.carrito = carrito;
        this.fecha = fecha;
    }

    public Integer getNroPedido() {
        return this.nroPedido;
    }

    public void setNroPedido(Integer nroPedido) {
        this.nroPedido = nroPedido;
    }

    public Carrito getCarrito() {
        return this.carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public Factura confirmarPedido() {
    	Factura factura = new Factura(carrito.getTotal(), this);
    	return factura;
    }
}
