package com.ciberfarma.spring_web_crud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ciberfarma.spring_web_crud.model.Proveedor;
import com.ciberfarma.spring_web_crud.repository.ProveedorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProveedorService {
	
	private final ProveedorRepository proveedorRepository;
	
	public List<Proveedor> getAll() {
		return proveedorRepository.findAll();
	}
}
