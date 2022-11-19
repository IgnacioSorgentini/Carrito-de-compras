package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.model.Carrito;

public interface CarritoRepository extends MongoRepository<Carrito, Integer> {

	//Esta bien esta query?
	@Query("{id: '?0'}")
	Optional<Carrito> findById(Integer id);
	
	/*
	@Query("{}")
	List<Carrito> findAll();
	*/
}
