package com.ciberfarma.spring_web_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciberfarma.spring_web_crud.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	Usuario findByCuentaAndClave(String cuenta, String clave);
}
