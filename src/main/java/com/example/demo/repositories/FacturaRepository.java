package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.model.Factura;

public interface FacturaRepository extends MongoRepository<Factura, Integer> {

	@Query("{}")
	List<Factura> findAll();
	
}
