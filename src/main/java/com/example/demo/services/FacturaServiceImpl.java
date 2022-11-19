package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.demo.commons.GenericServiceImpl;
import com.example.demo.model.Factura;
import com.example.demo.repositories.FacturaRepository;

@Service
public class FacturaServiceImpl extends GenericServiceImpl<Factura, Integer> {

	@Autowired
	private FacturaRepository facturaRepository;
	
	@Override
	public CrudRepository<Factura, Integer> getDao() {
		return facturaRepository;
	}
	
}

