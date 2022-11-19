package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Factura;
import com.example.demo.services.FacturaServiceImpl;

@RestController
@RequestMapping("tpobd/factura")
public class FacturaController {

	@Autowired
	private FacturaServiceImpl facturaService;
	
	@GetMapping
	public List<Factura> getAll() {
		return facturaService.getAll();
	}
	
	@GetMapping("/pendientes")
	public List<Factura> getPendientes() {
		return null;
	}
	
	@GetMapping("/pagas")
	public List<Factura> getPagas() {
		return null;
	}
}
