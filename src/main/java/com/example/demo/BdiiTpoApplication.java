package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.demo.model.Carrito;
import com.example.demo.model.Factura;
import com.example.demo.model.Pago;
import com.example.demo.model.Pedido;
import com.example.demo.model.Producto;
import com.example.demo.model.Usuario;
import com.example.demo.repositories.ProductoRepository;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@EnableMongoRepositories
public class BdiiTpoApplication {
	
	@Autowired
	ProductoRepository productoRepository;

	public static void main(String[] args) {
		SpringApplication.run(BdiiTpoApplication.class, args);
		/*
		Producto p = new Producto(20, "marcaA", "prodA");
		Usuario u = new Usuario("usuarioA", true);
		Carrito c = new Carrito();
		c.abrir(u);
		System.out.println("//1//");
		c.agregar(p, 1);
		
		System.out.println("//2//");
		c.agregar(p, 1);
		
		System.out.println("//5//");
		c.agregar(p, 3);
		
		System.out.println("//4//");
		c.quitar(p, 1);
		
		System.out.println("//7//");
		c.agregar(p, 3);
		
		//System.out.println("//4//");
		//c.recuperarEstado();
		
		System.out.println("//8//");
		c.agregar(p, 1);
		
		c.quitar(p, 7);
		c.quitar(p, 14);
		c.agregar(p, 1);
		
		c.confirmar();
		System.out.println(c.getTotal());
		*/
	}
}
