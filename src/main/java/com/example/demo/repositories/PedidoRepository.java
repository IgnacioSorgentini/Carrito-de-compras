package com.example.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Pedido;

public interface PedidoRepository extends MongoRepository<Pedido, Integer> {

}
