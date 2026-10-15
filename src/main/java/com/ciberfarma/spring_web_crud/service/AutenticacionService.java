package com.ciberfarma.spring_web_crud.service;

import org.springframework.stereotype.Service;

import com.ciberfarma.spring_web_crud.dto.AutenticacionFilter;
import com.ciberfarma.spring_web_crud.model.Usuario;
import com.ciberfarma.spring_web_crud.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AutenticacionService {
	
	private final UsuarioRepository usuarioRepository;
	
	public Usuario autenticathe(AutenticacionFilter filter) {
		return usuarioRepository.findByCuentaAndClave(filter.cuenta(), filter.clave());
	}
}
