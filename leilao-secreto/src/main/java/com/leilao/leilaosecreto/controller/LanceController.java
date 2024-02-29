package com.leilao.leilaosecreto.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.leilao.leilaosecreto.controller.dto.LanceDTO;
import com.leilao.leilaosecreto.controller.form.LanceForm;
import com.leilao.leilaosecreto.model.Lance;
import com.leilao.leilaosecreto.repository.LanceRepository;

import jakarta.transaction.Transactional;

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
	
	@PostMapping()
	public ResponseEntity<LanceDTO> cadastrar(@RequestBody LanceForm form, UriComponentsBuilder uriBuilder) {
		Lance lance = form.toLance();
		repository.save(lance);
		
		URI uri = uriBuilder.path("/lance/{id}").buildAndExpand(lance.getId()).toUri();
		return ResponseEntity.created(uri).body(new LanceDTO(lance));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LanceDTO> pegarPorId(@PathVariable Long id) {
		//Optional -> Pode ser que tenha o registro pode ser que não tenha
		//Elimina o erro caso o parâmetro passado não exista
		Optional<Lance> lance = repository.findById(id);
		
		if (lance.isPresent()) {
			return ResponseEntity.ok(new LanceDTO(lance.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<LanceDTO> atualizar(@PathVariable Long id, @RequestBody LanceForm form) {
		Optional<Lance> optional = repository.findById(id);
		
		if (optional.isPresent()) {
			Lance lance = form.atualizar(id, repository);
			return ResponseEntity.ok(new LanceDTO(lance));
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Lance> optional = repository.findById(id);
		
		if (optional.isPresent()) {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
