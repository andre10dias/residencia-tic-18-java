package com.aeroporto.aeroporto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aeroporto.aeroporto.model.Piloto;
import com.aeroporto.aeroporto.repository.PilotoRepository;

@RestController
public class PilotoController {
	
	@Autowired
	PilotoRepository repository;
	
	@GetMapping("/listarPiloto")
	public List<Piloto> listarPilotos() {
		List<Piloto> listaPilotos = repository.findAll();
		return listaPilotos;
	}
	
	@RequestMapping("/cadastrarPiloto")
	public Piloto cadastrar() {
		Piloto Piloto = new Piloto(null, "Novo piloto", "12345");
		repository.save(Piloto);
		return Piloto;
	}

}
