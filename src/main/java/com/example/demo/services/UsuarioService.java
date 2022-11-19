package com.example.demo.services;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.demo.model.Usuario;

import redis.clients.jedis.Jedis;

@Service
public class UsuarioService {
	
	Jedis jedis = new Jedis("localhost");
	
	public Usuario findByNombre(String nombre) {
		String key = "user:"+nombre;
		Set<String> keys = jedis.hkeys(key);
		/*
		for (String c: keys) {
			System.out.println(c + ": " + jedis.hget(key, c));
		}
		*/
		boolean estado;
		if (jedis.hget(key, "estado").equals("1"))
			estado = true;
		else
			estado = false;
		
		boolean condicionIVA;
		if (jedis.hget(key, "condicionIVA").equals("1"))
			condicionIVA = true;
		else
			condicionIVA = false;
		
		boolean operador;
		if (jedis.hget(key, "operador").equals("1"))
			operador = true;
		else
			operador = false;
		
		Usuario usuario = new Usuario(jedis.hget(key, "nombre"),
									  jedis.hget(key, "contrasenia"),
									  estado,
									  jedis.hget(key, "direccion"),
									  condicionIVA,
									  operador);
		return usuario;
	}
	
	//public List<Usuario> findAll() {
		
	//}
	
	public Usuario save(Usuario usuario) {
		String key = "user:"+usuario.getNombre();
		
		jedis.hset(key, "nombre", usuario.getNombre());
		
		jedis.hset(key, "contrasenia", usuario.getContrasenia());
		
		if (usuario.isEstado())
			jedis.hset(key, "condicionIVA", "1");
		else
			jedis.hset(key, "condicionIVA", "0");
		
		jedis.hset(key, "direccion", usuario.getDireccion());
		
		if (usuario.isCondicionIVA())
			jedis.hset(key, "condicionIVA", "1");
		else
			jedis.hset(key, "condicionIVA", "0");
		
		if (usuario.isOperador())
			jedis.hset(key, "condicionIVA", "1");
		else
			jedis.hset(key, "condicionIVA", "0");
		
		return usuario;
	}
	
	public void delete(String nombre) {
		String key = "user:"+nombre;
		jedis.del(key);
	}
}
