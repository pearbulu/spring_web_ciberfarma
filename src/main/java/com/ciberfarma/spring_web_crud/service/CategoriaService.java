package com.ciberfarma.spring_web_crud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ciberfarma.spring_web_crud.model.Categoria;
import com.ciberfarma.spring_web_crud.repository.CategoriaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaService {
	
	private final CategoriaRepository categoriaRepository;
	
	public List<Categoria> getAll() {
		return categoriaRepository.findAll();
	}
}
