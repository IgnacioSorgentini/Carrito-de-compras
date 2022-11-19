package com.example.demo.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("catalogoProductos")
public class Producto {
	
	//@Id
	//ID COMO STRING?
    private String id;
    private double precio;
    private String marca;
    private String descripcion;
    private List<Precio> historial;
    private List<String> imagenes;
    private List<Comentario> comentarios;
    private List<String> videos;

    public Producto() {}
    
    public Producto(String id, double precio, String marca, String descripcion) {
    	this.id = id;
        this.precio = precio;
        this.marca = marca;
        this.descripcion = descripcion;
        this.imagenes = new ArrayList<String>();
        this.comentarios = new ArrayList<Comentario>();
        this.videos = new ArrayList<String>();
    }

	public Producto(String idProducto, double precio, String marca, String descripcion, List<Precio> historial, List<String> imagenes, List<Comentario> comentarios, List<String> videos) {
        this.id = idProducto;
        this.precio = precio;
        this.marca = marca;
        this.descripcion = descripcion;
        this.historial = historial;
        this.imagenes = imagenes;
        this.comentarios = comentarios;
        this.videos = videos;
    }
	
    public String getIdProducto() {
        return this.id;
    }

    public void setIdProducto(String idProducto) {
        this.id = idProducto;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<String> getImagenes() {
        return this.imagenes;
    }

    public List<Comentario> getComentarios() {
        return this.comentarios;
    }

    public List<String> getVideos() {
        return this.videos;
    }
    
    public List<Precio> getHistorial() {
		return historial;
	}

	public void agregarComentario(Comentario comentario) {
    	this.comentarios.add(comentario);
    }
	
	public void modificarPrecio(Precio precio) {
		this.precio = precio.getValor();
		this.historial.add(precio);
	}
    
}
