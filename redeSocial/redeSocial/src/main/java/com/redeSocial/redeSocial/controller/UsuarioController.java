package com.redeSocial.redeSocial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redeSocial.redeSocial.dto.UsuarioDTO;
import com.redeSocial.redeSocial.model.Usuario;
import com.redeSocial.redeSocial.repository.UsuarioRepository;

@RestController
public class UsuarioController {
	
	@Autowired
	UsuarioRepository repository;
	
	@GetMapping("/listar")
	public List<UsuarioDTO> listarUsuarios() {
		List<Usuario> listaUsuarios = repository.findAll();
		return UsuarioDTO.converter(listaUsuarios);
	}
	
	@RequestMapping("/cadastrar")
	public Usuario cadastrar() {
		Usuario usuario = new Usuario(null, "Novo usuário", "novo@novo.com", "12345");
		repository.save(usuario);
		return usuario;
	}

}
