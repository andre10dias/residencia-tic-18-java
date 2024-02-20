package com.redeSocial.redeSocial.dto;

import com.redeSocial.redeSocial.model.Usuario;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UsuarioDTO {
	
	private String nome;
	private String email;
	private String senha;
	
	public UsuarioDTO(Usuario usuario) {
	    this.nome = usuario.getNome();
	    this.email = usuario.getEmail();
	    this.senha = usuario.getSenha();
	}
	
	public static List<UsuarioDTO> converter(List<Usuario> listaUsuarios) {
		return listaUsuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
	}

}
