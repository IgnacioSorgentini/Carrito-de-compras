package com.example.demo.model;

import java.util.Date;

enum FormaDePago { tarjeta, efectivo, mercadoPago }

public class Pago {
	
    private FormaDePago FormaDePago;
    private Date fecha;
    private Factura factura;
    private double monto;
    //¿?
    private String operador;

    public Pago() {}

    public Pago(FormaDePago FormaDePago, Date fecha, Factura factura, double monto) {
        this.FormaDePago = FormaDePago;
        this.fecha = fecha;
        this.factura = factura;
        this.monto = monto;
    }

    public FormaDePago getFormaDePago() {
        return this.FormaDePago;
    }

    public void setFormaDePago(FormaDePago FormaDePago) {
        this.FormaDePago = FormaDePago;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Factura getFactura() {
        return this.factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public double getMonto() {
        return this.monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

}