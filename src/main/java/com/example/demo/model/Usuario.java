package com.example.demo.model;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Usuario {

	@Id
    private String nombre;
    private String contrasenia;
    //ESTADO SIRVE?
    private boolean estado;
    private String direccion;
    private boolean condicionIVA;
    private boolean operador;
    
    //COMO AGREGAR A REDIS?
    //private List<Comentario> comentarios;
    //private List<Pedido> pedidos;
    //private List<Pago> pagos;

    /*
    public void iniciarSesion() {
    	this.setEstado(true);
    }

    public void cerrarSesion(){
    	this.setEstado(false);
    }
    */
    
    public Usuario() {}
    
    public Usuario(String nombre, boolean condicionIVA) {
        this.nombre = nombre;
        this.condicionIVA = condicionIVA;
    }

    public Usuario(String nombre, String contrasenia, boolean estado, String direccion, boolean condicionIVA, boolean operador) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.estado = estado;
        this.direccion = direccion;
        this.condicionIVA = condicionIVA;
        this.operador = operador;
    }

    public String getNombre() { return this.nombre; }
    public String getContrasenia() {  return this.contrasenia; }
    public boolean isEstado() { return this.estado; }
    public String getDireccion() { return this.direccion; }
    public boolean isCondicionIVA() { return this.condicionIVA; }
    public boolean isOperador() { return this.operador; }
	//public List<Pedido> getPedidos() { return pedidos; }
    
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setContrasenia(String contrasenia) { this.contrasenia = contrasenia; }
    public boolean getEstado() { return this.estado; }
    public void setEstado(boolean estado) { this.estado = estado; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public void setCondicionIVA(boolean condicionIVA) { this.condicionIVA = condicionIVA; }
	public void setOperador(boolean operador) { this.operador = operador; }

	public void comentar(Producto producto, String titulo, String contenido) {
    	Date actual = new Date();
    	Comentario comentario = new Comentario(titulo, contenido, actual, this.nombre);
    	producto.agregarComentario(comentario);
    	//this.comentarios.add(comentario);
    }
    
    public Pago pagar(Factura factura, FormaDePago formaDePago, double monto) {
    	Date actual = new Date();
    	Pago pago = new Pago(formaDePago, actual, factura, monto);
    	//this.pagos.add(pago);
    	return pago;
    }
}
