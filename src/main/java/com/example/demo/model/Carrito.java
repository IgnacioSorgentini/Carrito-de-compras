package com.example.demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Carrito {
	
	private Integer id;
    private Usuario usuario;
    //private List<Producto> productos;
    private Map<Producto, Integer> productos;
    private double total;
    
	Originator originator = new Originator();
	Caretaker caretaker = new Caretaker();
    
    //private List<Carrito> estados;

	public Carrito() {}

    
    public Carrito(Integer id, Usuario usuario) {
    	this.id = id;
    	this.usuario = usuario;
    	productos = new HashMap<Producto, Integer>();
    }

	public Integer getId() { return this.id; }
	
    public Usuario getUsuario() { return this.usuario; }

    public Map<Producto, Integer> getProductos() { return this.productos; }
    //public List<Producto> getProductos() { return this.productos; }

    public double getTotal() { return this.total;  }
    
    //public List<Carrito> getEstados() { return estados; }
    
    public class Memento {
    	private Map<Producto, Integer> estado;
    	
    	public Memento(Map<Producto, Integer> estado) { this.estado = estado; }
    	
    	public Map<Producto, Integer> getEstado() { return estado; }
    }
    
    public class Originator {
    	   private Map<Producto, Integer> estado;

    	   public void setEstado(Map<Producto, Integer> estado) { this.estado = estado; }

    	   public Map<Producto, Integer> getEstado() { return estado; }

    	   public Memento saveStateToMemento() {  return new Memento(estado); }

    	   public void getStateFromMemento(Memento memento) { estado = memento.getEstado(); }
    }
    
    public class Caretaker {
    	   private List<Memento> mementoList = new ArrayList<Memento>();

    	   public void add(Memento estado) { mementoList.add(estado); }

    	   public Memento get(int index){ return mementoList.get(index); }
    }
    
    public void abrir(Usuario usuario) {
    	this.usuario = usuario;
    	this.productos = new HashMap<Producto, Integer>();
    	
    	originator.setEstado(this.productos);
    	caretaker.add(originator.saveStateToMemento());
    	
    	for (Map.Entry<Producto, Integer> p : originator.getEstado().entrySet())
    		System.out.println(p.getKey() + "-" + p.getValue());
    }
    
    public void agregar(Producto producto, int cantidad) {
    	
    	if (productos.containsKey(producto))
    		this.productos.put(producto, productos.get(producto) + cantidad);
    	else
    		this.productos.put(producto, cantidad);
    	
    	originator.setEstado(this.productos);
    	caretaker.add(originator.saveStateToMemento());
    	
    	for (Map.Entry<Producto, Integer> p : originator.getEstado().entrySet())
    		System.out.println(p.getKey().getDescripcion() + "-" + p.getValue());
    }
    
    public void quitar(Producto producto, int cantidad) {
    	if (!this.productos.containsKey(producto))
    		System.out.println("El producto no está en el carrito");
    	else
    		if ((this.productos.get(producto) - cantidad) < 0)
    			System.out.println("La cantidad especificada es mayor a la cantidad en el carrito");
    		else {
	    		this.productos.put(producto, productos.get(producto) - cantidad);
	    		
	    		//this.estados.add(this);
	    		originator.setEstado(this.productos);
	        	caretaker.add(originator.saveStateToMemento());
	        	
	        	for (Map.Entry<Producto, Integer> p : originator.getEstado().entrySet())
	        		System.out.println(p.getKey().getDescripcion() + "-" + p.getValue());
    		}
    }
    
    
    public void recuperarEstado() {
    	this.productos = caretaker.get(caretaker.mementoList.size() - 2).getEstado();
    }
    
    
    public void confirmar() {
    	double subtotal = 0;
    	for (Producto p : productos.keySet())
    		subtotal += p.getPrecio() * productos.get(p);
    	this.total = subtotal;
    	this.productos.clear();
    }
    
    /*
    
    public class Memento {
    	private List<Producto> estado;
    	
    	public Memento(List<Producto> estado) { this.estado = estado; }
    	
    	public List<Producto> getEstado() { return estado; }
    }
    
    public class Originator {
    	   private List<Producto> estado;

    	   public void setEstado(List<Producto> estado) { this.estado = estado; }

    	   public List<Producto> getEstado() { return estado; }

    	   public Memento saveStateToMemento() {  return new Memento(estado); }

    	   public void getStateFromMemento(Memento memento) { estado = memento.getEstado(); }
    }
    
    public class Caretaker {
    	   private List<Memento> mementoList = new ArrayList<Memento>();

    	   public void add(Memento estado) { mementoList.add(estado); }

    	   public Memento get(int index){ return mementoList.get(index); }
    }
    
    public void abrir(Usuario usuario) {
    	this.usuario = usuario;
    	this.productos = new ArrayList<Producto>();
    	
    	//this.estados = new ArrayList<Carrito>();
    	originator.setEstado(this.productos);
    	caretaker.add(originator.saveStateToMemento());
    	
    	for (Producto p : originator.getEstado())
    		System.out.println(p.getPrecio());
    }
    
    //REVISAR
    //USAR MAP
    public void agregar(Producto producto, int cantidad) {
    	for (int i = 0; i < cantidad; i++)
    		this.productos.add(producto);
    	
    	//this.estados.add(this);
    	originator.setEstado(this.productos);
    	caretaker.add(originator.saveStateToMemento());
    	
    	for (Producto p : originator.getEstado())
    		System.out.println(p.getPrecio());
    }
    
    //REVISAR
    //HACER QUE QUITE CANTIDADES
    //INT CANTIDAD NO HACE NADA
    public void quitar(Producto producto, int cantidad) {
    	if (!this.productos.contains(producto))
    		System.out.println("El producto no está en el carrito");
    	else {
    		this.productos.remove(producto);
    		
    		//this.estados.add(this);
    		originator.setEstado(this.productos);
        	caretaker.add(originator.saveStateToMemento());
        	
        	for (Producto p : originator.getEstado())
        		System.out.println(p.getPrecio());
    	}
    }
    
    
    public void recuperarEstado() {
    	//this.productos = this.estados.get(this.estados.size() - 1).productos;
    	//this.estados.remove(this.estados.size());
    	this.productos = caretaker.get(caretaker.mementoList.size() - 2).getEstado();
    	
    	for (Producto p : this.productos)
    		System.out.println(p.getPrecio());
    	System.out.println("---------");
    	for (Producto p : caretaker.get(0).getEstado())
    		System.out.println(p.getDescripcion());
    	System.out.println("----");
    	for (Producto p : caretaker.get(1).getEstado())
    		System.out.println(p.getDescripcion());
    	System.out.println("----");
    	for (Producto p : caretaker.get(2).getEstado())
    		System.out.println(p.getDescripcion());
    	System.out.println("----");
    	for (Producto p : caretaker.get(3).getEstado())
    		System.out.println(p.getDescripcion());
    	System.out.println("----");
    	for (Producto p : caretaker.get(4).getEstado())
    		System.out.println(p.getDescripcion());
    	System.out.println("----");
    	for (Producto p : caretaker.get(5).getEstado())
    		System.out.println(p.getDescripcion());
    	System.out.println("----");
    }
    
    
    public void confirmar() {
    	double subtotal = 0;
    	for (Producto p : productos)
    		subtotal += p.getPrecio();
    	//EL IVA SE CALCULA EN LA FACTURA
    	if (this.usuario.isCondicionIVA())
    		subtotal *= 1.21;
    	this.total = subtotal;
    	this.productos.clear();
    }
    */
    
    public Pedido generarPedido() {
    	Date actual = new Date();
    	Pedido pedido = new Pedido(this, actual);
    	//this.usuario.getPedidos().add(pedido);
    	return pedido;
    }
}
