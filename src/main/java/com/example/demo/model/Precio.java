package com.example.demo.model;

import java.util.Date;

public class Precio {
	
	private double valor;
	private String operador;
	private Date fecha;
	
	private Precio(double valor, String operador, Date fecha) {
		this.valor = valor;
		this.operador = operador;
		this.fecha = fecha;
	}
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getOperador() {
		return operador;
	}
	public void setOperador(String operador) {
		this.operador = operador;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
