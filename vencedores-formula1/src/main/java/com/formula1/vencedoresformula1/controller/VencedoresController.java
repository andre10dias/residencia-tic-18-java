package com.formula1.vencedoresformula1.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formula1.vencedoresformula1.model.Piloto;
import com.formula1.vencedoresformula1.service.VencedoresService;

@RestController
public class VencedoresController {
	
	@GetMapping("/todos")
	public List<Piloto> listarTodosVencedores() {
		return VencedoresService.getAll();
	}
	
	@GetMapping("/brasileiros")
	public List<Piloto> listarVencedoresBrasileiros() {
		return VencedoresService.getPilotosBrasileiros();
	}
	
	@GetMapping("/top5")
	public List<Piloto> listarTopCinco() {
		return VencedoresService.getTopCinco();
	}
	
	@GetMapping("/top10")
	public List<Piloto> listarTopDez() {
		return VencedoresService.getTopDez();
	}
	
	@GetMapping("/porpais")
	public Map<String, List<Piloto>> listarVitoriasPorPais() {
		return VencedoresService.getVitoriasPorPais();
	}

}
