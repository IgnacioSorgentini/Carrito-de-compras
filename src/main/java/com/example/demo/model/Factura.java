package com.example.demo.model;

import java.math.BigInteger;
import java.util.Date;

public class Factura {
	
	//REVISAR INGRESOS DE SUBTOTAL
    private BigInteger nroFactura;
    private double subtotal;
    private double total;
    private Pedido pedido;

    public Factura() {}
    
    public Factura(double monto, Pedido pedido) {
        this.subtotal = monto;
        this.pedido = pedido;
    }

    public BigInteger getNroFactura() {
        return this.nroFactura;
    }

    public void setNroFactura(BigInteger nroFactura) {
        this.nroFactura = nroFactura;
    }

    public double getMonto() {
        return this.subtotal;
    }

    public void setMonto(double monto) {
        this.subtotal = monto;
    }

    public Pedido getPedido() {
        return this.pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    /*
    public Pago confirmarFactura(FormaDePago formaDePago) {
    	Date actual = new Date();
    	Pago pago = new Pago(formaDePago, actual, this, this.monto);
    	return pago;
    }
    */
}
