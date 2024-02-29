package com.leilao.leilaosecreto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leilao.leilaosecreto.model.Lance;
import com.leilao.leilaosecreto.repository.LanceRepository;

@RestController
@RequestMapping("/lances")
public class LanceController {
	
	@Autowired
	LanceRepository repository;
	
	@GetMapping
	public List<Lance> listarLances() {
		List<Lance> listaLances = repository.findAll();
		return listaLances;
	}
	
}
