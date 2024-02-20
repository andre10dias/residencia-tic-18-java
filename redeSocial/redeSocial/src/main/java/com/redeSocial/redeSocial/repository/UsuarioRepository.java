package com.redeSocial.redeSocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redeSocial.redeSocial.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
}