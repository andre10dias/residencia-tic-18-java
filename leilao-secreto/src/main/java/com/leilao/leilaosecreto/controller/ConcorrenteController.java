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

import com.leilao.leilaosecreto.controller.dto.ConcorrenteDTO;
import com.leilao.leilaosecreto.controller.form.ConcorrenteForm;
import com.leilao.leilaosecreto.model.Concorrente;
import com.leilao.leilaosecreto.repository.ConcorrenteRepository;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/concorrente")
public class ConcorrenteController {
	
	@Autowired
	ConcorrenteRepository repository;
	
	@GetMapping
	public List<Concorrente> listarConcorrentes() {
		List<Concorrente> listaConcorrentes = repository.findAll();
		return listaConcorrentes;
	}
	
	@PostMapping()
	public ResponseEntity<ConcorrenteDTO> cadastrar(@RequestBody ConcorrenteForm form, UriComponentsBuilder uriBuilder) {
		Concorrente concorrente = form.toConcorrente();
		repository.save(concorrente);
		
		URI uri = uriBuilder.path("/concorrente/{id}").buildAndExpand(concorrente.getId()).toUri();
		return ResponseEntity.created(uri).body(new ConcorrenteDTO(concorrente));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ConcorrenteDTO> pegarPorId(@PathVariable Long id) {
		//Optional -> Pode ser que tenha o registro pode ser que não tenha
		//Elimina o erro caso o parâmetro passado não exista
		Optional<Concorrente> concorrente = repository.findById(id);
		
		if (concorrente.isPresent()) {
			return ResponseEntity.ok(new ConcorrenteDTO(concorrente.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ConcorrenteDTO> atualizar(@PathVariable Long id, @RequestBody ConcorrenteForm form) {
		Optional<Concorrente> optional = repository.findById(id);
		
		if (optional.isPresent()) {
			Concorrente concorrente = form.atualizar(id, repository);
			return ResponseEntity.ok(new ConcorrenteDTO(concorrente));
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Concorrente> optional = repository.findById(id);
		
		if (optional.isPresent()) {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
}