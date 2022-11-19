package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.demo.commons.GenericServiceImpl;
import com.example.demo.model.Producto;
import com.example.demo.repositories.ProductoRepository;

@Service
public class ProductoServiceImpl extends GenericServiceImpl<Producto, String> {

	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public CrudRepository<Producto, String> getDao() {
		return productoRepository;
	}
	
}
