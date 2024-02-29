package com.leilao.leilaosecreto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leilao.leilaosecreto.model.Leilao;
import com.leilao.leilaosecreto.repository.LeilaoRepository;

@RestController
@RequestMapping("/leiloes")
public class LeilaoController {
	
	@Autowired
	LeilaoRepository repository;
	
	@GetMapping
	public List<Leilao> listarLeiloes() {
		List<Leilao> listaLeiloes = repository.findAll();
		return listaLeiloes;
	}
	
}
