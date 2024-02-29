package com.leilao.leilaosecreto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leilao.leilaosecreto.model.Concorrente;
import com.leilao.leilaosecreto.repository.ConcorrenteRepository;

@RestController
@RequestMapping("/concorrentes")
public class ConcorrenteController {
	
	@Autowired
	ConcorrenteRepository repository;
	
	@GetMapping
	public List<Concorrente> listarConcorrentes() {
		List<Concorrente> listaConcorrentes = repository.findAll();
		return listaConcorrentes;
	}
	
}