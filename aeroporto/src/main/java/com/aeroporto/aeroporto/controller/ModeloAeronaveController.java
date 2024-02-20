package com.aeroporto.aeroporto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aeroporto.aeroporto.model.ModeloAeronave;
import com.aeroporto.aeroporto.repository.ModeloAeronaveRepository;

@RestController
public class ModeloAeronaveController {
	
	@Autowired
	ModeloAeronaveRepository repository;
	
	@GetMapping("/listarModelo")
	public List<ModeloAeronave> listarModeloAeronaves() {
		List<ModeloAeronave> listaModeloAeronaves = repository.findAll();
		return listaModeloAeronaves;
	}
	
	@RequestMapping("/cadastrarModelo")
	public ModeloAeronave cadastrar() {
		ModeloAeronave ModeloAeronave = new ModeloAeronave(null, "Novo ModeloAeronave", "12345");
		repository.save(ModeloAeronave);
		return ModeloAeronave;
	}

}
