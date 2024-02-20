package com.aeroporto.aeroporto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aeroporto.aeroporto.model.Aeroporto;
import com.aeroporto.aeroporto.repository.AeroportoRepository;

@RestController
public class AeroportoController {
	
	@Autowired
	AeroportoRepository repository;
	
	@GetMapping("/listarAeroporto")
	public List<Aeroporto> listarAeroportos() {
		List<Aeroporto> listaAeroportos = repository.findAll();
		return listaAeroportos;
	}
	
	@RequestMapping("/cadastrarAeroporto")
	public Aeroporto cadastrar() {
		Aeroporto Aeroporto = new Aeroporto(null, "Novo Aeroporto", "12345");
		repository.save(Aeroporto);
		return Aeroporto;
	}

}