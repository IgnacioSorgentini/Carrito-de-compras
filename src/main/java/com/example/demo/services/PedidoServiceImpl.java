package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.demo.commons.GenericServiceImpl;
import com.example.demo.model.Pedido;
import com.example.demo.repositories.PedidoRepository;

@Service
public class PedidoServiceImpl extends GenericServiceImpl<Pedido, Integer> {

	@Autowired
	PedidoRepository pedidoRepository;
	
	@Override
	public CrudRepository<Pedido, Integer> getDao() { return pedidoRepository; }
}
